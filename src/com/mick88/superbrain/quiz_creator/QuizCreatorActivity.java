package com.mick88.superbrain.quiz_creator;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

import com.mick88.superbrain.R;
import com.mick88.superbrain.quizzes.Question;
import com.mick88.superbrain.quizzes.Quiz;
import com.mick88.superbrain.quizzes.QuizManager;

public class QuizCreatorActivity extends FragmentActivity implements OnItemClickListener
{
	Quiz quiz;
	public static final String EXTRA_CATEGORY_NAME = "category_name",
			EXTRA_QUIZ_ID = "quiz_id";
	private QuestionAdapter questionAdapter;
	private QuizManager quizManager;
	private EditText editCategory, editName;

	@Override
	protected void onCreate(Bundle arg0)
	{
		super.onCreate(arg0);
		setContentView(R.layout.activity_quiz_creator);
		getActionBar().setDisplayHomeAsUpEnabled(true);
		
		Bundle extras = getIntent().getExtras();
		quizManager = new QuizManager(getApplicationContext());
		editCategory = (EditText) findViewById(R.id.editCategoryName);
		editName = (EditText) findViewById(R.id.editQuizName);
		
		if (extras.containsKey(EXTRA_QUIZ_ID))
		{
			quiz = quizManager.getQuiz(extras.getInt(EXTRA_QUIZ_ID));
			if (quiz == null)
				throw new NullPointerException("Invalid quiz id "+String.valueOf(extras.getInt(EXTRA_QUIZ_ID)));
			setTitle(R.string.edit_quiz);
			getActionBar().setSubtitle(quiz.getName());
			
			editCategory.setText(quiz.getCategory());
			editName.setText(quiz.getName());
		}
		else this.quiz = new Quiz();		
		
		if (extras != null && extras.containsKey(EXTRA_CATEGORY_NAME))
		{
			editCategory.setText(extras.getString(EXTRA_CATEGORY_NAME));
			quiz.setCategory(extras.getString(EXTRA_CATEGORY_NAME));
		}
		
		ListView listQuestions = (ListView) findViewById(R.id.listQuestions);
		View listFooter = getLayoutInflater().inflate(R.layout.list_footer_add_question, listQuestions, false);
		listQuestions.addFooterView(listFooter);
		questionAdapter = new QuestionAdapter(this, quiz);
		listQuestions.setAdapter(questionAdapter);
		listQuestions.setOnItemClickListener(this);
		
		listFooter.findViewById(android.R.id.text1).setOnClickListener(new View.OnClickListener()
		{			
			@Override
			public void onClick(View v)
			{
				showAddQuestionDialog(null);
			}
		});
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		super.onCreateOptionsMenu(menu);
		getMenuInflater().inflate(R.menu.quiz_creator, menu);
		return true;
	}
	
	void addQuestion(Question question)
	{
		quiz.addQuestion(question);	
		questionAdapter.notifyDataSetChanged();
	}
	
	void removeQuestion(Question question)
	{
		quiz.getQuestions().remove(question);
		questionAdapter.notifyDataSetChanged();
	}
	
	void showAddQuestionDialog(final Question editedQuestion)
	{
		View addQuestionView = getLayoutInflater().inflate(R.layout.create_question, (ViewGroup) getWindow().getDecorView(), false);
		final EditText editQuestion = (EditText) addQuestionView.findViewById(R.id.editQuestion),
				editAnswer = (EditText) addQuestionView.findViewById(R.id.editAnswer),
				editAnswer2 = (EditText) addQuestionView.findViewById(R.id.editAnswer2),
				editAnswer3 = (EditText) addQuestionView.findViewById(R.id.editAnswer3);
		
		if (editedQuestion != null)
		{
			editQuestion.setText(editedQuestion.getQuestion());
			editAnswer.setText(editedQuestion.getCorrectAnswer().toString());
			if (editedQuestion.getFakeAnswers().isEmpty() == false)
			{
				editAnswer2.setText(editedQuestion.getFakeAnswers().get(0).toString());
				if (editedQuestion.getFakeAnswers().size() > 1)
				{
					editAnswer3.setText(editedQuestion.getFakeAnswers().get(1).toString());
				}
			}
		}
		int confirmBtnText = editedQuestion == null ? R.string.add : R.string.update;
		AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this).setView(addQuestionView)
			.setTitle(R.string.add_question)
			.setPositiveButton(confirmBtnText, new OnClickListener()
			{
				
				@Override
				public void onClick(DialogInterface dialog, int which)
				{
					final Question question;
					if (editedQuestion == null) question = new Question();
					else question = editedQuestion;
					
					question.setQuestion(editQuestion.getText().toString());
					question.setCorrectAnswer(editAnswer.getText().toString());
					question.addFakeAnswer(editAnswer2.getText().toString());
					question.addFakeAnswer(editAnswer3.getText().toString());
					
					if (editedQuestion == null)					
						addQuestion(question);
					else 
						questionAdapter.notifyDataSetChanged();
				}
			})
			.setNegativeButton(android.R.string.cancel, null);
		if (editedQuestion != null) dialogBuilder.setNeutralButton("Delete", new OnClickListener()
		{
			
			@Override
			public void onClick(DialogInterface dialog, int which)
			{
				removeQuestion(editedQuestion);
			}
		});
		dialogBuilder.show();
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		switch (item.getItemId())
		{
			case R.id.menu_save:
				quiz.setCategory(editCategory.getText().toString());
				quiz.setName(editName.getText().toString());
				editCategory.setError(null);
				editName.setError(null);
				if (TextUtils.isEmpty(editCategory.getText()))
				{
					editCategory.setError(getString(R.string.please_specify_category));
					editCategory.requestFocus();
					return true;
				}
				if (TextUtils.isEmpty(editName.getText()))
				{
					editName.setError(getString(R.string.please_enter_name_for_your_quiz));
					editName.requestFocus();
					return true;
				}
				
				if (quiz.validate())
				{
					quizManager.replace(quiz);
					Intent intent = new Intent();
					intent.putExtra(EXTRA_CATEGORY_NAME, quiz.getCategory());
					setResult(RESULT_OK, intent);
					finish();
				}
				else
				{
					new AlertDialog.Builder(this)
						.setMessage(R.string.alert_quiz_not_complete)
						.setPositiveButton(android.R.string.ok, null)
						.show();
				}
				return true;
			case android.R.id.home:
				onBackPressed();
				return true;
			case R.id.menu_delete:
				new AlertDialog.Builder(this).setMessage(getString(R.string.delete_this_quiz_, quiz.getName()))
					.setTitle(R.string.delete_quiz)
					.setPositiveButton("Delete", new OnClickListener()
					{
						
						@Override
						public void onClick(DialogInterface dialog, int which)
						{
							quizManager.delete(quiz);
							setResult(RESULT_OK);
							finish();
						}
					})
					.setNegativeButton(android.R.string.cancel, null)
					.show();
				return true;
			default:
				return super.onOptionsItemSelected(item);
		}		
	}

	@Override
	public void onItemClick(AdapterView<?> adapterView, View arg1, int position, long arg3)
	{
		Question question = (Question) adapterView.getItemAtPosition(position);	
		showAddQuestionDialog(question);
	}
}

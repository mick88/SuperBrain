package com.mick88.superbrain.quiz_creator;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ListView;

import com.mick88.superbrain.R;
import com.mick88.superbrain.quizzes.Question;
import com.mick88.superbrain.quizzes.Quiz;

public class QuizCreatorActivity extends FragmentActivity
{
	Quiz quiz;
	public static final String EXTRA_CATEGORY_NAME = "category_name";
	private QuestionAdapter questionAdapter;

	@Override
	protected void onCreate(Bundle arg0)
	{
		super.onCreate(arg0);
		setContentView(R.layout.activity_quiz_creator);
		
		this.quiz = new Quiz();
		
		EditText editCategory = (EditText) findViewById(R.id.editCategoryName);
		Bundle extras = getIntent().getExtras();
		if (extras != null && extras.containsKey(EXTRA_CATEGORY_NAME))
		{
			editCategory.setText(extras.getString(EXTRA_CATEGORY_NAME));
			quiz.setCategory(extras.getString(EXTRA_CATEGORY_NAME));
		}
		
		ListView listQuestions = (ListView) findViewById(R.id.listQuestions);
		questionAdapter = new QuestionAdapter(this, quiz);
		listQuestions.setAdapter(questionAdapter);
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
	
	void showAddQuestionDialog()
	{
		final View addQuestionView = getLayoutInflater().inflate(R.layout.create_question, (ViewGroup) getWindow().getDecorView(), false);
		
		new AlertDialog.Builder(this).setView(addQuestionView)
			.setTitle(R.string.add_question)
			.setPositiveButton(R.string.add, new OnClickListener()
			{
				
				@Override
				public void onClick(DialogInterface dialog, int which)
				{
					EditText editQuestion = (EditText) addQuestionView.findViewById(R.id.editQuestion),
							editAnswer = (EditText) addQuestionView.findViewById(R.id.editAnswer),
							editAnswer2 = (EditText) addQuestionView.findViewById(R.id.editAnswer2),
							editAnswer3 = (EditText) addQuestionView.findViewById(R.id.editAnswer3);
					Question question = new Question(editQuestion.getText().toString(), editAnswer.getText().toString());
					question.addFakeAnswer(editAnswer2.getText().toString());
					question.addFakeAnswer(editAnswer3.getText().toString());
					
					addQuestion(question);
				}
			})
			.setNegativeButton(android.R.string.cancel, null)
			.show();
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		switch (item.getItemId())
		{
			case R.id.menu_add_question:
				showAddQuestionDialog();
				return true;
			default:
				return super.onOptionsItemSelected(item);
		}		
	}
}

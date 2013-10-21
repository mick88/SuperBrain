package com.mick88.superbrain.quiz;

import java.util.HashMap;
import java.util.Locale;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.mick88.superbrain.R;
import com.mick88.superbrain.SuperBrainApplication;
import com.mick88.superbrain.quizzes.Answer;
import com.mick88.superbrain.quizzes.Question;
import com.mick88.superbrain.quizzes.Quiz;

public class QuizActivity extends Activity
{

	Quiz quiz;
	int currentQuestionId = 0,
			correctAnswers=0;
	HashMap<Question, Answer> answeredQuestions;
	
	TextView tvQuestion;
	Button btnAnswer1, btnAnswer2, btnAnswer3;
	
	public static final String 
		EXTRA_ID = "quiz_id";
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_quiz);
		
		getActionBar().setDisplayHomeAsUpEnabled(true);
		
		tvQuestion = (TextView) findViewById(R.id.tvQuestion);
		
		btnAnswer1 = (Button) findViewById(R.id.btnAnswer1);
		btnAnswer2 = (Button) findViewById(R.id.btnAnswer2);
		btnAnswer3 = (Button) findViewById(R.id.btnAnswer3);
		
		answeredQuestions = new HashMap<Question, Answer>();
		
		Intent intent = getIntent();
		if (intent != null)
		{
			Bundle extras = intent.getExtras();
			int quiz_id = extras.getInt(EXTRA_ID);
			
			this.quiz = ((SuperBrainApplication) getApplication()).getQuizManager().getQuiz(quiz_id);
			setTitle(String.format(Locale.ENGLISH, "%s: %s", quiz.getCategory(), quiz.getName()));
			
			displayCurrentQuestion();
		}
		else finish();
	}
	
	private void onAnswerSelected(Answer answer)
	{
		answeredQuestions.put(getCurrentQuestion(), answer);
		if (getCurrentQuestion().isCorrectAnswer(answer)) correctAnswers++;
		currentQuestionId++;
		if (currentQuestionId < quiz.getQuestions().size()) displayCurrentQuestion();
		else onQuizFinished();
	}
	
	void onQuizFinished()
	{
		AlertDialog dialog = new AlertDialog.Builder(this)
			.setTitle(R.string.app_name)
			.setIcon(R.drawable.ic_launcher)
			.setMessage(String.format(Locale.ENGLISH, "Result: %d/%d correct!", correctAnswers, quiz.getNumQuestions()))
			.setPositiveButton(android.R.string.ok, new Dialog.OnClickListener()
			{
				
				@Override
				public void onClick(DialogInterface dialog, int which)
				{
					finish();
					
				}
			})
			.setNeutralButton("Show answers", new Dialog.OnClickListener()
			{
				
				@Override
				public void onClick(DialogInterface dialog, int which)
				{
					finish();
					
				}
			})
			.setCancelable(false)
			.create();
		dialog.show();
	}
	
	private void displayCurrentQuestion()
	{
		Question question = getCurrentQuestion();
		
		tvQuestion.setText(question.getQuestion());
		
		final Answer[] answers = new Answer[] {question.getCorrectAnswer(), 
				question.getFakeAnswers().get(0), 
				question.getFakeAnswers().get(1)};
		
		btnAnswer1.setText(answers[0].getText());
		btnAnswer1.setOnClickListener(new OnClickListener()
		{
			
			@Override
			public void onClick(View v)
			{
				onAnswerSelected(answers[0]);
				
			}
		});
		
		btnAnswer2.setText(answers[1].getText());
		btnAnswer2.setOnClickListener(new OnClickListener()
		{
			
			@Override
			public void onClick(View v)
			{
				onAnswerSelected(answers[1]);
				
			}
		});
		
		btnAnswer3.setText(answers[2].getText());
		btnAnswer3.setOnClickListener(new OnClickListener()
		{
			
			@Override
			public void onClick(View v)
			{
				onAnswerSelected(answers[2]);
				
			}
		});
	}
	
	private Question getCurrentQuestion()
	{
		return quiz.getQuestions().get(currentQuestionId);
	}
	
	@Override
	public boolean onMenuItemSelected(int featureId, MenuItem item)
	{
		switch (item.getItemId())
		{
		case android.R.id.home:
			onBackPressed();
			return true;
		}
		return super.onMenuItemSelected(featureId, item);
	}
	
	@Override
	public void onBackPressed()
	{
		// TODO Auto-generated method stub
		super.onBackPressed();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		getMenuInflater().inflate(R.menu.quiz, menu);
		return false;
	}

}

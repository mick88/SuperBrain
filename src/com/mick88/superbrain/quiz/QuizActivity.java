package com.mick88.superbrain.quiz;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Random;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

import com.mick88.superbrain.R;
import com.mick88.superbrain.SuperBrainApplication;
import com.mick88.superbrain.quizzes.Answer;
import com.mick88.superbrain.quizzes.Question;
import com.mick88.superbrain.quizzes.Quiz;

public class QuizActivity extends Activity implements OnItemClickListener
{

	Quiz quiz;
	int currentQuestionId = 0,
			correctAnswers=0;
	HashMap<Question, Answer> answeredQuestions;
	
	TextView tvQuestion;
	
	public static final String 
		EXTRA_ID = "quiz_id";
	private ListView listAnswers;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_quiz);
		
		getActionBar().setDisplayHomeAsUpEnabled(true);
		
		tvQuestion = (TextView) findViewById(R.id.tvQuestion);
		
		listAnswers = (ListView) findViewById(android.R.id.list);
		listAnswers.setOnItemClickListener(this);
		
		answeredQuestions = new HashMap<Question, Answer>();
		
		Intent intent = getIntent();
		if (intent != null)
		{
			Bundle extras = intent.getExtras();
			int quiz_id = extras.getInt(EXTRA_ID);
			
			this.quiz = ((SuperBrainApplication) getApplication()).getQuizManager().getQuiz(quiz_id);
			setTitle(String.format(Locale.ENGLISH, "%s: %s", quiz.getCategory(), quiz.getName()));
			
			quiz.randomizeQuestions(new Random(System.currentTimeMillis()));
			
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
		ProgressBar progressBar = (ProgressBar) findViewById(android.R.id.progress);
		progressBar.setProgress(progressBar.getMax());
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
		List<Answer> answers = question.getPossibleAnswersRandomized(new Random(System.currentTimeMillis()));
		
		ArrayAdapter<Answer> answerAdapter = new QuizAnswerAdapter(this, answers);
		listAnswers.setAdapter(answerAdapter);
		
		ProgressBar progressBar = (ProgressBar) findViewById(android.R.id.progress);
		TextView tvProgress = (TextView) findViewById(R.id.tvProgress);
		progressBar.setMax(quiz.getNumQuestions());
		progressBar.setProgress(currentQuestionId);
		tvProgress.setText(String.format(Locale.ENGLISH, "%d of %d", currentQuestionId+1, quiz.getNumQuestions()));
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
	public boolean onCreateOptionsMenu(Menu menu)
	{
		getMenuInflater().inflate(R.menu.quiz, menu);
		return false;
	}

	@Override
	public void onItemClick(AdapterView<?> adapterView, View view, int position, long arg3)
	{
		Answer selectedAnswer = (Answer) adapterView.getItemAtPosition(position);
		onAnswerSelected(selectedAnswer);
	}

}

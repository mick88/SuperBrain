package com.mick88.superbrain.quiz.answers_activity;

import java.util.Map;
import java.util.Map.Entry;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import com.mick88.superbrain.quizzes.Answer;
import com.mick88.superbrain.quizzes.Question;

public class AnswersActivity extends ListActivity
{
	public static final String EXTRA_ANSWER_MAP = "answers";
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		@SuppressWarnings("unchecked")
		AnsweredQuestion [] answers = getAnswerList((Map<Question, Answer>) getIntent().getSerializableExtra(EXTRA_ANSWER_MAP));
		ArrayAdapter<AnsweredQuestion> answerAdapter = new AnswerAdapter(this, answers); 
		setListAdapter(answerAdapter);
	}
	
	AnsweredQuestion[] getAnswerList(Map<Question, Answer> answerMap)
	{
		AnsweredQuestion[] answers = new AnsweredQuestion[answerMap.size()];
		int n=0;
		for (Entry<Question, Answer> answer : answerMap.entrySet())
			answers[n++] = new AnsweredQuestion(answer.getKey(), answer.getValue());
		return answers;		
	}
}

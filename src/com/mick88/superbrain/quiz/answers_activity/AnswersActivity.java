package com.mick88.superbrain.quiz.answers_activity;

import java.util.Map;
import java.util.Map.Entry;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import com.mick88.superbrain.quizzes.Answer;
import com.mick88.superbrain.quizzes.Question;
import com.mick88.superbrain.quizzes.Quiz;

public class AnswersActivity extends ListActivity
{
	public static final String EXTRA_ANSWER_MAP = "answers";
	public static final String EXTRA_QUIZ = "quiz";
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		getListView().setDividerHeight(0);
		getListView().setSelector(android.R.color.transparent);
		Quiz quiz = (Quiz) getIntent().getSerializableExtra(EXTRA_QUIZ);
		getActionBar().setTitle(quiz.getName());
		getActionBar().setSubtitle(quiz.getCategory());
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

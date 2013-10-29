package com.mick88.superbrain.quiz_creator;

import android.content.Context;
import android.widget.ArrayAdapter;

import com.mick88.superbrain.quizzes.Question;
import com.mick88.superbrain.quizzes.Quiz;

public class QuestionAdapter extends ArrayAdapter<Question>
{
	
	final Quiz quiz;
	
	public QuestionAdapter(Context context, Quiz quiz)
	{
		super(context, android.R.layout.simple_list_item_1, android.R.id.text1, quiz.getQuestions());
		this.quiz = quiz;
	}
	
}

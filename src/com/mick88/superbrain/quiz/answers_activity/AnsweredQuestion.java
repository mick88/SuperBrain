package com.mick88.superbrain.quiz.answers_activity;

import java.util.Locale;

import com.mick88.superbrain.quizzes.Answer;
import com.mick88.superbrain.quizzes.Question;

public class AnsweredQuestion
{
	Question question;
	Answer selectedAnswer;
	
	public AnsweredQuestion(Question question, Answer answer)
	{
		if (question == null)
			throw new NullPointerException("Question must not be null");
		else if (answer == null)
			throw new NullPointerException("Answer must not be null");
		
		this.question = question;
		this.selectedAnswer = answer;
	}

	public boolean isCorrect()
	{
		return question.isCorrectAnswer(selectedAnswer);
	}
	
	@Override
	public String toString()
	{
		return String.format(Locale.ENGLISH, "%s: %s", question, selectedAnswer);
	}
	
	public Question getQuestion()
	{
		return question;
	}
	
	public Answer getSelectedAnswer()
	{
		return selectedAnswer;
	}
}

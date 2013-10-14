package com.mick88.superbrain.quizzes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Question implements Serializable
{
	private static final long serialVersionUID = 1L;
	String question;
	Answer correctAnswer=null;
	List<Answer> fakeAnswers;
	
	public Question(String question, String answer)
	{
		this.question = question;
		this.correctAnswer = new Answer(answer);
		
		this.fakeAnswers = new ArrayList<Answer>();
	}
	
	public Question setFakeAnswers(List<Answer> fakeAnswers)
	{
		this.fakeAnswers = fakeAnswers;
		return this;
	}
	
	public Question setFakeAnswers(String [] fakeAnswers)
	{
		for (String a : fakeAnswers) this.fakeAnswers.add(new Answer(a));
		return this;
	}
	
	public void addFakeAnswer(Answer fakeAnswer)
	{
		fakeAnswers.add(fakeAnswer);
	}
	
	public String getQuestion()
	{
		return question;
	}
	
	public Answer getCorrectAnswer()
	{
		return correctAnswer;
	}
	
	public List<Answer> getFakeAnswers()
	{
		return fakeAnswers;
	}
	
	public boolean isCorrectAnswer(Answer answer)
	{
		return correctAnswer.equals(answer);
	}
}

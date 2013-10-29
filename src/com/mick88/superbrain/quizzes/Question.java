package com.mick88.superbrain.quizzes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

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
	
	public void addFakeAnswer(String answerString)
	{
		addFakeAnswer(new Answer(answerString));
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
	
	public List<Answer> getPossibleAnswers()
	{
		List<Answer> result = new ArrayList<Answer>(fakeAnswers.size() + 1);
		result.add(correctAnswer);
		result.addAll(fakeAnswers);
		return result;
	}
	
	public List<Answer> getPossibleAnswersRandomized(Random random)
	{
		List<Answer> result = getPossibleAnswers();
		Collections.shuffle(result, random);
		return result;
	}
	
	public boolean isCorrectAnswer(Answer answer)
	{
		return correctAnswer.equals(answer);
	}
	
	@Override
	public String toString()
	{
		return question;
	}
}

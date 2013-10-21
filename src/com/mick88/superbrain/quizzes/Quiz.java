package com.mick88.superbrain.quizzes;

import java.util.ArrayList;
import java.util.List;

import com.michaldabski.msqlite.Annotations.PrimaryKey;

public class Quiz
{
	@PrimaryKey
	Integer id=null;
	List<Question> questions;
	String category;
	String name;
	String description;
	
	public Quiz()
	{
		this.questions = new ArrayList<Question>();
		this.description = "";
	}
	
	public Quiz(String category, String name)
	{
		this();
		this.category = category;
		this.name = name;
	}
	
	public Quiz(String category, String name, String description)
	{
		this(category, name);
		this.description = description;
	}
	
	public Quiz addQuestion(Question question)
	{
		questions.add(question);
		return this;
	}
	
	public List<Question> getQuestions()
	{
		return questions;
	}
	
	public String getCategory()
	{
		return category;
	}
	
	public String getName()
	{
		return name;
	}
	
	public int getNumQuestions()
	{
		return questions.size();
	}
	
	/**
	 * List of all correct answers in all questions
	 */
	public List<Answer> getAnswers()
	{
		ArrayList<Answer> result = new ArrayList<Answer>();
		
		for (Question q : questions)
		{
			result.add(q.getCorrectAnswer());
		}
		
		return result;
	}
	
	public Integer getId()
	{
		return id;
	}
	
	@Override
	public String toString()
	{
		return name;
	}
}

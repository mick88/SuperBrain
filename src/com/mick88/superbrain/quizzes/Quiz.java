package com.mick88.superbrain.quizzes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import android.text.TextUtils;

import com.michaldabski.msqlite.Annotations.PrimaryKey;

public class Quiz implements Serializable
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
	
	public void randomizeQuestions(Random random)
	{
		Collections.shuffle(questions, random);
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
	
	@Override
	public int hashCode()
	{
		if (id != null) return id.hashCode();
		else return name.hashCode();
	}
	
	/**
	 * Checks whether quiz is valid:
	 * must have specified name and category
	 * at least one question
	 * All questions must be valid
	 * @return
	 */
	public boolean validate()
	{
		return (TextUtils.isEmpty(name) == false && TextUtils.isEmpty(category) == false && questions.isEmpty() == false);
	}
	
	@Override
	public boolean equals(Object o)
	{

		if (o instanceof Quiz)
			if (id != null)
				return id.equals(((Quiz) o).id);
			else 
				return name.equals(((Quiz) o).name);
		return super.equals(o);
	}
	
	public void setCategory(String category)
	{
		this.category = category;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
}

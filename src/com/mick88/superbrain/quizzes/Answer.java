package com.mick88.superbrain.quizzes;

import java.io.Serializable;

public class Answer implements Serializable
{
	private static final long serialVersionUID = 1L;
	String text;
	
	public Answer(String answer)
	{
		this.text = answer;
	}
	
	public String getText()
	{
		return text;
	}
	
	@Override
	public boolean equals(Object o)
	{
		if (o instanceof Answer)
		{
			Answer a = (Answer) o;
			return text.equalsIgnoreCase(a.getText());
		}
		return false;
	}
	
	@Override
	public String toString()
	{
		return getText();
	}
}

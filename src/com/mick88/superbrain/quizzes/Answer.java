package com.mick88.superbrain.quizzes;

public class Answer
{
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

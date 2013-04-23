package com.mick88.superbrain;

import android.app.Application;

import com.mick88.superbrain.quizzes.QuizManager;

public class SuperBrainApplication extends Application
{
	QuizManager quizManager;
	@Override
	public void onCreate()
	{
		this.quizManager = new QuizManager();
		super.onCreate();
	}
	
	public QuizManager getQuizManager()
	{
		return quizManager;
	}

}

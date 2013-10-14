package com.mick88.superbrain;

import android.content.Context;

import com.michaldabski.msqlite.MSQLiteOpenHelper;
import com.mick88.superbrain.quizzes.Quiz;

public class DatabaseHelper extends MSQLiteOpenHelper
{

	private static final int DATABASE_VERSION = 1;
	private static final String DATABASE_NAME = "super_brain.db";

	public DatabaseHelper(Context context)
	{
		super(context, DATABASE_NAME, null, DATABASE_VERSION, new Class<?>[]{
				Quiz.class,
		});
	}	
}

package com.mick88.superbrain;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase.CursorFactory;

import com.michaldabski.msqlite.MSQLiteOpenHelper;

public class DatabaseHelper extends MSQLiteOpenHelper
{

	private static final int DATABASE_VERSION = 1;
	private static final String DATABASE_NAME = "super_brain.db";

	public DatabaseHelper(Context context, String name, CursorFactory factory,
			int version, Class<?>[] trackedClasses)
	{
		super(context, DATABASE_NAME, null, DATABASE_VERSION, new Class<?>[]{
				
		});
	}
	
}

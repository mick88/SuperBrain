package com.mick88.superbrain.quizzes;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.michaldabski.msqlite.models.Table;
import com.mick88.superbrain.DatabaseHelper;

public class QuizManager extends DatabaseHelper
{
	public QuizManager(Context context)
	{
		super(context);
	}
	
	@Override
	public void onCreate(SQLiteDatabase db)
	{
		super.onCreate(db);
		createQuizzes(db);
	}
	
	/**
	 * Generate quizzes and insert them into the database
	 * @param database
	 */
	private void createQuizzes(SQLiteDatabase database)
	{	
		List<Quiz> newQuizzes = new ArrayList<Quiz>();
		newQuizzes.add(new Quiz("Computer Science", "Programming")
				.addQuestion(new Question("How do you break out of a loop?", "break;").setFakeAnswers(new String[] {"continue;", "return;"}))
				.addQuestion(new Question("Which of these is not OOP?", "C").setFakeAnswers(new String[] {"C#", "Java"}))
				.addQuestion(new Question("Which function is called first?", "main()").setFakeAnswers(new String[] {"onCreate()", "start()"}))
				.addQuestion(new Question("Which loop evaluates condition after execution?", "do ... while").setFakeAnswers(new String[] {"foreach", "while"}))
				.addQuestion(new Question("Which language is commonly used to program for Android?", "Java").setFakeAnswers(new String[] {"C#", "C++"}))
				);
		
		newQuizzes.add(new Quiz("Computer Science", "C#")
		.addQuestion(new Question("Object template is a ", "Class").setFakeAnswers(new String[] {"Method", "Pointer"}))
		.addQuestion(new Question("Increasing by 1 is", "increment").setFakeAnswers(new String[] {"decrement", "return"}))
		.addQuestion(new Question("Is called when object is instantiated", "Constructor").setFakeAnswers(new String[] {"main()", "destructor"}))
		);
		
		newQuizzes.add(new Quiz("Computer Science", "HCI")
		.addQuestion(new Question("Mismatch between a user's goal for action and the means to execute that goal is called", "gulf of execution").setFakeAnswers(new String[] {"gulf of evaluation", "action"}))
		.addQuestion(new Question("What does HCI stand for?", "Human Computer Interaction").setFakeAnswers(new String[] {"Human Computer Interface", "Human Computer Industry"}))
		.addQuestion(new Question("Which one of these would NOT be found in a good HCI? ", "A long command line to achieve a function ").setFakeAnswers(new String[] {"Icons that can have specific meanings.", "Common short cuts, like CTRL+Z for undo."}))
		.addQuestion(new Question("Which of these films uses futuristic HCI?", "Minority Report").setFakeAnswers(new String[] {"Bambi", "Speed"}))
		);
		
		newQuizzes.add(new Quiz("Trivia", "Common knowledge")
		.addQuestion(new Question("What year did man land on moon?", "1969").setFakeAnswers(new String[] {"1988", "1971"}))
		.addQuestion(new Question("President of Ireland is...", "Michael D. Higgins").setFakeAnswers(new String[] {"Michael Dabski", "Bono"}))
		.addQuestion(new Question("Which of the following is not a current gen game console ", "Cube").setFakeAnswers(new String[] {"XBOX 360", "Play Station 3"}))
		.addQuestion(new Question("What are 3 main colours?", "Red, Green & Blue").setFakeAnswers(new String[] {"Red, Black & Yellow", "White, Green and Yellow"}))
		);
		
		newQuizzes.add(new Quiz("Mathematics", "Basic operations")
		.addQuestion(new Question("1+1=", "2").setFakeAnswers(new String[] {"1", "3"}))
		.addQuestion(new Question("5 x 5", "25").setFakeAnswers(new String[] {"30", "15"}))
		.addQuestion(new Question("12 + 5", "17").setFakeAnswers(new String[] {"15", "18"}))
		.addQuestion(new Question("13 - 5", "7").setFakeAnswers(new String[] {"30", "15"}))
		);
		
		insert(database, Quiz.class, newQuizzes);
	}
	
	public List<Quiz> getQuizzes(String category)
	{
		return select(Quiz.class, "`category`=?", new String[]{category}, null, null);
	}
	
	public Quiz getQuiz(int id)
	{
		SQLiteDatabase database = getReadableDatabase();
		Quiz quiz = selectFirst(database, Quiz.class, "`id`=?", new String[]{String.valueOf(id)}, null);
		database.close();
		return quiz;
	}
	
	public String [] getCategories()
	{
		final String COL_CATEGORY = "category";
		SQLiteDatabase database = getReadableDatabase();
		Cursor cursor = database.query(true, new Table(Quiz.class).getName(), new String[]{COL_CATEGORY}, null, null, COL_CATEGORY, null, COL_CATEGORY, null);
		String [] categories = new String[cursor.getCount()];
		int i=0;
		while (cursor.moveToNext())
			categories[i++] = cursor.getString(0);
		database.close();
		
		return categories;
	}
}

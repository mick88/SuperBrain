package com.mick88.superbrain.quizzes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class QuizManager
{
	HashMap<String, ArrayList<Quiz>> quizzes;
	ArrayList<String> categories;
	
	public QuizManager()
	{
		quizzes = new HashMap<String, ArrayList<Quiz>>();
		categories = new ArrayList<String>();
		
		addQuiz(new Quiz("Programming", "General")
				.addQuestion(new Question("How do you break out of a loop?", "break;").setFakeAnswers(new String[] {"continue;", "return;"}))
				.addQuestion(new Question("Which of these is not OOP?", "C").setFakeAnswers(new String[] {"C#", "Java"}))
				.addQuestion(new Question("Which function is called first?", "main()").setFakeAnswers(new String[] {"onCreate()", "start()"}))
				);
		
		addQuiz(new Quiz("Programming", "C#")
		.addQuestion(new Question("Object template is a ", "Class").setFakeAnswers(new String[] {"Method", "Pointer"}))
		.addQuestion(new Question("Increasing by 1 is", "increment").setFakeAnswers(new String[] {"decrement", "return"}))
		.addQuestion(new Question("Is called when object is instantiated", "Constructor").setFakeAnswers(new String[] {"main()", "destructor"}))
		);
		
		addQuiz(new Quiz("Mathematics", "Basic operations")
		.addQuestion(new Question("1+1=", "2").setFakeAnswers(new String[] {"1", "3"}))
		.addQuestion(new Question("5 x 5", "25").setFakeAnswers(new String[] {"30", "15"}))
		);
		
		addQuiz(new Quiz("Mathematics", "Number Theory")
		.addQuestion(new Question("1+1=", "2").setFakeAnswers(new String[] {"1", "3"}))
		.addQuestion(new Question("5 x 5", "25").setFakeAnswers(new String[] {"30", "15"}))
		);
		
		addQuiz(new Quiz("Mathematics", "Statistics")
		.addQuestion(new Question("1+1=", "2").setFakeAnswers(new String[] {"1", "3"}))
		.addQuestion(new Question("5 x 5", "25").setFakeAnswers(new String[] {"30", "15"}))
		);
		
		addQuiz(new Quiz("Mathematics", "Algebra")
		.addQuestion(new Question("1+1=", "2").setFakeAnswers(new String[] {"1", "3"}))
		.addQuestion(new Question("5 x 5", "25").setFakeAnswers(new String[] {"30", "15"}))
		);
		
		addQuiz(new Quiz("Mathematics", "Sets")
		.addQuestion(new Question("1+1=", "2").setFakeAnswers(new String[] {"1", "3"}))
		.addQuestion(new Question("5 x 5", "25").setFakeAnswers(new String[] {"30", "15"}))
		);
		
		addQuiz(new Quiz("Programming", "Android")
		.addQuestion(new Question("How do you break out of a loop?", "break;").setFakeAnswers(new String[] {"continue;", "return;"}))
		.addQuestion(new Question("Which of these is not OOP?", "C").setFakeAnswers(new String[] {"C#", "Java"}))
		.addQuestion(new Question("Which of these is not OOP?", "C").setFakeAnswers(new String[] {"C#", "Java"}))
		.addQuestion(new Question("Which of these is not OOP?", "C").setFakeAnswers(new String[] {"C#", "Java"}))
		.addQuestion(new Question("Which of these is not OOP?", "C").setFakeAnswers(new String[] {"C#", "Java"}))
		.addQuestion(new Question("Which function is called first?", "main()").setFakeAnswers(new String[] {"onCreate()", "start()"}))
		);
		
		addQuiz(new Quiz("Programming", "Linux Shell")
		.addQuestion(new Question("How do you break out of a loop?", "break;").setFakeAnswers(new String[] {"continue;", "return;"}))
		.addQuestion(new Question("Which of these is not OOP?", "C").setFakeAnswers(new String[] {"C#", "Java"}))
		.addQuestion(new Question("Which of these is not OOP?", "C").setFakeAnswers(new String[] {"C#", "Java"}))
		.addQuestion(new Question("Which of these is not OOP?", "C").setFakeAnswers(new String[] {"C#", "Java"}))
		.addQuestion(new Question("Which of these is not OOP?", "C").setFakeAnswers(new String[] {"C#", "Java"}))
		.addQuestion(new Question("Which function is called first?", "main()").setFakeAnswers(new String[] {"onCreate()", "start()"}))
		);
		
		addQuiz(new Quiz("Programming", "Basic")
		.addQuestion(new Question("How do you break out of a loop?", "break;").setFakeAnswers(new String[] {"continue;", "return;"}))
		.addQuestion(new Question("Which of these is not OOP?", "C").setFakeAnswers(new String[] {"C#", "Java"}))
		.addQuestion(new Question("Which of these is not OOP?", "C").setFakeAnswers(new String[] {"C#", "Java"}))
		.addQuestion(new Question("Which of these is not OOP?", "C").setFakeAnswers(new String[] {"C#", "Java"}))
		.addQuestion(new Question("Which of these is not OOP?", "C").setFakeAnswers(new String[] {"C#", "Java"}))
		.addQuestion(new Question("Which function is called first?", "main()").setFakeAnswers(new String[] {"onCreate()", "start()"}))
		);
		
		addQuiz(new Quiz("Programming", "Visual Studio")
		.addQuestion(new Question("How do you break out of a loop?", "break;").setFakeAnswers(new String[] {"continue;", "return;"}))
		.addQuestion(new Question("Which of these is not OOP?", "C").setFakeAnswers(new String[] {"C#", "Java"}))
		.addQuestion(new Question("Which of these is not OOP?", "C").setFakeAnswers(new String[] {"C#", "Java"}))
		.addQuestion(new Question("Which of these is not OOP?", "C").setFakeAnswers(new String[] {"C#", "Java"}))
		.addQuestion(new Question("Which of these is not OOP?", "C").setFakeAnswers(new String[] {"C#", "Java"}))
		.addQuestion(new Question("Which function is called first?", "main()").setFakeAnswers(new String[] {"onCreate()", "start()"}))
		);
		
		addQuiz(new Quiz("Programming", "Delphi")
		.addQuestion(new Question("How do you break out of a loop?", "break;").setFakeAnswers(new String[] {"continue;", "return;"}))
		.addQuestion(new Question("Which of these is not OOP?", "C").setFakeAnswers(new String[] {"C#", "Java"}))
		.addQuestion(new Question("Which of these is not OOP?", "C").setFakeAnswers(new String[] {"C#", "Java"}))
		.addQuestion(new Question("Which of these is not OOP?", "C").setFakeAnswers(new String[] {"C#", "Java"}))
		.addQuestion(new Question("Which of these is not OOP?", "C").setFakeAnswers(new String[] {"C#", "Java"}))
		.addQuestion(new Question("Which function is called first?", "main()").setFakeAnswers(new String[] {"onCreate()", "start()"}))
		);
		
		addQuiz(new Quiz("Programming", "Haskell")
		.addQuestion(new Question("How do you break out of a loop?", "break;").setFakeAnswers(new String[] {"continue;", "return;"}))
		.addQuestion(new Question("Which of these is not OOP?", "C").setFakeAnswers(new String[] {"C#", "Java"}))
		.addQuestion(new Question("Which of these is not OOP?", "C").setFakeAnswers(new String[] {"C#", "Java"}))
		.addQuestion(new Question("Which of these is not OOP?", "C").setFakeAnswers(new String[] {"C#", "Java"}))
		.addQuestion(new Question("Which of these is not OOP?", "C").setFakeAnswers(new String[] {"C#", "Java"}))
		.addQuestion(new Question("Which function is called first?", "main()").setFakeAnswers(new String[] {"onCreate()", "start()"}))
		);
		
		addQuiz(new Quiz("Programming", "Assembly")
		.addQuestion(new Question("How do you break out of a loop?", "break;").setFakeAnswers(new String[] {"continue;", "return;"}))
		.addQuestion(new Question("Which of these is not OOP?", "C").setFakeAnswers(new String[] {"C#", "Java"}))
		.addQuestion(new Question("Which of these is not OOP?", "C").setFakeAnswers(new String[] {"C#", "Java"}))
		.addQuestion(new Question("Which of these is not OOP?", "C").setFakeAnswers(new String[] {"C#", "Java"}))
		.addQuestion(new Question("Which of these is not OOP?", "C").setFakeAnswers(new String[] {"C#", "Java"}))
		.addQuestion(new Question("Which function is called first?", "main()").setFakeAnswers(new String[] {"onCreate()", "start()"}))
		);
		
		addQuiz(new Quiz("Programming", "C")
		.addQuestion(new Question("How do you break out of a loop?", "break;").setFakeAnswers(new String[] {"continue;", "return;"}))
		.addQuestion(new Question("Which of these is not OOP?", "C").setFakeAnswers(new String[] {"C#", "Java"}))
		.addQuestion(new Question("Which of these is not OOP?", "C").setFakeAnswers(new String[] {"C#", "Java"}))
		.addQuestion(new Question("Which of these is not OOP?", "C").setFakeAnswers(new String[] {"C#", "Java"}))
		.addQuestion(new Question("Which of these is not OOP?", "C").setFakeAnswers(new String[] {"C#", "Java"}))
		.addQuestion(new Question("Which function is called first?", "main()").setFakeAnswers(new String[] {"onCreate()", "start()"}))
		);
		
		addQuiz(new Quiz("Programming", "Java")
		.addQuestion(new Question("How do you break out of a loop?", "break;").setFakeAnswers(new String[] {"continue;", "return;"}))
		.addQuestion(new Question("Which of these is not OOP?", "C").setFakeAnswers(new String[] {"C#", "Java"}))
		.addQuestion(new Question("Which of these is not OOP?", "C").setFakeAnswers(new String[] {"C#", "Java"}))
		.addQuestion(new Question("Which of these is not OOP?", "C").setFakeAnswers(new String[] {"C#", "Java"}))
		.addQuestion(new Question("Which of these is not OOP?", "C").setFakeAnswers(new String[] {"C#", "Java"}))
		.addQuestion(new Question("Which function is called first?", "main()").setFakeAnswers(new String[] {"onCreate()", "start()"}))
		);
		
		addQuiz(new Quiz("Programming", "Pascal")
		.addQuestion(new Question("How do you break out of a loop?", "break;").setFakeAnswers(new String[] {"continue;", "return;"}))
		.addQuestion(new Question("Which of these is not OOP?", "C").setFakeAnswers(new String[] {"C#", "Java"}))
		.addQuestion(new Question("Which of these is not OOP?", "C").setFakeAnswers(new String[] {"C#", "Java"}))
		.addQuestion(new Question("Which of these is not OOP?", "C").setFakeAnswers(new String[] {"C#", "Java"}))
		.addQuestion(new Question("Which of these is not OOP?", "C").setFakeAnswers(new String[] {"C#", "Java"}))
		.addQuestion(new Question("Which function is called first?", "main()").setFakeAnswers(new String[] {"onCreate()", "start()"}))
		);
		
		addQuiz(new Quiz("HCI", "General")
		.addQuestion(new Question("Mismatch between a user's goal for action and the means to execute that goal is called", "gulf of execution").setFakeAnswers(new String[] {"gulf of evaluation", "action"}))
		.addQuestion(new Question("What does HCI stand for?", "Human Computer Interaction").setFakeAnswers(new String[] {"Human Computer Interface", "Human Computer Industry"}))
		.addQuestion(new Question("Which one of these would NOT be found in a good HCI? ", "A long command line to achieve a function ").setFakeAnswers(new String[] {"Icons that can have specific meanings.", "Common short cuts, like CTRL+Z for undo."}))
		.addQuestion(new Question("Which of these films uses futuristic HCI?", "Minority Report").setFakeAnswers(new String[] {"Bambi", "Speed"}))
		);
		
		addQuiz(new Quiz("HCI", "Week 1")
		.addQuestion(new Question("Mismatch between a user's goal for action and the means to execute that goal is called", "gulf of execution").setFakeAnswers(new String[] {"gulf of evaluation", "action"}))
		.addQuestion(new Question("What does HCI stand for?", "Human Computer Interaction").setFakeAnswers(new String[] {"Human Computer Interface", "Human Computer Industry"}))
		.addQuestion(new Question("Which one of these would NOT be found in a good HCI? ", "A long command line to achieve a function ").setFakeAnswers(new String[] {"Icons that can have specific meanings.", "Common short cuts, like CTRL+Z for undo."}))
		.addQuestion(new Question("Which of these films uses futuristic HCI?", "Minority Report").setFakeAnswers(new String[] {"Bambi", "Speed"}))
		);
		
		addQuiz(new Quiz("HCI", "Week 2")
		.addQuestion(new Question("Mismatch between a user's goal for action and the means to execute that goal is called", "gulf of execution").setFakeAnswers(new String[] {"gulf of evaluation", "action"}))
		.addQuestion(new Question("What does HCI stand for?", "Human Computer Interaction").setFakeAnswers(new String[] {"Human Computer Interface", "Human Computer Industry"}))
		.addQuestion(new Question("Which one of these would NOT be found in a good HCI? ", "A long command line to achieve a function ").setFakeAnswers(new String[] {"Icons that can have specific meanings.", "Common short cuts, like CTRL+Z for undo."}))
		.addQuestion(new Question("Which of these films uses futuristic HCI?", "Minority Report").setFakeAnswers(new String[] {"Bambi", "Speed"}))
		);
		
		addQuiz(new Quiz("HCI", "Week 3")
		.addQuestion(new Question("Mismatch between a user's goal for action and the means to execute that goal is called", "gulf of execution").setFakeAnswers(new String[] {"gulf of evaluation", "action"}))
		.addQuestion(new Question("What does HCI stand for?", "Human Computer Interaction").setFakeAnswers(new String[] {"Human Computer Interface", "Human Computer Industry"}))
		.addQuestion(new Question("Which one of these would NOT be found in a good HCI? ", "A long command line to achieve a function ").setFakeAnswers(new String[] {"Icons that can have specific meanings.", "Common short cuts, like CTRL+Z for undo."}))
		.addQuestion(new Question("Which of these films uses futuristic HCI?", "Minority Report").setFakeAnswers(new String[] {"Bambi", "Speed"}))
		);
		
		addQuiz(new Quiz("HCI", "Week 4")
		.addQuestion(new Question("Mismatch between a user's goal for action and the means to execute that goal is called", "gulf of execution").setFakeAnswers(new String[] {"gulf of evaluation", "action"}))
		.addQuestion(new Question("What does HCI stand for?", "Human Computer Interaction").setFakeAnswers(new String[] {"Human Computer Interface", "Human Computer Industry"}))
		.addQuestion(new Question("Which one of these would NOT be found in a good HCI? ", "A long command line to achieve a function ").setFakeAnswers(new String[] {"Icons that can have specific meanings.", "Common short cuts, like CTRL+Z for undo."}))
		.addQuestion(new Question("Which of these films uses futuristic HCI?", "Minority Report").setFakeAnswers(new String[] {"Bambi", "Speed"}))
		);
		
		addQuiz(new Quiz("HCI", "Week 5")
		.addQuestion(new Question("Mismatch between a user's goal for action and the means to execute that goal is called", "gulf of execution").setFakeAnswers(new String[] {"gulf of evaluation", "action"}))
		.addQuestion(new Question("What does HCI stand for?", "Human Computer Interaction").setFakeAnswers(new String[] {"Human Computer Interface", "Human Computer Industry"}))
		.addQuestion(new Question("Which one of these would NOT be found in a good HCI? ", "A long command line to achieve a function ").setFakeAnswers(new String[] {"Icons that can have specific meanings.", "Common short cuts, like CTRL+Z for undo."}))
		.addQuestion(new Question("Which of these films uses futuristic HCI?", "Minority Report").setFakeAnswers(new String[] {"Bambi", "Speed"}))
		);
		
		addQuiz(new Quiz("General CS", "Linux")
		.addQuestion(new Question("Mismatch between a user's goal for action and the means to execute that goal is called", "gulf of execution").setFakeAnswers(new String[] {"gulf of evaluation", "action"}))
		.addQuestion(new Question("What does HCI stand for?", "Human Computer Interaction").setFakeAnswers(new String[] {"Human Computer Interface", "Human Computer Industry"}))
		.addQuestion(new Question("Which one of these would NOT be found in a good HCI? ", "A long command line to achieve a function ").setFakeAnswers(new String[] {"Icons that can have specific meanings.", "Common short cuts, like CTRL+Z for undo."}))
		.addQuestion(new Question("Which of these films uses futuristic HCI?", "Minority Report").setFakeAnswers(new String[] {"Bambi", "Speed"}))
		);
		
		addQuiz(new Quiz("General CS", "Mac")
		.addQuestion(new Question("Mismatch between a user's goal for action and the means to execute that goal is called", "gulf of execution").setFakeAnswers(new String[] {"gulf of evaluation", "action"}))
		.addQuestion(new Question("What does HCI stand for?", "Human Computer Interaction").setFakeAnswers(new String[] {"Human Computer Interface", "Human Computer Industry"}))
		.addQuestion(new Question("Which one of these would NOT be found in a good HCI? ", "A long command line to achieve a function ").setFakeAnswers(new String[] {"Icons that can have specific meanings.", "Common short cuts, like CTRL+Z for undo."}))
		.addQuestion(new Question("Which of these films uses futuristic HCI?", "Minority Report").setFakeAnswers(new String[] {"Bambi", "Speed"}))
		);
		
		addQuiz(new Quiz("Databases", "General")
		.addQuestion(new Question("Mismatch between a user's goal for action and the means to execute that goal is called", "gulf of execution").setFakeAnswers(new String[] {"gulf of evaluation", "action"}))
		.addQuestion(new Question("What does HCI stand for?", "Human Computer Interaction").setFakeAnswers(new String[] {"Human Computer Interface", "Human Computer Industry"}))
		.addQuestion(new Question("Which one of these would NOT be found in a good HCI? ", "A long command line to achieve a function ").setFakeAnswers(new String[] {"Icons that can have specific meanings.", "Common short cuts, like CTRL+Z for undo."}))
		.addQuestion(new Question("Which of these films uses futuristic HCI?", "Minority Report").setFakeAnswers(new String[] {"Bambi", "Speed"}))
		);
		
		addQuiz(new Quiz("PPD", "File Operations")
		.addQuestion(new Question("Mismatch between a user's goal for action and the means to execute that goal is called", "gulf of execution").setFakeAnswers(new String[] {"gulf of evaluation", "action"}))
		.addQuestion(new Question("What does HCI stand for?", "Human Computer Interaction").setFakeAnswers(new String[] {"Human Computer Interface", "Human Computer Industry"}))
		.addQuestion(new Question("Which one of these would NOT be found in a good HCI? ", "A long command line to achieve a function ").setFakeAnswers(new String[] {"Icons that can have specific meanings.", "Common short cuts, like CTRL+Z for undo."}))
		.addQuestion(new Question("Which of these films uses futuristic HCI?", "Minority Report").setFakeAnswers(new String[] {"Bambi", "Speed"}))
		);
		
		addQuiz(new Quiz("PPD", "Database Operations")
		.addQuestion(new Question("Mismatch between a user's goal for action and the means to execute that goal is called", "gulf of execution").setFakeAnswers(new String[] {"gulf of evaluation", "action"}))
		.addQuestion(new Question("What does HCI stand for?", "Human Computer Interaction").setFakeAnswers(new String[] {"Human Computer Interface", "Human Computer Industry"}))
		.addQuestion(new Question("Which one of these would NOT be found in a good HCI? ", "A long command line to achieve a function ").setFakeAnswers(new String[] {"Icons that can have specific meanings.", "Common short cuts, like CTRL+Z for undo."}))
		.addQuestion(new Question("Which of these films uses futuristic HCI?", "Minority Report").setFakeAnswers(new String[] {"Bambi", "Speed"}))
		);
		
		addQuiz(new Quiz("PPD", "Bitmap encoding")
		.addQuestion(new Question("Mismatch between a user's goal for action and the means to execute that goal is called", "gulf of execution").setFakeAnswers(new String[] {"gulf of evaluation", "action"}))
		.addQuestion(new Question("What does HCI stand for?", "Human Computer Interaction").setFakeAnswers(new String[] {"Human Computer Interface", "Human Computer Industry"}))
		.addQuestion(new Question("Which one of these would NOT be found in a good HCI? ", "A long command line to achieve a function ").setFakeAnswers(new String[] {"Icons that can have specific meanings.", "Common short cuts, like CTRL+Z for undo."}))
		.addQuestion(new Question("Which of these films uses futuristic HCI?", "Minority Report").setFakeAnswers(new String[] {"Bambi", "Speed"}))
		);
	}
	
	public void addQuiz(Quiz quiz)
	{
		if (quizzes.containsKey(quiz.getCategory()) == false)
		{
			quizzes.put(quiz.getCategory(), new ArrayList<Quiz>());
			categories.add(quiz.getCategory());
		}
		
		quizzes.get(quiz.getCategory()).add(quiz);
	}
	
	public HashMap<String, ArrayList<Quiz>> getQuizzes()
	{
		return quizzes;
	}
	
	public List<Quiz> getQuizzes(String category)
	{
		if (quizzes.containsKey(category)) return quizzes.get(category);
		else return new ArrayList<Quiz>();
	}
	
	public String [] getCategories()
	{
		//return quizzes.keySet().toArray(new String[quizzes.keySet().size()]);
		return categories.toArray(new String [categories.size()]);
	}
	
	public String getCategory(int id)
	{
		if (id <0 || id >= categories.size()) return null;
		return categories.get(id);
	}
	
	public int getNumCategories()
	{
		return categories.size();
	}
}

package com.mick88.superbrain.main;

import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.mick88.superbrain.R;
import com.mick88.superbrain.SuperBrainApplication;
import com.mick88.superbrain.quiz.QuizActivity;
import com.mick88.superbrain.quizzes.Quiz;
import com.mick88.superbrain.quizzes.QuizManager;

/**
 * A dummy fragment representing a section of the app, but that simply displays
 * dummy text.
 */
public class SectionFragment extends Fragment
{
	public static final String EXTRA_CATEGORY = "quiz_category";
	String categoryName;
	List<Quiz> quizzes;
	QuizManager quizManager;
	
	public void setCategoryName(String categoryName)
	{
		this.categoryName = categoryName;
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		String category = getArguments().getString(EXTRA_CATEGORY);
		this.quizzes = quizManager.getQuizzes(category);
	}
	
	@Override
	public void onAttach(Activity activity)
	{
		super.onAttach(activity);
		SuperBrainApplication application = (SuperBrainApplication) activity.getApplication();
		this.quizManager = application.getQuizManager();
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState)
	{
		
		View rootView = inflater.inflate(R.layout.fragment_list_quizes,
				container, false);
		if (quizzes != null)
		{
			ListView listView = (ListView) rootView
				.findViewById(R.id.listOfQuizzes);
			ArrayAdapter<Quiz> adapter = new ArrayAdapter<Quiz>(getActivity(), android.R.layout.simple_list_item_1, quizzes);
			listView.setAdapter(adapter);
			
			listView.setOnItemClickListener(new OnItemClickListener()
			{

				@Override
				public void onItemClick(AdapterView<?> arg0, View arg1,
						int arg2, long id)
				{
					Quiz quiz = (Quiz) arg0.getItemAtPosition(arg2);
					if (quiz.getId() == null)
						throw new NullPointerException("Quiz id is null.");
					Intent intent = new Intent(getActivity(), QuizActivity.class);
					intent.putExtra(QuizActivity.EXTRA_ID, quiz.getId());
					
					getActivity().startActivity(intent);
					
				}
			});
		}

		/*
		 * dummyTextView.setText(Integer.toString(getArguments().getInt(
		 * ARG_SECTION_NUMBER)));
		 */
		return rootView;
	}
}
package com.mick88.superbrain.activities;

import java.util.List;

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
import com.mick88.superbrain.quizzes.Quiz;

/**
 * A dummy fragment representing a section of the app, but that simply displays
 * dummy text.
 */
public class SectionFragment extends Fragment
{
	String categoryName;
	List<Quiz> quizzes;
	
	public static final String ARG_SECTION_NUMBER = "section_number";

	public SectionFragment() 
	{
	}
	
	public void setCategoryName(String categoryName)
	{
		this.categoryName = categoryName;
	}
	
	public void loadContent(List<Quiz> quizzes)
	{
		this.quizzes = quizzes;
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
//					Toast.makeText(getActivity(), String.valueOf(id)+" clicked in "+categoryName, Toast.LENGTH_SHORT).show();
					Intent intent = new Intent(getActivity(), QuizActivity.class);
					intent.putExtra(QuizActivity.KEY_CATEGORY, categoryName);
					intent.putExtra(QuizActivity.KEY_ID, (int)id);
					
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
package com.mick88.superbrain.main;

import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.mick88.superbrain.R;
import com.mick88.superbrain.SuperBrainApplication;
import com.mick88.superbrain.quiz.QuizActivity;
import com.mick88.superbrain.quiz_creator.QuizCreatorActivity;
import com.mick88.superbrain.quizzes.Quiz;
import com.mick88.superbrain.quizzes.QuizManager;

/**
 * A dummy fragment representing a section of the app, but that simply displays
 * dummy text.
 */
public class SectionFragment extends Fragment 
{
	public static final String EXTRA_CATEGORY = "quiz_category";
	public static final int REQUEST_ID_EDIT_QUIZ = 1;
	String categoryName;
	List<Quiz> quizzes;
	QuizManager quizManager;
	private ListView listView;
	private int selectedQuizId= -1;
	
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		categoryName = getArguments().getString(EXTRA_CATEGORY);
	}
	
	@Override
	public void onAttach(Activity activity)
	{
		super.onAttach(activity);
		SuperBrainApplication application = (SuperBrainApplication) activity.getApplication();
		this.quizManager = application.getQuizManager();
	}
	
	public void loadQuizzes()
	{
		this.quizzes = quizManager.getQuizzes(categoryName);
	}
	
	void populateList()
	{
		ArrayAdapter<Quiz> adapter = new ArrayAdapter<Quiz>(getActivity(), android.R.layout.simple_list_item_1, quizzes);
		listView.setAdapter(adapter);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState)
	{
		
		View rootView = inflater.inflate(R.layout.fragment_list_quizes,
				container, false);
		listView = (ListView) rootView
				.findViewById(R.id.listOfQuizzes);
		registerForContextMenu(listView);
			
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
			loadQuizzes();
			populateList();

		/*
		 * dummyTextView.setText(Integer.toString(getArguments().getInt(
		 * ARG_SECTION_NUMBER)));
		 */
		return rootView;
	}
	@Override
	public void onDestroyView()
	{
		super.onDestroyView();
		this.listView = null;
	}
	
	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data)
	{
		super.onActivityResult(requestCode, resultCode, data);
		if (requestCode == REQUEST_ID_EDIT_QUIZ)
		{
			if (resultCode == Activity.RESULT_OK)
			{
				FragmentActivity activity = getActivity();
				if (activity instanceof ListQuizActivity)
				{
					String category = null;
					if (data != null) category = data.getStringExtra(QuizCreatorActivity.EXTRA_CATEGORY_NAME);
					((ListQuizActivity) activity).reloadCategories(category);
				}
				else
				{
					loadQuizzes();
					populateList();
				}
			}
		}
	}
	
	Quiz getSelectedQuiz()
	{
		if (listView != null)
		{
			int position = listView.getSelectedItemPosition();
			if (position < 0) return null;
			return (Quiz) listView.getAdapter().getItem(position);
		}
		else return null;
	}
	
	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo)
	{
		if (v.getId() == R.id.listOfQuizzes)
		{
			MenuInflater inflater = getActivity().getMenuInflater();
			inflater.inflate(R.menu.quiz_context_menu, menu);
			menu.setHeaderTitle(getSelectedQuiz().getName());
			return;
		}
		super.onCreateContextMenu(menu, v, menuInfo);
	}
	
	@Override
	public boolean onContextItemSelected(MenuItem item)
	{
		switch (item.getItemId())
		{
			case R.id.menu_edit:
				editQuiz(getSelectedQuiz());
				return true;
		}
		return super.onContextItemSelected(item);
	}
	
	void editQuiz(Quiz quiz)
	{
		Intent intent = new Intent(getActivity(), QuizCreatorActivity.class);
		intent.putExtra(QuizCreatorActivity.EXTRA_QUIZ_ID, quiz.getId());
		startActivityForResult(intent, REQUEST_ID_EDIT_QUIZ);
	}
}
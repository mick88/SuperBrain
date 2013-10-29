package com.mick88.superbrain.main;


import java.util.List;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuItem;

import com.mick88.superbrain.R;
import com.mick88.superbrain.SuperBrainApplication;
import com.mick88.superbrain.quiz_creator.QuizCreatorActivity;
import com.mick88.superbrain.quizzes.QuizManager;

public class ListQuizActivity extends FragmentActivity
{
	public static final String EXTRA_SHOW_CATEGORY = "category";
	QuizManager quizManager;
	SuperBrainApplication application;
	
	List<SectionFragment> pages;
	
	/**
	 * The {@link android.support.v4.view.PagerAdapter} that will provide
	 * fragments for each of the sections. We use a
	 * {@link android.support.v4.app.FragmentPagerAdapter} derivative, which
	 * will keep every loaded fragment in memory. If this becomes too memory
	 * intensive, it may be best to switch to a
	 * {@link android.support.v4.app.FragmentStatePagerAdapter}.
	 */
	SectionsPagerAdapter mSectionsPagerAdapter;

	/**
	 * The {@link ViewPager} that will host the section contents.
	 */
	ViewPager mViewPager;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_list_main);
		
		this.application = (SuperBrainApplication) getApplication();
		this.quizManager = application.getQuizManager();

		// Create the adapter that will return a fragment for each of the three
		// primary sections of the app.
		mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager(), quizManager);

		// Set up the ViewPager with the sections adapter.
		mViewPager = (ViewPager) findViewById(R.id.pager);
		mViewPager.setAdapter(mSectionsPagerAdapter);
		
		int page = mSectionsPagerAdapter.getcategoryPage(getIntent().getStringExtra(EXTRA_SHOW_CATEGORY));
		if (page > -1) 
			mViewPager.setCurrentItem(page);

	}
	
	public QuizManager getQuizManager()
	{
		return quizManager;
	}
	
	public List<SectionFragment> getPages()
	{
		return pages;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.list_quiz, menu);
		return true;
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data)
	{
		super.onActivityResult(requestCode, resultCode, data);
		if (requestCode == SectionFragment.REQUEST_ID_EDIT_QUIZ)
		{
			if (resultCode == RESULT_OK)
				reloadCategories(data.getStringExtra(QuizCreatorActivity.EXTRA_CATEGORY_NAME));
		}
	}
	
	void reloadCategories(String showCategory)
	{
		Intent intent = new Intent(getApplicationContext(), ListQuizActivity.class);
		if (showCategory != null)
			intent.putExtra(EXTRA_SHOW_CATEGORY, showCategory);
		startActivity(intent);
		finish();
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		switch (item.getItemId())
		{
			case R.id.menu_quiz_create:
				Intent intent = new Intent(getApplicationContext(), QuizCreatorActivity.class);
				intent.putExtra(QuizCreatorActivity.EXTRA_CATEGORY_NAME, mSectionsPagerAdapter.getPageTitle(mViewPager.getCurrentItem()));
				startActivityForResult(intent, SectionFragment.REQUEST_ID_EDIT_QUIZ);
				return true;
			default:
				return super.onOptionsItemSelected(item);
		}
	}

}

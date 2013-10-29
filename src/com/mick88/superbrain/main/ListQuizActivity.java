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
	public boolean onOptionsItemSelected(MenuItem item)
	{
		switch (item.getItemId())
		{
			case R.id.menu_quiz_create:
				Intent intent = new Intent(getApplicationContext(), QuizCreatorActivity.class);
				intent.putExtra(QuizCreatorActivity.EXTRA_CATEGORY_NAME, mSectionsPagerAdapter.getPageTitle(mViewPager.getCurrentItem()));
				startActivity(intent);
				return true;
			default:
				return super.onOptionsItemSelected(item);
		}
	}

}

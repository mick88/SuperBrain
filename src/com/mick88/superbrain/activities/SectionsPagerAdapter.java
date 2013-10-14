package com.mick88.superbrain.activities;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.mick88.superbrain.SuperBrainApplication;

/**
 * A {@link FragmentPagerAdapter} that returns a fragment corresponding to one
 * of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter
{
	String [] categories;
	SuperBrainApplication application;
	private final ListQuizActivity listQuizActivity;

	public SectionsPagerAdapter(ListQuizActivity listQuizActivity,
			FragmentManager fm) {
		super(fm);
		this.listQuizActivity = listQuizActivity;
		this.application = (SuperBrainApplication) this.listQuizActivity.getApplication();
		categories = application.getQuizManager().getCategories();		
	}

	@Override
	public Fragment getItem(int position)
	{
		String category = categories[position];
		
		SectionFragment section = new SectionFragment();
		section.setCategoryName(category);
		section.loadContent(application.getQuizManager().getQuizzes(category));
		
		return section;
	}


	@Override
	public int getCount()
	{
		return categories.length;
	}
	
	@Override
	public void notifyDataSetChanged()
	{
		categories = application.getQuizManager().getCategories();
		super.notifyDataSetChanged();
	}

	@Override
	public CharSequence getPageTitle(int position)
	{
		return categories[position];
	}
}
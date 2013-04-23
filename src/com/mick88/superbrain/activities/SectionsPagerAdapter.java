package com.mick88.superbrain.activities;

import java.util.Locale;

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

	SuperBrainApplication application;
	private final ListQuizActivity listQuizActivity;

	public SectionsPagerAdapter(ListQuizActivity listQuizActivity,
			FragmentManager fm) {
		super(fm);
		this.listQuizActivity = listQuizActivity;
		
		this.application = (SuperBrainApplication) this.listQuizActivity.getApplication();
	}

	@Override
	public Fragment getItem(int position)
	{
		String category = application.getQuizManager().getCategory(position);
		
		SectionFragment section = new SectionFragment();
		section.setCategoryName(category);
		section.loadContent(application.getQuizManager().getQuizzes(category));
		
		return section;
	}


	@Override
	public int getCount()
	{
		return application.getQuizManager().getNumCategories();
	}

	@Override
	public CharSequence getPageTitle(int position)
	{
		Locale l = Locale.getDefault();
		return application.getQuizManager().getCategory(position).toUpperCase(l);
	}
}
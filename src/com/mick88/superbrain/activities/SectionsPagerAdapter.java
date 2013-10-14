package com.mick88.superbrain.activities;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.mick88.superbrain.quizzes.QuizManager;

/**
 * A {@link FragmentPagerAdapter} that returns a fragment corresponding to one
 * of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter
{
	String [] categories;
	final QuizManager quizManager;

	public SectionsPagerAdapter(FragmentManager fm, QuizManager quizManager) {
		super(fm);
		this.quizManager = quizManager;
	}

	@Override
	public Fragment getItem(int position)
	{
		String category = categories[position];
		
		SectionFragment section = new SectionFragment();
		section.setCategoryName(category);
		section.loadContent(quizManager.getQuizzes(category));
		
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
		categories = quizManager.getCategories();
		super.notifyDataSetChanged();
	}

	@Override
	public CharSequence getPageTitle(int position)
	{
		return categories[position];
	}
}
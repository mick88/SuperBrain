package com.mick88.superbrain.quiz_creator;

import com.mick88.superbrain.R;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.EditText;

public class QuizCreatorActivity extends FragmentActivity
{
	public static final String EXTRA_CATEGORY_NAME = "category_name";

	@Override
	protected void onCreate(Bundle arg0)
	{
		super.onCreate(arg0);
		setContentView(R.layout.activity_quiz_creator);
		
		EditText editCategory = (EditText) findViewById(R.id.editCategoryName);
		Bundle extras = getIntent().getExtras();
		if (extras != null && extras.containsKey(EXTRA_CATEGORY_NAME))
			editCategory.setText(extras.getString(EXTRA_CATEGORY_NAME));
	}
}

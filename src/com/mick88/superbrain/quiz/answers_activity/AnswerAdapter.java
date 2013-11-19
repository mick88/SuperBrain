package com.mick88.superbrain.quiz.answers_activity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class AnswerAdapter extends ArrayAdapter<AnsweredQuestion>
{
	private static class ViewHolder
	{
		TextView tvQuestion, tvAnswer;
	}
	
	public AnswerAdapter(Context context,
			AnsweredQuestion[] objects)
	{
		super(context, 0, objects);
	}
	
	@Override
	public AnsweredQuestion getItem(int position)
	{
		AnsweredQuestion result = super.getItem(position);
		
		if (result == null)
			throw new NullPointerException("Array element is null.");
		return result;
	}

	@Override
	public View getView(int position, View view, ViewGroup parent)
	{
		if (view == null)
			view = ((LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE))
				.inflate(android.R.layout.simple_list_item_2, parent, false);
		
		ViewHolder holder = (ViewHolder) view.getTag();
		if (holder == null)
		{
			holder = new ViewHolder();
			holder.tvQuestion = (TextView) view.findViewById(android.R.id.text1);
			holder.tvAnswer = (TextView) view.findViewById(android.R.id.text2);
			view.setTag(holder);
		}
		
		AnsweredQuestion answeredQuestion = getItem(position);
		holder.tvQuestion.setText(answeredQuestion.getQuestion().toString());
		holder.tvAnswer.setText(answeredQuestion.getSelectedAnswer().toString());
		
		return view;
	}
}

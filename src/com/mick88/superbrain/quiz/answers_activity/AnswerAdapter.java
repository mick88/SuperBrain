package com.mick88.superbrain.quiz.answers_activity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.mick88.superbrain.R;

public class AnswerAdapter extends ArrayAdapter<AnsweredQuestion>
{
	private static class ViewHolder
	{
		TextView tvQuestion, tvAnswer;
		ImageView imgIcon;
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
				.inflate(R.layout.list_item_revealed_answer, parent, false);
		
		ViewHolder holder = (ViewHolder) view.getTag();
		if (holder == null)
		{
			holder = new ViewHolder();
			holder.tvQuestion = (TextView) view.findViewById(R.id.tvQuestion);
			holder.tvAnswer = (TextView) view.findViewById(R.id.tvAnswer);
			holder.imgIcon = (ImageView) view.findViewById(android.R.id.icon);
			view.setTag(holder);
		}
		
		AnsweredQuestion answeredQuestion = getItem(position);
		holder.tvQuestion.setText(answeredQuestion.getQuestion().toString());
		holder.tvAnswer.setText(answeredQuestion.getSelectedAnswer().toString());
		holder.tvAnswer.setTextColor(getContext().getResources().getColor(answeredQuestion.isCorrect() ? R.color.answer_correct : R.color.answer_wrong));
		holder.imgIcon.setImageResource(answeredQuestion.isCorrect() ? R.drawable.ic_answer_correct : R.drawable.ic_answer_wrong);
		
		return view;
	}
}

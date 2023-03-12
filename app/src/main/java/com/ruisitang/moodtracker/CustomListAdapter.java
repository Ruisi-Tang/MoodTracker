/***
 * @author Ruisi Tang
 * @version 1.0
 */
package com.ruisitang.moodtracker;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CustomListAdapter extends ArrayAdapter<Mood> {
    private Context context;
    private int resourceId;
    public CustomListAdapter(@NonNull Context context, int resourceId, ArrayList<Mood> moodArrayList) {
        super(context, resourceId, moodArrayList);
        this.context = context;
        this.resourceId = resourceId;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        String date = getItem(position).getDate().toString();
        int mood = getItem(position).getMood().ordinal();
        Log.i("CustomListAdapter.getView", mood + date);
        LayoutInflater inflater = LayoutInflater.from(context);
        convertView = inflater.inflate(resourceId, parent, false);

        TextView dateTextView = convertView.findViewById(R.id.dateTextView);
        ImageView moodImageView = convertView.findViewById(R.id.moodImageView);

        dateTextView.setText(date);

        if(mood == 0){
            moodImageView.setImageResource(R.drawable.anxious);
        }

        if(mood == 1){
            moodImageView.setImageResource(R.drawable.bad);
        }

        if(mood  == 2){
            moodImageView.setImageResource(R.drawable.emotional);
        }

        if(mood  == 3){
            moodImageView.setImageResource(R.drawable.exciting);
        }

        if(mood  == 4){
            moodImageView.setImageResource(R.drawable.moody);
        }

        if(mood  == 5){
            moodImageView.setImageResource(R.drawable.neutral);
        }

        if(mood  == 6){
            moodImageView.setImageResource(R.drawable.sad);
        }

        if(mood  == 7){
            moodImageView.setImageResource(R.drawable.sleepy);
        }

        if(mood  == 8){
            moodImageView.setImageResource(R.drawable.happy);
        }

        return convertView;
    }


    /**
    private final Context context;
    private final List<Mood> moods;

    public CustomListAdapter(Context context, List<Mood> moods) {
        super(context, R.layout.custom_list_layout);
        this.context = context;
        this.moods = moods;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        @SuppressLint("ViewHolder") View rowView = inflater.inflate(R.layout.custom_list_layout, parent, false);

        TextView dateView = rowView.findViewById(R.id.dateTextView);
        ImageView imageView = rowView.findViewById(R.id.moodImageView);

        dateView.setText(moods.get(position).getDate().toString());

        if(moods.get(position).getMood().ordinal() == 0){
            imageView.setImageResource(R.drawable.anxious);
        }

        if(moods.get(position).getMood().ordinal() == 1){
            imageView.setImageResource(R.drawable.bad);
        }

        if(moods.get(position).getMood().ordinal() == 2){
            imageView.setImageResource(R.drawable.emotional);
        }

        if(moods.get(position).getMood().ordinal() == 3){
            imageView.setImageResource(R.drawable.exciting);
        }

        if(moods.get(position).getMood().ordinal() == 4){
            imageView.setImageResource(R.drawable.moody);
        }

        if(moods.get(position).getMood().ordinal() == 5){
            imageView.setImageResource(R.drawable.neutral);
        }

        if(moods.get(position).getMood().ordinal() == 6){
            imageView.setImageResource(R.drawable.sad);
        }

        if(moods.get(position).getMood().ordinal() == 7){
            imageView.setImageResource(R.drawable.sleepy);
        }

        if(moods.get(position).getMood().ordinal() == 8){
            imageView.setImageResource(R.drawable.happy);
        }

        return rowView;
    }
        **/
}

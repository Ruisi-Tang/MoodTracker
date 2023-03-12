/***
 * @author Ruisi Tang
 * @version 1.0
 */
package com.ruisitang.moodtracker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MoodHistoryActivity extends AppCompatActivity {

    private ListView listView;
    private MoodDb moodDb;
    ArrayList<Mood> moodList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mood_history);


        listView = findViewById(R.id.moodHistoryList);
        moodDb = new MoodDb(this);
        moodList = moodDb.readAll();

        CustomListAdapter customListAdapter = new CustomListAdapter(this, R.layout.custom_list_layout, moodList);
        moodList.forEach(mood -> Log.i("moodList", mood.toString()));
        listView.setAdapter(customListAdapter);
    }
}
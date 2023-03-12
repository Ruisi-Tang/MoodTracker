/***
 * @author Ruisi Tang
 * @version 1.0
 */
package com.ruisitang.moodtracker;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class MainActivity extends AppCompatActivity {

    private TextView dateTodayTextView;
    private LocalDate dateToday;
    private DateTimeFormatter dateTodayFormatter;
    private Button registerMoodBtn;
    private Button viewHistoryBtn;
    private ImageButton anxiousBtn;
    private ImageButton badBtn;
    private ImageButton emotionalBtn;
    private ImageButton excitingBtn;
    private ImageButton moodyBtn;
    private ImageButton neutralBtn;
    private ImageButton sadBtn;
    private ImageButton sleepyBtn;
    private ImageButton happyBtn;
    private Mood moodSelected;
    private Toast registerBtnMsg;
    private Toast registerBtnErrorMsg;
    private MoodDb moodDb;

    private void resetBackgroundColor(){
        anxiousBtn.setBackgroundColor(Color.parseColor("#00FFFFFF"));
        emotionalBtn.setBackgroundColor(Color.parseColor("#00FFFFFF"));
        badBtn.setBackgroundColor(Color.parseColor("#00FFFFFF"));
        excitingBtn.setBackgroundColor(Color.parseColor("#00FFFFFF"));
        moodyBtn.setBackgroundColor(Color.parseColor("#00FFFFFF"));
        neutralBtn.setBackgroundColor(Color.parseColor("#00FFFFFF"));
        sadBtn.setBackgroundColor(Color.parseColor("#00FFFFFF"));
        sleepyBtn.setBackgroundColor(Color.parseColor("#00FFFFFF"));
        happyBtn.setBackgroundColor(Color.parseColor("#00FFFFFF"));
    }

    @SuppressLint("all")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dateTodayTextView= findViewById(R.id.dateTodayTextView);
        registerMoodBtn = findViewById(R.id.registerMoodBtn);
        viewHistoryBtn = findViewById(R.id.viewHistoryBtn);
        anxiousBtn = findViewById(R.id.anxiousBtn);
        emotionalBtn = findViewById(R.id.emotionalBtn);
        badBtn = findViewById(R.id.badBtn);
        excitingBtn = findViewById(R.id.excitingBtn);
        moodyBtn= findViewById(R.id.moodyBtn);
        neutralBtn = findViewById(R.id.neutralBtn);
        sadBtn = findViewById(R.id.sadBtn);
        sleepyBtn = findViewById(R.id.sleepyBtn);
        happyBtn = findViewById(R.id.happyBtn);
        registerMoodBtn = findViewById(R.id.registerMoodBtn);
        viewHistoryBtn = findViewById(R.id.viewHistoryBtn);

        dateToday = LocalDate.now();
        dateTodayFormatter = DateTimeFormatter.ofPattern("MMM dd, yyyy");
        dateTodayTextView.setText(dateToday.format(dateTodayFormatter));
        registerBtnErrorMsg = Toast.makeText(this, "You have recorded your mood today, try again tomorrow!", Toast.LENGTH_SHORT);
        moodDb = new MoodDb(MainActivity.this);


        anxiousBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetBackgroundColor();
                moodSelected = new Mood(Mood.Moods.ANXIOUS);
                anxiousBtn.setBackgroundColor(Color.parseColor("#5D9B8C"));
            }
        });

        emotionalBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetBackgroundColor();
                moodSelected = new Mood(Mood.Moods.EMOTIONAL);
                emotionalBtn.setBackgroundColor(Color.parseColor("#5D9B8C"));
            }
        });

        badBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetBackgroundColor();
                moodSelected = new Mood(Mood.Moods.BAD);
                badBtn.setBackgroundColor(Color.parseColor("#5D9B8C"));
            }
        });

        excitingBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetBackgroundColor();
                moodSelected = new Mood(Mood.Moods.EXCITING);
                excitingBtn.setBackgroundColor(Color.parseColor("#5D9B8C"));
            }
        });

        moodyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetBackgroundColor();
                moodSelected = new Mood(Mood.Moods.MOODY);
                moodyBtn.setBackgroundColor(Color.parseColor("#5D9B8C"));
            }
        });

        neutralBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetBackgroundColor();
                moodSelected = new Mood(Mood.Moods.NEUTRAL);
                neutralBtn.setBackgroundColor(Color.parseColor("#5D9B8C"));
            }
        });

        sadBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetBackgroundColor();
                moodSelected = new Mood(Mood.Moods.SAD);
                sadBtn.setBackgroundColor(Color.parseColor("#5D9B8C"));
            }
        });

        sleepyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetBackgroundColor();
                moodSelected = new Mood(Mood.Moods.SLEEPY);
                sleepyBtn.setBackgroundColor(Color.parseColor("#5D9B8C"));
            }
        });

        happyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetBackgroundColor();
                moodSelected = new Mood(Mood.Moods.HAPPY);
                happyBtn.setBackgroundColor(Color.parseColor("#5D9B8C"));
            }
        });

        registerMoodBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    moodDb.findMoodByDate(moodSelected.getDate());
                }catch (IllegalArgumentException e){
                    Log.i("registerMoodBtn", "a mood has already been registered today in the database");
                    registerBtnErrorMsg.show();
                    return;
                }
                Log.i("registerMoodBtn", "date: " + moodSelected.getDate() + " mood: " + moodSelected.getMood());
                long id = moodDb.create(moodSelected);
                Log.i("MoodDb", "moodSelected has been added to database, id: " + id);
                registerBtnMsg = Toast.makeText(MainActivity.this, "Recorded! You are in " + moodSelected.getMood() + " mood today!", Toast.LENGTH_SHORT);
                registerBtnMsg.show();
            }
        });

        viewHistoryBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MoodHistoryActivity.class);
                startActivity(intent);
            }
        });
    }
}
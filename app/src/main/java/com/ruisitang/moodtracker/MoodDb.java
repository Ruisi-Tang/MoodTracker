/***
 * @author Ruisi Tang
 * @version 1.0
 */
package com.ruisitang.moodtracker;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.util.Log;

import java.time.LocalDate;
import java.util.ArrayList;

public class MoodDb {
    private final MoodDbHelper moodDbHelper;
    private static final String TABLE_NAME = "my_moods";

    public MoodDb(Context context) {
        this.moodDbHelper = new MoodDbHelper(context);
    }

    /***
     * add data into the database
     * @param mood the mood object to be added
     * @return the database PK id of the object that has been added.
     */
    public long create(Mood mood) {
        SQLiteDatabase db = moodDbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("date", mood.getDate().toString());
        values.put("mood", mood.getMood().ordinal());

        long id = db.insert(TABLE_NAME, null, values);

        db.close();

        return id;
    }

    /***
     * return all moods stored in database
     * @return an ArrayList which contains all the Moods objects
     */
    @SuppressLint("Range")
    public ArrayList<Mood> readAll(){
        SQLiteDatabase db = moodDbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME , null);
        long foundId;
        int foundMood;
        String foundDate;
        Mood mood = null;
        ArrayList<Mood> moods = new ArrayList<>();
        if (cursor.moveToFirst()) {
            do {
                foundId = cursor.getLong(cursor.getColumnIndex("id"));
                foundMood = cursor.getInt(cursor.getColumnIndex("mood"));
                foundDate = null;
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    foundDate = cursor.getString(cursor.getColumnIndex("date"));
                }
                Log.d("MyMood", "id: " + foundId + ", date: " + foundDate + ", mood: " + foundMood);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    mood = new Mood(Mood.Moods.values()[foundMood]);
                }
                moods.add(mood);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return moods;
    }

    /***
     * this function finds mood by date
     * @param date date specified
     * @return the associated mood by date
     */
    @SuppressLint("Range")
    public Mood findMoodByDate(String date){
        SQLiteDatabase db = moodDbHelper.getReadableDatabase();
        Cursor cursor = db.query(TABLE_NAME, new String[]{"id", "date", "mood"}, "date = ?", new String[]{date}, null, null, null, null);
        Mood mood = null;

        if (cursor.moveToFirst()) {
            @SuppressLint("Range") int id = cursor.getInt(cursor.getColumnIndex("id"));
            String foundDate = null;
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                foundDate = cursor.getString(cursor.getColumnIndex("date"));
            }
            int foundMood = cursor.getInt(cursor.getColumnIndex("mood"));
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                mood = new Mood(Mood.Moods.values()[foundMood]);
            }
        }

        if(mood != null){
            throw new IllegalArgumentException();
        }

        cursor.close();
        return mood;
    }
}

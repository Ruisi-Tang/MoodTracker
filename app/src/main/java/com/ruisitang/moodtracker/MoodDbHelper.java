/***
 * @author Ruisi Tang
 * @version 1.0
 */
package com.ruisitang.moodtracker;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

public class MoodDbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "moods_database.db";
    private static final int DATABASE_VERSION = 1;

    private static final String CREATE_MY_TABLE =
            "CREATE TABLE my_moods (" +
            "id INTEGER PRIMARY KEY," +
            "date TEXT,"              +
            "mood INTEGER"            +
            ")";

    public MoodDbHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_MY_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}

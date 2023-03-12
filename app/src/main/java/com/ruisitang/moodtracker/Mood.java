/***
 * @author Ruisi Tang
 * @version 1.0
 */
package com.ruisitang.moodtracker;

import android.os.Build;
import android.support.annotation.RequiresApi;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Mood {
    public static enum Moods{
        ANXIOUS,
        BAD,
        EMOTIONAL,
        EXCITING,
        MOODY,
        NEUTRAL,
        SAD,
        SLEEPY,
        HAPPY
    }

    private final Moods mood;
    private final String date;

    @RequiresApi(api = Build.VERSION_CODES.O)
    public Mood(final Moods mood) {
        this.mood = mood;
        this.date = LocalDate.now().format(DateTimeFormatter.ofPattern("MMM dd, yyyy"));
    }

    public Moods getMood() {
        return mood;
    }

    public String getDate() {
        return date;
    }
}

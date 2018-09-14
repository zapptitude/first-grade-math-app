package com.zapptitude.firstgrademathapp.app;

import android.content.Context;
import android.content.SharedPreferences;

public class AppPrefsLocal {
    private String APP_PREFS_FILENAME = "APP_PREFS_FILENAME";

    private static AppPrefsLocal appPrefsLocal = null;
    private static SharedPreferences sharedPreferences = null;

    private AppPrefsLocal(Context applicationContext) {
        sharedPreferences = applicationContext.getSharedPreferences(APP_PREFS_FILENAME, Context.MODE_PRIVATE);
    }

    public static AppPrefsLocal getInstance(Context applicationContext) {
        if (appPrefsLocal == null) {
            appPrefsLocal = new AppPrefsLocal(applicationContext);
        }

       return appPrefsLocal;
    }

    //returns size of the quiz as 10 by default.
    public Integer getQuizSize() {
        Integer quizSize = sharedPreferences.getInt("QUIZ_SIZE", 10);
        return quizSize;
    }

    public void setQuizSize(Integer size) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("QUIZ_SIZE", size).apply();
    }

    //returns timing of the quiz as 5 minutes by default.
    public Integer getQuizTiming() {
        Integer quizTiming = sharedPreferences.getInt("QUIZ_TIMING", 5);
        return quizTiming;
    }

    public void setQuizTiming(Integer timing) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("QUIZ_TIMING", timing).apply();
    }
}

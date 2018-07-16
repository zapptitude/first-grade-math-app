package com.zapptitude.firstgrademathapp.data;

import android.content.Context;
import android.content.SharedPreferences;

import com.zapptitude.firstgrademathapp.app.AppPrefs;
import com.zapptitude.firstgrademathapp.app.ZappApplication;

public class DataServiceRemote implements IDataServiceApi {
    private Context mContext;
    private AppPrefs appPrefs;

    DataServiceRemote(Context context) {
        mContext = context;
        appPrefs = ZappApplication.getSingleton().getAppPrefs();
    }

    @Override
    public Integer getQuizSize() {
        //TODO: REST API CALL goes here. Updates sharedPrefs for the app
        Integer remoteQuizSize = 10;

        //Note: Update sharedPrefs when callback returns from server
        //Similar way QuizSize and timing can be updated from Settings screen
        appPrefs.setQuizSize(remoteQuizSize);

        return remoteQuizSize;
    }

    @Override
    public Integer getQuizTiming() {
        //TODO: REST CALL. Update timing in callback
        Integer remoteQuizTiming = 5;
        appPrefs.setQuizTiming(remoteQuizTiming);
        return remoteQuizTiming;
    }

    @Override
    public void setQuizSize(int size) {
        //Note: Quiz details are updated to current user only. so all changes will be updated locally only.
        //Do-nothing
    }
}

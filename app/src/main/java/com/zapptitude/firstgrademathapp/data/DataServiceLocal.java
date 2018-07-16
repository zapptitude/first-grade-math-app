package com.zapptitude.firstgrademathapp.data;

import android.content.Context;

import com.zapptitude.firstgrademathapp.app.AppPrefs;
import com.zapptitude.firstgrademathapp.app.ZappApplication;

public class DataServiceLocal implements IDataServiceApi {
    private Context mContext;
    private AppPrefs appPrefs;

    DataServiceLocal(Context context) {
        mContext = context;
        appPrefs = ZappApplication.getSingleton().getAppPrefs();
    }
    
    @Override
    public Integer getQuizSize() {
        Integer quizSize = appPrefs.getQuizSize();
        return quizSize;
    }

    @Override
    public Integer getQuizTiming() {
        Integer quizTiming = appPrefs.getQuizTiming();
        return quizTiming;
    }

    @Override
    public void setQuizSize(int size) {
        appPrefs.setQuizSize(size);
    }
}

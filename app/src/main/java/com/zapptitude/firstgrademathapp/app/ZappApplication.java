package com.zapptitude.firstgrademathapp.app;


import android.app.Application;

public class ZappApplication extends Application {
    private static ZappApplication singleton;

    public static ZappApplication getSingleton() {
        return singleton;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        singleton = this;
    }

    public AppPrefs getAppPrefs() {
        return AppPrefs.getInstance(getApplicationContext());
    }
}

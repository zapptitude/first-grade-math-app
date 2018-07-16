package com.zapptitude.firstgrademathapp.app;


import android.content.Context;
import android.content.SharedPreferences;

import mev.zappsdk.modules.ZApplication;

/**
 * Created by andrew on 07.04.16.
 */
public class ZappApplication extends ZApplication {
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

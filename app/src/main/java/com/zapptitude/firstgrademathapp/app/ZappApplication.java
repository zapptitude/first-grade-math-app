package com.zapptitude.firstgrademathapp.app;

import android.support.multidex.MultiDexApplication;
import com.crashlytics.android.Crashlytics;
import io.fabric.sdk.android.Fabric;

public class ZappApplication extends MultiDexApplication {
    private static ZappApplication singleton;

    public static ZappApplication getSingleton() {
        return singleton;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Fabric.with(this, new Crashlytics());
        singleton = this;
    }

    public org.firestar.app.AppPrefs getAppPrefs() {
        return org.firestar.app.AppPrefs.Companion.getInstance(getApplicationContext());
    }
}

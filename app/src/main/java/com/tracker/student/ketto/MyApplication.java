package com.tracker.student.ketto;

import android.app.Application;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class MyApplication extends Application {
    static MyApplication instance;
    @Override
    public void onCreate() {
        instance = this;
        super.onCreate();
        RealmConfiguration config = new RealmConfiguration.Builder(this).build();
        Realm.setDefaultConfiguration(config);
    }

    public static MyApplication getInstance()
    {
        return instance;
    }
}

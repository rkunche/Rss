package com.tracker.student.ketto;

import android.app.Application;

import java.util.concurrent.atomic.AtomicInteger;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class MyApplication extends Application {
   static AtomicInteger atomicInteger;
    @Override
    public void onCreate() {
        super.onCreate();
        RealmConfiguration config = new RealmConfiguration.Builder(this).build();
        Realm.setDefaultConfiguration(config);
        atomicInteger = new AtomicInteger();
    }
    public static AtomicInteger getAtomicInteger()
    {
        return atomicInteger;
    }
}

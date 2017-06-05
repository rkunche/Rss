package com.tracker.student.ketto;

import android.app.Application;

import java.util.concurrent.atomic.AtomicInteger;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class MyApplication extends Application {
<<<<<<< HEAD
    static MyApplication instance;
=======
   static AtomicInteger atomicInteger;
>>>>>>> b599fa6c197d3cd6f8c9c4a0de8518f67ca1bc39
    @Override
    public void onCreate() {
        instance = this;
        super.onCreate();
        RealmConfiguration config = new RealmConfiguration.Builder(this).build();
        Realm.setDefaultConfiguration(config);
        atomicInteger = new AtomicInteger();
    }
    public static AtomicInteger getAtomicInteger()
    {
        return atomicInteger;
    }

    public static MyApplication getInstance()
    {
        return instance;
    }
}

package com.tracker.models;


import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class DateMap extends RealmObject{

    @PrimaryKey
    private String key;
    private boolean value;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public boolean isValue() {
        return value;
    }

    public void setValue(boolean value) {
        this.value = value;
    }
}


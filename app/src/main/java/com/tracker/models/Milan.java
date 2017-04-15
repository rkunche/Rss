package com.tracker.models;


import io.realm.RealmObject;

public class Milan extends RealmObject{
   private String milan;

    public String getMilan() {
        return milan;
    }

    public void setMilan(String milan) {
        this.milan = milan;
    }
}

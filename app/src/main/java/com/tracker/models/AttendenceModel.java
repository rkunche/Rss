package com.tracker.models;

import io.realm.RealmObject;



public class AttendenceModel extends RealmObject{

    private String date;
    private String name;
    private  String milan;
    private String khand;
    private boolean isPresent;

    public boolean isPresent() {
        return isPresent;
    }

    public void setPresent(boolean present) {
        isPresent = present;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMilan() {
        return milan;
    }

    public void setMilan(String milan) {
        this.milan = milan;
    }

    public String getKhand() {
        return khand;
    }

    public void setKhand(String khand) {
        this.khand = khand;
    }
}

package com.tracker.models;

import java.util.Date;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;


public class AttendenceModel extends RealmObject{

    @PrimaryKey
    private String id;//date+id comobo
    private Date date;
    private String name;
    private  String milan;
    private String khand;
    private boolean isPresent;

    private int year;
    private int month;

    private int week;

    public boolean isPresent() {
        return isPresent;
    }

    public void setPresent(boolean present) {
        isPresent = present;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
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
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getWeek() {
        return week;
    }

    public void setWeek(int week) {
        this.week = week;
    }

}

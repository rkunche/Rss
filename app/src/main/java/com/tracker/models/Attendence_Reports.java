package com.tracker.models;

import java.util.Date;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;


public class Attendence_Reports extends RealmObject{

    private String milan;
    private String khand;

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

    public String getWeekormonth() {
        return weekormonth;
    }

    public void setWeekormonth(String weekormonth) {
        this.weekormonth = weekormonth;
    }

    private String weekormonth;

   }

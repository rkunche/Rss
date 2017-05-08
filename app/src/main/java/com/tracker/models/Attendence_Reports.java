package com.tracker.models;

import java.util.Date;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;


public class Attendence_Reports extends RealmObject{

    private String milan;
    private String khand;
    private String weekormonth;
    public String getMilan() {
        return milan;
    }
    public void setMilan(String milan) {
        milan = this.milan;
    }

    public String getKhand() {
        return khand;
    }
    public void setKhand(String khand) {
        khand = this.khand;
    }

    public void setWeekormonth(String weekormonth){weekormonth=this.weekormonth;}

    public String getWeekormonth(){return weekormonth;}

   }

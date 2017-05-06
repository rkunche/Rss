package com.tracker.models;

import java.util.Date;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;


public class Attendence_Reports extends RealmObject{


    private  String milan;
    private String khand;
    private String weekormonth;
    private String monName;
    private String weekName;
    private int pCount;
    private int aCount;
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
    public void setWeekormonth(String weekormonth){this.weekormonth=weekormonth;}
    public String getWeekormonth(){return weekormonth;}
    public void setRptValues(String monName,String weekName,int pCount,int aCount){
        monName=this.monName;
        weekName=this.weekName;
        pCount=this.pCount;
        aCount=this.aCount;
    }

}

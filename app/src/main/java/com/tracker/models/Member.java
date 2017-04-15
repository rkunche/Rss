package com.tracker.models;


import io.realm.RealmObject;

public class Member extends RealmObject{

    private String mContact;
    private String mAddress;
    private String mName;
    private String mKhand;
    private String milan;
    private String jointime;

    public String getJointime() {
        return jointime;
    }

    public void setJointime(String jointime) {
        this.jointime = jointime;
    }

    public String getmContact() {
        return mContact;
    }

    public void setmContact(String mContact) {
        this.mContact = mContact;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }
    public void setmAddress(String mAddress){this.mAddress=mAddress;}
    public String getmAddress(){return mAddress;}

    public String getmKhand() {
        return mKhand;
    }

    public void setmKhand(String mKhand) {
        this.mKhand = mKhand;
    }

    public String getMilan() {
        return milan;
    }

    public void setMilan(String milan) {
        this.milan = milan;
    }
}

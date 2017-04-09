package com.tracker.models;


import io.realm.RealmObject;

public class Member extends RealmObject{

    private String mContact;
    private String mName;
    private String mKhand;
    private String meanen;

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

    public String getmKhand() {
        return mKhand;
    }

    public void setmKhand(String mKhand) {
        this.mKhand = mKhand;
    }

    public String getMeanen() {
        return meanen;
    }

    public void setMeanen(String meanen) {
        this.meanen = meanen;
    }
}

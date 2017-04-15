package com.tracker.models;


import io.realm.RealmObject;

public class Khanda extends RealmObject {
    private String khanda;

    public String getKhanda() {
        return khanda;
    }

    public void setKhanda(String khanda) {
        this.khanda = khanda;
    }
}

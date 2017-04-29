package com.tracker.localmodels;


import com.tracker.models.AttendenceModel;
import com.tracker.utils.DateUtils;

import java.util.Date;

public class LAttendenceModel {
    private String id;//date+id comobo
    private Date date;
    private String name;
    private  String milan;
    private String khand;
    private boolean isPresent;

    private int year;

    public int getWeek() {
        return week;
    }

    public void setWeek(int week) {
        this.week = week;
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

    private int month;

    private int week;

    public boolean isPresent() {
        return isPresent;
    }

    public void setPresent(boolean present) {
        isPresent = present;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public LAttendenceModel getAttendenceModel(LMemeber memeber)
    {
        LAttendenceModel lAttendenceModel = new LAttendenceModel();
        lAttendenceModel.setId(DateUtils.getDateKey()+memeber.getmContact());
        lAttendenceModel.setKhand(memeber.getmKhand());
        lAttendenceModel.setMilan(memeber.getMilan());
        lAttendenceModel.setDate(new Date());
        lAttendenceModel.setName(memeber.getmName());
        return lAttendenceModel;
    }

    public LAttendenceModel getAttendenceModel(AttendenceModel memeber)
    {
        LAttendenceModel lAttendenceModel = new LAttendenceModel();
        lAttendenceModel.setId(memeber.getId());
        lAttendenceModel.setKhand(memeber.getKhand());
        lAttendenceModel.setMilan(memeber.getMilan());
        lAttendenceModel.setDate(new Date());
        lAttendenceModel.setName(memeber.getName());
        return lAttendenceModel;
    }
}

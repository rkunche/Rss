package com.tracker.student.ketto;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;

import com.tracker.adapter.AttendenceAdapter;

public class Attendence extends AppCompatActivity {
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendence);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        listView = (ListView)findViewById(R.id.listview_attendence);
        AttendenceAdapter attendenceAdapter = new AttendenceAdapter(this);
        listView.setAdapter(attendenceAdapter);
        setSupportActionBar(toolbar);

    }

}

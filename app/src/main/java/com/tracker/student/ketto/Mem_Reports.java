package com.tracker.student.ketto;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioGroup;

import butterknife.BindView;

public class Mem_Reports extends AppCompatActivity {
    @BindView(R.id.Radio_Milan);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mem__reports);

    }
}

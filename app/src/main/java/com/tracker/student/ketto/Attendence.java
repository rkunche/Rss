package com.tracker.student.ketto;

import android.app.DatePickerDialog;
import android.app.Dialog;


import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;

import com.tracker.DateListener.DateListener;
import com.tracker.adapter.AttendenceAdapter;
import com.tracker.fragment.DateFragment;
import com.tracker.models.Member;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Attendence extends AppCompatActivity implements DateListener{

    @BindView(R.id.listview_attendence) ListView listView;
    @BindView(R.id.rss_spinner) Spinner spinner;
    @BindView(R.id.rss_spinner_milan) Spinner millanSpinnere;
    @BindView(R.id.toolbar) Toolbar toolbar;
    @BindView(R.id.time_setting)
    TextView timeSetting;
    FloatingActionButton fab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendence);
        ButterKnife.bind(this);
        spinner.setOnItemSelectedListener(new SpinnerSelectionListener());
        AttendenceAdapter attendenceAdapter = new AttendenceAdapter(this, null);
        listView.setAdapter(attendenceAdapter);
        setSupportActionBar(toolbar);
        refreshMilan();
        refreshKhanda();

        timeSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog();
            }
        });

    }

    private class SpinnerSelectionListener implements AdapterView.OnItemSelectedListener {

        public void onItemSelected(AdapterView<?> parent, View view,
                                   int pos, long id) {
            Log.i("Selected item position ", "" + pos);
            List<Member> members = new ArrayList<>();
            for(int i=0;i<5;i++)
            {
                Member member = new Member();
                member.setmContact("1234423434");
                member.setmName("name "+pos);
                member.setmKhand("khand"+pos);
                members.add(member);
            }

            AttendenceAdapter attendenceAdapter = new AttendenceAdapter(Attendence.this, members);
            listView.setAdapter(attendenceAdapter);
        }

        public void onNothingSelected(AdapterView<?> parent) {

        }
    }

     void refreshMilan()
      {
          ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, android.R.id.text1);
          spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
          spinner.setAdapter(spinnerAdapter);
          spinnerAdapter.add("value1");
          spinnerAdapter.add("value2");
          spinnerAdapter.add("value3");
          spinnerAdapter.add("value4");
          spinnerAdapter.add("value5");

          spinnerAdapter.notifyDataSetChanged();
      }

    void refreshKhanda()
    {
        ArrayAdapter<String> spinnerAdapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, android.R.id.text1);
        spinnerAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        millanSpinnere.setAdapter(spinnerAdapter2);
        spinnerAdapter2.add("value1");
        spinnerAdapter2.add("value2");
        spinnerAdapter2.add("value3");
        spinnerAdapter2.add("value4");
        spinnerAdapter2.add("value5");

        spinnerAdapter2.notifyDataSetChanged();
    }

    void showDialog() {
        FragmentManager fm = getSupportFragmentManager();
        DateFragment dialogFragment = new DateFragment ();
        dialogFragment.show(fm,"hii");
    }

    @Override
    public void onDateSet(String date) {
        timeSetting.setText(date);
    }
}

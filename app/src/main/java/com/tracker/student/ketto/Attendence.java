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
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.tracker.DateListener.DateListener;
import com.tracker.adapter.AttendenceAdapter;
import com.tracker.dbmanager.CrudMember;
import com.tracker.fragment.DateFragment;
import com.tracker.localmodels.LMemeber;
import com.tracker.models.AttendenceModel;
import com.tracker.models.Member;
import com.tracker.utils.DateUtils;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Attendence extends AppCompatActivity implements DateListener {

    @BindView(R.id.listview_attendence)
    ListView listView;
    @BindView(R.id.rss_spinner)
    Spinner spinner;
    @BindView(R.id.rss_spinner_milan)
    Spinner millanSpinnere;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.time_setting)
    TextView timeSetting;
    @BindView(R.id.save_action)
    Button saveAction;
    @BindView(R.id.cancel_action)
    Button cancelAction;
    AttendenceAdapter attendenceAdapter;
    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendence);
        ButterKnife.bind(this);
        spinner.setOnItemSelectedListener(new SpinnerSelectionListener());
        setSupportActionBar(toolbar);
        refreshMilan();
        refreshKhanda();
        timeSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog();
            }
        });

        saveAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (timeSetting.getText() == null) {
                    Toast.makeText(Attendence.this, "Select Date", Toast.LENGTH_LONG).show();
                    return;
                }
                attendenceAdapter.onSaveClick(null);
            }
        });

    }

    private class SpinnerSelectionListener implements AdapterView.OnItemSelectedListener {

        public void onItemSelected(AdapterView<?> parent, View view,
                                   int pos, long id) {
            Log.i("Selected item position ", "" + pos);
        }

        public void onNothingSelected(AdapterView<?> parent) {

        }
    }

    void refreshMilan() {
        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, android.R.id.text1);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        ArrayAdapter<CharSequence> milan_adapter = ArrayAdapter.createFromResource(this,
                R.array.milan_list, android.R.layout.simple_spinner_item);
        milan_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(milan_adapter);
    }

    void refreshKhanda() {
        ArrayAdapter<CharSequence> spinnerAdapter2 = ArrayAdapter.createFromResource(this,
                R.array.khanda_list, android.R.layout.simple_spinner_item);
        spinnerAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        millanSpinnere.setAdapter(spinnerAdapter2);
    }

    void showDialog() {
        FragmentManager fm = getSupportFragmentManager();
        DateFragment dialogFragment = new DateFragment();
        dialogFragment.show(fm, "hii");
    }

    @Override
    public void onDateSet(String date) {
        timeSetting.setText(DateUtils.getDateKey());
        getAttendence();
    }


    private void getAttendence() {

        String khanda = millanSpinnere.getSelectedItem().toString();
        String milan = spinner.getSelectedItem().toString();
        List<LMemeber> memberList = CrudMember.getInstance().getAllMembers(milan, khanda);
        CrudMember.getInstance().getAllAttendence();
        attendenceAdapter = new AttendenceAdapter(this, memberList);
        listView.setAdapter(attendenceAdapter);
    }
}

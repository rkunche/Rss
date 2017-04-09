package com.tracker.student.ketto;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import com.tracker.adapter.AttendenceAdapter;
import com.tracker.models.Member;

import java.util.ArrayList;
import java.util.List;

public class Attendence extends AppCompatActivity {
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendence);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        listView = (ListView) findViewById(R.id.listview_attendence);
        Spinner spinner = (Spinner) findViewById(R.id.rss_spinner);
        spinner.setOnItemSelectedListener(new SpinnerSelectionListener());
        AttendenceAdapter attendenceAdapter = new AttendenceAdapter(this, null);
        listView.setAdapter(attendenceAdapter);
        setSupportActionBar(toolbar);

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
}

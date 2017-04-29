package com.tracker.student.ketto;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.Spinner;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Mem_Reports extends AppCompatActivity {
    @BindView(R.id.spinner_Milan)
    Spinner spinnerMilan;
    @BindView(R.id.spinner_Khanda)
    Spinner spinnerKhanda;
    @BindView(R.id.radio_Weekly)
    RadioButton radioWeekly;
    @BindView(R.id.radio_Monthly)
    RadioButton radioMonthly;
    @BindView(R.id.radio_MKGroup)
    RadioGroup radioMKGroup;
    @BindView(R.id.Attendence_Report)
    ListView attendanceReport;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mem__reports);
        ButterKnife.bind(this);
        /* Invoking Populate Spinners Method*/
        populateSpinners();
        /* Invoking getReport Method */
        Button viewReport = (Button) findViewById(R.id.get_Report);
        viewReport.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                getReport();
            }
        });
    }
    public void populateSpinners(){
        /* populating Milan Spinner */

        ArrayAdapter<CharSequence> adapterMilan = ArrayAdapter.createFromResource(this,
                R.array.milan_list, android.R.layout.simple_spinner_item);
        adapterMilan.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerMilan.setAdapter(adapterMilan);
        /* populating Khanda Spinner */

        ArrayAdapter<CharSequence> adapterKhanda = ArrayAdapter.createFromResource(this,
                R.array.khanda_list, android.R.layout.simple_spinner_item);
        adapterKhanda.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerKhanda.setAdapter(adapterKhanda);

    }
    public void getReport(){
        String milanVal=spinnerMilan.getSelectedItem().toString().trim();
        String khandaVal=spinnerKhanda.getSelectedItem().toString().trim();
        int radioId=radioMKGroup.getCheckedRadioButtonId();
        RadioButton selctedButton=(RadioButton)findViewById(radioId);
        String radioText=selctedButton.getText().toString();

    }

}

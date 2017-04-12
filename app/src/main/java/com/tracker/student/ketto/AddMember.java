package com.tracker.student.ketto;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import static com.tracker.student.ketto.R.id.details_reset;

public class AddMember extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_member);
        /* populating Milan Spinner */
        Spinner Milan_Spinner = (Spinner) findViewById(R.id.mem_milan);
        ArrayAdapter<CharSequence> milan_adapter = ArrayAdapter.createFromResource(this,
                R.array.milan_list,android.R.layout.simple_spinner_item);
        milan_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Milan_Spinner.setAdapter(milan_adapter);
        /* populating Khanda Spinner */
        Spinner Khanda_Spinner = (Spinner) findViewById(R.id.mem_khanda);
        ArrayAdapter<CharSequence> khanda_adapter = ArrayAdapter.createFromResource(this,
                R.array.khanda_list,android.R.layout.simple_spinner_item);
        khanda_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Khanda_Spinner.setAdapter(khanda_adapter);
    }
    Button reset_memdet=(Button)findViewById(R.id.details_reset);
    reset_memdet.setOnClickListener(View view){
        
    }
}

package com.tracker.student.ketto;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.view.View.OnClickListener;

import com.tracker.models.Member;

//import static com.tracker.student.ketto.R.id.details_reset;
//import static com.tracker.student.ketto.R.id.mem_name;

public class AddMember extends AppCompatActivity {
    EditText ET1;
    EditText ET2;
    EditText ET3;
    Spinner SP1;
    Spinner SP2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_member);
        /* populating Milan Spinner */
        Spinner Milan_Spinner = (Spinner) findViewById(R.id.mem_milan);
        ArrayAdapter<CharSequence> milan_adapter = ArrayAdapter.createFromResource(this,
                R.array.milan_list, android.R.layout.simple_spinner_item);
        milan_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Milan_Spinner.setAdapter(milan_adapter);
        /* populating Khanda Spinner */
        Spinner Khanda_Spinner = (Spinner) findViewById(R.id.mem_khanda);
        ArrayAdapter<CharSequence> khanda_adapter = ArrayAdapter.createFromResource(this,
                R.array.khanda_list, android.R.layout.simple_spinner_item);
        khanda_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Khanda_Spinner.setAdapter(khanda_adapter);
        // Following lines will Reset Add Member Form Data
        Button reset_memdet = (Button) findViewById(R.id.details_reset);
        reset_memdet.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                ET1=(EditText)findViewById(R.id.mem_name);
                ET1.setText("");
                ET2=(EditText)findViewById(R.id.mem_contact);
                ET2.setText("");
                ET3=(EditText)findViewById(R.id.mem_address);
                ET3.setText("");
                SP1=(Spinner)findViewById(R.id.mem_milan);
                SP1.setSelection(0);
                SP2=(Spinner)findViewById(R.id.mem_khanda);
                SP2.setSelection(0);
            }
        });
        Button save_memdet=(Button)findViewById(R.id.details_save);
        save_memdet.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v1){
                ET1=(EditText)findViewById(R.id.mem_name);
                String MemName=ET1.getText().toString().trim();
                ET2=(EditText)findViewById(R.id.mem_contact);
                String MemContact=ET2.getText().toString().trim();
                ET3=(EditText)findViewById(R.id.mem_address);
                String MemAddress=ET3.getText().toString().trim();
                SP1=(Spinner)findViewById(R.id.mem_khanda);
                String MemKhanda=SP1.getSelectedItem().toString().trim();
                SP2=(Spinner)findViewById(R.id.mem_milan);
                String MemMilan=SP2.getSelectedItem().toString().trim();
                Member SaveMem=new Member();
                SaveMem.setmContact(MemContact);
                SaveMem.setmName(MemName);
                SaveMem.setMeanen(MemMilan);
                SaveMem.setmKhand(MemKhanda);
            }
        });
    }
}

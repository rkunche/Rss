package com.tracker.student.ketto;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.tracker.dbmanager.CrudMember;
import com.tracker.models.Member;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


//import static com.tracker.student.ketto.R.id.details_reset;
//import static com.tracker.student.ketto.R.id.mem_name;

public class AddMember extends AppCompatActivity {

    @BindView(R.id.mem_name)
    EditText memName;
    @BindView(R.id.mem_contact)
    EditText memContact;
    @BindView(R.id.mem_address)
    EditText memAddress;
    @BindView(R.id.mem_milan)
    Spinner spinnerMilan;
    @BindView(R.id.mem_khanda)
    Spinner spinnerKhanda;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_member);
        ButterKnife.bind(this);
        /* populating Milan Spinner */

        ArrayAdapter<CharSequence> milan_adapter = ArrayAdapter.createFromResource(this,
                R.array.milan_list, android.R.layout.simple_spinner_item);
        milan_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerMilan.setAdapter(milan_adapter);
        /* populating Khanda Spinner */

        ArrayAdapter<CharSequence> khanda_adapter = ArrayAdapter.createFromResource(this,
                R.array.khanda_list, android.R.layout.simple_spinner_item);
        khanda_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerKhanda.setAdapter(khanda_adapter);
        // Following lines will Reset Add Member Form Data
        Button reset_memdet = (Button) findViewById(R.id.details_reset);
        reset_memdet.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
               // memContact.setText("");
                //memAddress.setText("");
                //memName.setText("");
                //spinnerMilan.setSelection(0);
                //spinnerKhanda.setSelection(0);
                reset_formdata();

            }

            });
        Button save_memdet=(Button)findViewById(R.id.details_save);
        save_memdet.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v1){
                List<Member> members = CrudMember.getInstance().getAllMembers();
                for(Member member : members)
                {
                    Log.i("member info", "Name "+member.getmName());
                }
                String memNameVal= memName.getText().toString().trim();
                String memContactVal= memContact.getText().toString().trim();;
                String memAddressVal= memAddress.getText().toString().trim();
                String memKhandaVal= spinnerMilan.getSelectedItem().toString().trim();
                String memMilanVal= spinnerKhanda.getSelectedItem().toString().trim();
                Member saveMem=new Member();
                saveMem.setmContact(memContactVal);
                saveMem.setmName(memNameVal);
                saveMem.setMilan(memMilanVal);
                saveMem.setmKhand(memKhandaVal);
                saveMem.setmAddress(memAddressVal);
                CrudMember.getInstance().addMember(saveMem);
                reset_formdata();
            }
        });

    }

    public void reset_formdata(){
        memContact.setText("");
        memAddress.setText("");
        memName.setText("");
        spinnerMilan.setSelection(0);
        spinnerKhanda.setSelection(0);
    }
}

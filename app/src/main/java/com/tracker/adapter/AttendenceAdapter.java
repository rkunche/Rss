package com.tracker.adapter;


import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import com.tracker.dbmanager.CrudMember;
import com.tracker.localmodels.LAttendenceModel;
import com.tracker.localmodels.LMemeber;
import com.tracker.models.AttendenceModel;
import com.tracker.models.DateMap;
import com.tracker.models.Member;
import com.tracker.student.ketto.Attendence;
import com.tracker.student.ketto.R;
import com.tracker.utils.DateUtils;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmList;

public class AttendenceAdapter extends BaseAdapter {
    Context context;
    LayoutInflater inflater;
    List<LMemeber> memberList;
    public AttendenceAdapter(Context context, List<LMemeber> members)
    {
        this.context = context;
        this.memberList = members;
        inflater = LayoutInflater.from(context);
    }
    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public Object getItem(int i) {
        return memberList.get(i);
    }

    @Override
    public int getCount() {
        if(memberList == null)
        {
            return 0;
        }
        return memberList.size();
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        ViewItemHolder viewItemHolder = null;
        if(view == null)
        {
            viewItemHolder = new ViewItemHolder();
            view = inflater.inflate(R.layout.attendence_list_item,null);
            viewItemHolder.nameViewId = (TextView) view.findViewById(R.id.nametvew);
            viewItemHolder.contactViewId = (TextView)view.findViewById(R.id.contacttview);
            viewItemHolder.checkBoxId = (CheckBox)view.findViewById(R.id.presentchkbox);
            view.setTag(viewItemHolder);
        }
        viewItemHolder =(ViewItemHolder) view.getTag();
        viewItemHolder.nameViewId.setText(memberList.get(i).getmName());
        viewItemHolder.contactViewId.setText(memberList.get(i).getmContact());

        viewItemHolder.checkBoxId.setChecked(memberList.get(i).isPresentStatus());
        viewItemHolder.checkBoxId.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
               // memberList.get(i).setPresentStatus(b);
                LMemeber memeber = memberList.get(i);
                LAttendenceModel attendenceModel = new LAttendenceModel();
                LAttendenceModel lAttendenceModel = attendenceModel.getAttendenceModel(memeber);
                lAttendenceModel.setPresent(b);

//                Calendar calendar = Calendar.getInstance();
//                int date = calendar.get(Calendar.DATE);
//                int month = calendar.get(Calendar.MONTH);
//                int year = calendar.get(Calendar.YEAR);
                String key = DateUtils.getDateKey();
                String timeVaues[] = key.split("_");
                int date = Integer.valueOf(timeVaues[0]);
                int month = Integer.valueOf(timeVaues[1]);
                int year = Integer.valueOf(timeVaues[2]);
                int week = DateUtils.getWeek(Integer.valueOf(timeVaues[0]));
                lAttendenceModel.setWeek(week);
                lAttendenceModel.setMonth(Integer.valueOf(timeVaues[1]));
                lAttendenceModel.setYear(Integer.valueOf(timeVaues[2]));

                Log.i("saving status", "saving date& "+date);
                Log.i("saving status", "saving week& "+week);
                Log.i("saving status", "saving month& "+month);
                Log.i("saving status", "saving year& "+year);
                CrudMember.getInstance().saveAttendance(lAttendenceModel);
            }
        });
        return view;
    }

    private static class  ViewItemHolder
    {
      TextView nameViewId;
      TextView contactViewId;
      CheckBox checkBoxId;
    }

    public void onSaveClick(Date date)
    {
        memberList.clear();
        notifyDataSetChanged();
        Toast.makeText(context,"Saved",Toast.LENGTH_LONG).show();
    }



}

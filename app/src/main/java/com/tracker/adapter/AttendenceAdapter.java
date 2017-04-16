package com.tracker.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.tracker.dbmanager.CrudMember;
import com.tracker.models.AttendenceModel;
import com.tracker.models.Member;
import com.tracker.student.ketto.R;

import java.util.List;

public class AttendenceAdapter extends BaseAdapter {
    Context context;
    LayoutInflater inflater;
    List<AttendenceModel> memberList;
    public AttendenceAdapter(Context context, List<AttendenceModel> members)
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
        viewItemHolder.nameViewId.setText(memberList.get(i).getName());
        viewItemHolder.contactViewId.setText(memberList.get(i).getMilan());
        viewItemHolder.checkBoxId.setChecked(memberList.get(i).isPresent());
        viewItemHolder.checkBoxId.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                memberList.get(i).setPresent(b);
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

    public void onSaveClick(String date)
    {

        CrudMember.getInstance().saveAttendence(memberList,date);
    }
}

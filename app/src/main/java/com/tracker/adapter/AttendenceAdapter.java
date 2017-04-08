package com.tracker.adapter;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import com.tracker.student.ketto.R;

public class AttendenceAdapter extends BaseAdapter {
    Context context;
    LayoutInflater inflater;
    public AttendenceAdapter(Context context)
    {
       this.context = context;
        inflater = LayoutInflater.from(context);
    }
    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
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
        return null;
    }

    private static class  ViewItemHolder
    {
      TextView nameViewId;
      TextView contactViewId;
      CheckBox checkBoxId;
    }
}

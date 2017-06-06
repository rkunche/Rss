package com.tracker.adapter;


import android.content.Context;
import android.text.format.DateUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import com.tracker.localmodels.ReportResult;
import com.tracker.student.ketto.R;

public class ReportAdapter  extends BaseAdapter{
    ReportResult reportResult;
    Context context;
    LayoutInflater inflater;
    String type;
    public ReportAdapter(Context context, ReportResult reportResult,String type)
    {
        this.reportResult = reportResult;
        inflater = LayoutInflater.from(context);
        this.type =type;


    }
    @Override
    public int getCount() {
        return reportResult.countMap.size();
    }

    @Override
    public Object getItem(int i) {
        return reportResult.countMap.get(i);
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewItemHolder  viewItemHolder = null;

        if(view == null)
        {
            viewItemHolder = new ViewItemHolder();
            view = inflater.inflate(R.layout.report_view,null);
            viewItemHolder.time = (TextView) view.findViewById(R.id.time);
            viewItemHolder.present = (TextView)view.findViewById(R.id.present);
            viewItemHolder.obsent = (TextView) view.findViewById(R.id.obsent);
            view.setTag(viewItemHolder);
        }
        int val = i+1;

        viewItemHolder = (ViewItemHolder) view.getTag();
        viewItemHolder.time.setText(com.tracker.utils.DateUtils.getType(type,val));
        int present = reportResult.countMap.get(val) == null?0:reportResult.countMap.get(val);
        int obsent =reportResult.totalCount - (reportResult.countMap.get(val)==null?0: reportResult.countMap.get(val));
        viewItemHolder.present.setText(present+"");
        viewItemHolder.obsent.setText(obsent+"");
        return view;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    private static class  ViewItemHolder
    {
        TextView time;
        TextView present;
        TextView obsent;
    }
}

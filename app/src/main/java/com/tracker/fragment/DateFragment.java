package com.tracker.fragment;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.util.Log;
import android.widget.DatePicker;

import com.tracker.DateListener.DateListener;
import com.tracker.utils.DateUtils;

import java.util.Calendar;
import java.util.Date;


public class DateFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {
    Context activity;

    public DateFragment() {

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        activity = context;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the current date as the default date in the picker
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        // Create a new instance of DatePickerDialog and return it
        return new DatePickerDialog(getActivity(), this, year, month, day);
    }

    public void onDateSet(DatePicker view, int year, int month, int day) {
        // Do something with the date chosen by the user
        month = month + 1;
        String date = "" + day + "_" + month + "_" + year;
        DateListener dateListener = (DateListener) activity;
        // dateListener.onDateSet(date);

        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day);

        Date dateObj = calendar.getTime();
        Log.i("date obejct", " Date object " + month);

        DateUtils.setDate(date);
        dateListener.onDateSet(date);
        //Log.i("Time", "Time" + date);
    }
}
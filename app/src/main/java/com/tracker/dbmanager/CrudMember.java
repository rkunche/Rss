package com.tracker.dbmanager;


import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.IntentSender;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.UserHandle;
import android.support.annotation.IntDef;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresPermission;
import android.support.annotation.StringDef;
import android.support.annotation.StyleRes;
import android.util.Log;
import android.view.Display;

import com.tracker.localmodels.LAttendenceModel;
import com.tracker.localmodels.LMemeber;
import com.tracker.localmodels.ReportResult;
import com.tracker.models.AttendenceModel;
import com.tracker.models.DateMap;
import com.tracker.models.Member;
import com.tracker.student.ketto.MyApplication;
<<<<<<< HEAD
=======
import com.tracker.student.ketto.R;
import com.tracker.utils.DateUtils;
import com.tracker.models.Attendence_Reports;
>>>>>>> b599fa6c197d3cd6f8c9c4a0de8518f67ca1bc39

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.text.DateFormatSymbols;
import java.util.Map;

import io.realm.Realm;
import io.realm.RealmList;
import io.realm.RealmQuery;
import io.realm.RealmResults;
public class CrudMember {
    private Realm mRealm;
<<<<<<< HEAD

<<<<<<< HEAD
    public CrudMember(Context context) {
        mRealm = Realm.getDefaultInstance();
=======
    private CrudMember(Context context) {
        mRealm = Realm.getInstance(context);
>>>>>>> origin/master
=======
    private static CrudMember crudeMember;
    private CrudMember() {
        mRealm = Realm.getDefaultInstance();
>>>>>>> b599fa6c197d3cd6f8c9c4a0de8518f67ca1bc39
    }

    public static CrudMember getInstance()
    {
      if(crudeMember == null)
      {
          crudeMember = new CrudMember();
      }
        return crudeMember;

    }

    public void addMember(Member member) {
  try {

      mRealm.beginTransaction();
      long id = MyApplication.getAtomicInteger().getAndIncrement();
      Log.i("save meber srates", "save started " + id);
      Member rMemeber = mRealm.createObject(Member.class);
      rMemeber.setmName(member.getmName());
      rMemeber.setmContact(member.getmContact());
      rMemeber.setMilan(member.getMilan());
      rMemeber.setmKhand(member.getmKhand());
      mRealm.copyToRealmOrUpdate(rMemeber);
      mRealm.commitTransaction();
      Log.i("save meber srates", "save successfully");
  }catch (Exception e)
  {
      mRealm.cancelTransaction();
      e.printStackTrace();
  }
    }

    public void saveAllMembers(List<LMemeber> memberList)
    {
        LMemeber realmMember =new LMemeber();
        for(LMemeber member : memberList)
        {
            updateMember(realmMember.getMemeber(member));
        }
    }
    public void updateMember(Member member) {
        Log.i("save meber srates","save started");
        long id =  MyApplication.getAtomicInteger().getAndIncrement();
        mRealm.beginTransaction();
        Member rMemeber = mRealm.createObject(Member.class);
        rMemeber.setmName(member.getmName());
        rMemeber.setmContact(member.getmContact());
        rMemeber.setMilan(member.getMilan());
        rMemeber.setmKhand(member.getmKhand());
        mRealm.copyToRealmOrUpdate(rMemeber);
        mRealm.commitTransaction();
        Log.i("save meber srates","save successfully");
    }

    public void saveAttendance(LAttendenceModel obj)
    {
        try {
            mRealm.beginTransaction();
            Log.i("attenceModel exception","attendenceModel saving id "+obj.getId());
            //AttendenceModel attendenceModel1 = mRealm.createObject(AttendenceModel.class);
            AttendenceModel attendenceModel1 = new AttendenceModel();
            attendenceModel1.setDate(obj.getDate());
            attendenceModel1.setId(obj.getId());
            attendenceModel1.setName(obj.getName());
            attendenceModel1.setPresent(obj.isPresent());
            attendenceModel1.setKhand(obj.getKhand());
            attendenceModel1.setWeek(obj.getWeek());
            attendenceModel1.setMilan(obj.getMilan());
            attendenceModel1.setMonth(obj.getMonth());
            mRealm.copyToRealmOrUpdate(attendenceModel1);
            mRealm.commitTransaction();
        }catch (Exception e)
        {
            Log.i("attenceModel exception","attendenceModel exception ");
            e.printStackTrace();
            mRealm.cancelTransaction();
        }
    }
    public Member getMember(String contactInfo) {
        //Member member = mRealm.where(Member.class).equalTo(Member.ge, contactInfo).findFirst();

        return null;
    }

    public List<LMemeber> getAllMembers() {
        RealmResults<Member> results = mRealm.where(Member.class).findAll();
        List<LMemeber> members = new ArrayList<>();
        LMemeber lMemeber = new LMemeber();
        for (Member member : results) {
            AttendenceModel attendenceModel =   mRealm.where(AttendenceModel.class).equalTo("id",DateUtils.getDateKey()+member.getmContact()).findFirst();
            LMemeber lMemeber1 = lMemeber.getLMember(member);
            if(attendenceModel != null)
            {
                lMemeber1.setPresentStatus(attendenceModel.isPresent());
                Log.i("saving status", "saving status attendence model is not null "+attendenceModel.isPresent());
                Log.i("saving status", "saving status attendence model is not null "+attendenceModel.getId());
            } else {

                Log.i("saving status", "saving status attendence model is null ");
            }
            members.add(lMemeber1);
        }
        return members;
    }

    public List<LMemeber> getAllMembers(String milan, String khanda) {
        RealmResults<Member> realmResults = null;
        if(milan != null) {
            realmResults = mRealm.where(Member.class)
                    .equalTo("milan", milan)
                    .findAll();
        } else if(khanda != null)
        {
            realmResults = mRealm.where(Member.class)
                    .equalTo("mKhand", khanda)
                    .findAll();
        }
        List<LMemeber> members = new ArrayList<>();
        LMemeber lMemeber = new LMemeber();
        for (Member member : realmResults) {
            AttendenceModel attendenceModel =   mRealm.where(AttendenceModel.class).equalTo("id",DateUtils.getDateKey()+member.getmContact()).findFirst();
            Log.i("Key is ","KEY VALUE: "+DateUtils.getDateKey());
            LMemeber lMemeber1 = lMemeber.getLMember(member);
            if(attendenceModel != null)
            {
                lMemeber1.setPresentStatus(attendenceModel.isPresent());
                Log.i("saving status", "saving status attendence model is not null "+attendenceModel.isPresent());
                Log.i("saving status", "saving status attendence model is not null "+attendenceModel.getId());
            } else {

                Log.i("saving status", "saving status attendence model is null ");
            }
            members.add(lMemeber1);
        }
        return members;
    }

    public List<AttendenceModel> searchByMilanAndKhanda(String milan, String khanda,String date)
    {
        RealmResults<AttendenceModel> realmResults = mRealm.where(AttendenceModel.class)
                .equalTo("milan", milan)
                .or()
                .equalTo("khand", khanda)
                .findAll();
        return realmResults;
    }

    public void saveAttendence(List<AttendenceModel> attendenceModels,Date date)
    {
        for(AttendenceModel attendenceModel : attendenceModels)
        {
            mRealm.beginTransaction();
            AttendenceModel rMemeber = mRealm.createObject(AttendenceModel.class);
            rMemeber.setName(rMemeber.getName());
            rMemeber.setPresent(rMemeber.isPresent());
            rMemeber.setMilan(rMemeber.getMilan());
            rMemeber.setKhand(rMemeber.getKhand());
            rMemeber.setDate(date);
            rMemeber.setId(attendenceModel.getId());
            mRealm.copyToRealmOrUpdate(rMemeber);
            mRealm.commitTransaction();
        }
    }

    public void getAllAttendence()
    {
        RealmResults<AttendenceModel> results = mRealm.where(AttendenceModel.class).findAll();

        for(AttendenceModel attendenceModel : results)
        {
            Log.i("attenceModel","AttendenceModel "+attendenceModel.getId());
        }
    }

    public ReportResult getAttendenceReport(Attendence_Reports Areport) {
        String milanVal = Areport.getMilan();
        String khandaVal = Areport.getKhand();
        String worm = Areport.getWeekormonth();
        ReportResult reportResult = new ReportResult();
        Map<Integer, Integer> countMap = new HashMap<>();

        if (worm.equals("Weekly")) {
            Calendar CalIns = Calendar.getInstance();
            int CurMon = CalIns.get(Calendar.MONTH) + 1;
            for (int i = 1; i <= 4; i++) {
                RealmQuery<AttendenceModel> realmResults_P = mRealm.where(AttendenceModel.class);

                realmResults_P.beginGroup();
                realmResults_P.equalTo("khand", khandaVal);
                realmResults_P.equalTo("milan", milanVal);
                realmResults_P.equalTo("week", i);
                realmResults_P.equalTo("isPresent", true);
                realmResults_P.endGroup();
                RealmResults<AttendenceModel> result = realmResults_P.findAll();
                countMap.put(i, result.size());
                Log.i("size ", "Realm result size is " + result.size());
            }
        } else {
            for (int i = 1; i <= 12; i++) {
                RealmQuery<AttendenceModel> realmResults_P = mRealm.where(AttendenceModel.class);

                realmResults_P.beginGroup();
                realmResults_P.equalTo("khand", khandaVal);
                realmResults_P.equalTo("milan", milanVal);
                realmResults_P.equalTo("month", i);
                realmResults_P.equalTo("isPresent", true);
                realmResults_P.endGroup();
                RealmResults<AttendenceModel> result = realmResults_P.findAll();
                countMap.put(i, result.size());
            }
        }

        RealmQuery<Member> totalCountQuery = mRealm.where(Member.class);

        totalCountQuery.beginGroup();
        totalCountQuery.equalTo("mKhand", khandaVal);
        totalCountQuery.equalTo("milan", milanVal);
        totalCountQuery.endGroup();
        RealmResults<Member> result = totalCountQuery.findAll();
        reportResult.totalCount = result.size();
        reportResult.countMap = countMap;
        return reportResult;
    }

}

package com.tracker.dbmanager;


import android.content.Context;
import android.util.Log;

import com.tracker.localmodels.LAttendenceModel;
import com.tracker.localmodels.LMemeber;
import com.tracker.models.AttendenceModel;
import com.tracker.models.DateMap;
import com.tracker.models.Member;
import com.tracker.student.ketto.MyApplication;
import com.tracker.utils.DateUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmList;
import io.realm.RealmResults;

public class CrudMember {
    private Realm mRealm;
    private static CrudMember crudeMember;
    private CrudMember() {
        mRealm = Realm.getDefaultInstance();
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
            Log.i("Key is "+DateUtils.getDateKey(),"");
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

}

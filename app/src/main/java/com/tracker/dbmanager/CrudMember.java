package com.tracker.dbmanager;


import android.content.Context;
import android.util.Log;

import com.tracker.models.AttendenceModel;
import com.tracker.models.Member;

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
        Log.i("save meber srates","save started");
        mRealm.beginTransaction();
        Member rMemeber = mRealm.createObject(Member.class);
        rMemeber.setmName(member.getmName());
        rMemeber.setmContact(member.getmContact());
        rMemeber.setMilan(member.getMilan());
        rMemeber.setmKhand(member.getmKhand());
        mRealm.commitTransaction();
        Log.i("save meber srates","save successfully");
    }

    public Member getMember(String contactInfo) {
        //Member member = mRealm.where(Member.class).equalTo(Member.ge, contactInfo).findFirst();

        return null;
    }

    public List<Member> getAllMembers() {
        RealmResults results = mRealm.where(Member.class).findAll();
        return results;
    }

    public List<AttendenceModel> searchByMilanAndKhanda(String milan, String khanda,String date)
    {
        RealmResults<AttendenceModel> realmResults = mRealm.where(AttendenceModel.class)
                .equalTo("milan", milan)
                .or()
                .equalTo("mKhand", khanda)
                .findAll();
        return realmResults;
    }

    public void saveAttendence(List<AttendenceModel> attendenceModels,String date)
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
            mRealm.commitTransaction();
        }
    }

}

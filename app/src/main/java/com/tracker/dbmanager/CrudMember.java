package com.tracker.dbmanager;


import android.content.Context;

import com.tracker.models.Member;
import com.tracker.student.ketto.MyApplication;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmList;
import io.realm.RealmResults;

public class CrudMember {
    private Realm mRealm;

    public CrudMember(Context context) {
        mRealm = Realm.getDefaultInstance();
    }

    public void addMember(Member member) {
        mRealm.beginTransaction();
        Member rMemeber = mRealm.createObject(Member.class);
        rMemeber.setmName(member.getmName());
        rMemeber.setmContact(member.getmContact());
        rMemeber.setMilan(member.getMilan());
        rMemeber.setmKhand(member.getmKhand());
        mRealm.commitTransaction();
    }

    public Member getMember(String contactInfo) {
        //Member member = mRealm.where(Member.class).equalTo(Member.ge, contactInfo).findFirst();

        return null;
    }

    public List<Member> getAllMembers() {
        RealmResults results = mRealm.where(Member.class).findAll();
        return results;
    }

    public List<Member> searchByMilanAndKhanda(String milan, String khanda,String date)
    {
        RealmResults<Member> realmResults = mRealm.where(Member.class)
                .equalTo("milan", milan)
                .or()
                .equalTo("mKhand", khanda)
                .or()
                .equalTo("date",date)
                .findAll();
        return realmResults;
    }

}

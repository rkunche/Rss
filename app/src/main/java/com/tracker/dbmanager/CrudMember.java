package com.tracker.dbmanager;


import android.content.Context;

import com.tracker.models.Member;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmList;
import io.realm.RealmResults;

public class CrudMember {
    private Realm mRealm;

    private CrudMember(Context context) {
        mRealm = Realm.getInstance(context);
    }

    public static CurdMember

    public void addMember(Member member) {
        mRealm.beginTransaction();
        Member rMemeber = mRealm.createObject(Member.class);
        rMemeber.setmName(member.getmName());
        rMemeber.setmContact(member.getmContact());
        rMemeber.setMeanen(member.getMeanen());
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

}

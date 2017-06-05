package com.tracker.localmodels;


import com.tracker.models.Member;

public class LMemeber {
    private String mContact;
    private String mAddress;
    private String mName;
    private String mKhand;
    private String milan;
    private String jointime;


    private boolean presentStatus;

    public String getmContact() {
        return mContact;
    }

    public void setmContact(String mContact) {
        this.mContact = mContact;
    }

    public String getmAddress() {
        return mAddress;
    }

    public void setmAddress(String mAddress) {
        this.mAddress = mAddress;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmKhand() {
        return mKhand;
    }

    public void setmKhand(String mKhand) {
        this.mKhand = mKhand;
    }

    public String getMilan() {
        return milan;
    }

    public void setMilan(String milan) {
        this.milan = milan;
    }

    public String getJointime() {
        return jointime;
    }

    public void setJointime(String jointime) {
        this.jointime = jointime;
    }

    public boolean isPresentStatus() {
        return presentStatus;
    }

    public void setPresentStatus(boolean presentStatus) {
        this.presentStatus = presentStatus;
    }

    public LMemeber getLMember(Member member)
    {
        LMemeber lMemeber =new LMemeber();
        lMemeber.setmContact(member.getmContact());
        lMemeber.setMilan(member.getMilan());
        lMemeber.setmKhand(member.getmKhand());
        lMemeber.setJointime(member.getJointime());
        lMemeber.setmAddress(member.getmAddress());
        lMemeber.setmName(member.getmName());
        return lMemeber;
    }

    public Member getMemeber(LMemeber member)
    {
        Member lMemeber =new Member();
        lMemeber.setmContact(member.getmContact());
        lMemeber.setMilan(member.getMilan());
        lMemeber.setmKhand(member.getmKhand());
        lMemeber.setJointime(member.getJointime());
        lMemeber.setmAddress(member.getmAddress());
        return lMemeber;
    }
}

package com.mmmgdzl.pojo;

import java.util.Date;

public class AdminLoginInfo {
    private Integer alid;

    private Integer aid;

    private String alip;

    private String aladdress;

    private Date aldate;

    public Integer getAlid() {
        return alid;
    }

    public void setAlid(Integer alid) {
        this.alid = alid;
    }

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public String getAlip() {
        return alip;
    }

    public void setAlip(String alip) {
        this.alip = alip == null ? null : alip.trim();
    }

    public String getAladdress() {
        return aladdress;
    }

    public void setAladdress(String aladdress) {
        this.aladdress = aladdress == null ? null : aladdress.trim();
    }

    public Date getAldate() {
        return aldate;
    }

    public void setAldate(Date aldate) {
        this.aldate = aldate;
    }
}
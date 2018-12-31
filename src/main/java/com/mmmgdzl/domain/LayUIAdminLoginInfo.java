package com.mmmgdzl.domain;

import com.mmmgdzl.pojo.AdminLoginInfo;

import java.text.SimpleDateFormat;

public class LayUIAdminLoginInfo {
    private Integer alid;

    private String aaccount;

    private String alip;

    private String aladdress;

    private String aldate;

    public LayUIAdminLoginInfo() {};
    public LayUIAdminLoginInfo(AdminLoginInfo adminLoginInfo) {
        this.alid = adminLoginInfo.getAlid();
        this.alip = adminLoginInfo.getAlip();
        this.aladdress = adminLoginInfo.getAladdress();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        this.aldate = sdf.format(adminLoginInfo.getAldate());
    }

    public Integer getAlid() {
        return alid;
    }

    public void setAlid(Integer alid) {
        this.alid = alid;
    }

    public String getAaccount() {
        return aaccount;
    }

    public void setAaccount(String aaccount) {
        this.aaccount = aaccount;
    }

    public String getAlip() {
        return alip;
    }

    public void setAlip(String alip) {
        this.alip = alip;
    }

    public String getAladdress() {
        return aladdress;
    }

    public void setAladdress(String aladdress) {
        this.aladdress = aladdress;
    }

    public String getAldate() {
        return aldate;
    }

    public void setAldate(String aldate) {
        this.aldate = aldate;
    }
}
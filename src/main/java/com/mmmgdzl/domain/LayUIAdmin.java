package com.mmmgdzl.domain;

import com.mmmgdzl.pojo.Admin;

import java.text.SimpleDateFormat;

public class LayUIAdmin {

    private Integer aid;

    private String aaccount;

    private String alevel;

    private String aenable;

    private String aactive;

    private String acreatedate;

    private String aname;

    private String agender;

    private String amail;

    private String aphone;

    public LayUIAdmin(){};
    public LayUIAdmin(Admin admin) {
        this.aid = admin.getAid();
        this.aaccount = admin.getAaccount();
        if(admin.getAenable() == 0) {
            this.aenable = "否";
        } else {
            this.aenable = "是";
        }
        if(admin.getAactive() == 0) {
            this.aactive = "否";
        } else {
            this.aactive = "是";
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        this.acreatedate = sdf.format(admin.getAcreatedate());
        this.aname = admin.getAname();
        if(admin.getAgender() == 0) {
            this.agender = "男";
        } else if(admin.getAgender() == 1) {
            this.agender = "女";
        } else {
            this.agender = "保密";
        }
        this.amail = admin.getAmail();
        this.aphone = admin.getAphone();
    }

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public String getAaccount() {
        return aaccount;
    }

    public void setAaccount(String aaccount) {
        this.aaccount = aaccount;
    }

    public String getAlevel() {
        return alevel;
    }

    public void setAlevel(String alevel) {
        this.alevel = alevel;
    }

    public String getAenable() {
        return aenable;
    }

    public void setAenable(String aenable) {
        this.aenable = aenable;
    }

    public String getAactive() {
        return aactive;
    }

    public void setAactive(String aactive) {
        this.aactive = aactive;
    }

    public String getAcreatedate() {
        return acreatedate;
    }

    public void setAcreatedate(String acreatedate) {
        this.acreatedate = acreatedate;
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    public String getAgender() {
        return agender;
    }

    public void setAgender(String agender) {
        this.agender = agender;
    }

    public String getAmail() {
        return amail;
    }

    public void setAmail(String amail) {
        this.amail = amail;
    }

    public String getAphone() {
        return aphone;
    }

    public void setAphone(String aphone) {
        this.aphone = aphone;
    }
}

package com.mmmgdzl.pojo;

import java.util.Date;

public class Admin {
    private Integer aid;

    private String aaccount;

    private String apassword;

    private Integer alevel;

    private Integer aenable;

    private Integer aactive;

    private String aactivecode;

    private Date acreatedate;

    private String aname;

    private Integer agender;

    private String amail;

    private String aphone;

    private String aheadimg;

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
        this.aaccount = aaccount == null ? null : aaccount.trim();
    }

    public String getApassword() {
        return apassword;
    }

    public void setApassword(String apassword) {
        this.apassword = apassword == null ? null : apassword.trim();
    }

    public Integer getAlevel() {
        return alevel;
    }

    public void setAlevel(Integer alevel) {
        this.alevel = alevel;
    }

    public Integer getAenable() {
        return aenable;
    }

    public void setAenable(Integer aenable) {
        this.aenable = aenable;
    }

    public Integer getAactive() {
        return aactive;
    }

    public void setAactive(Integer aactive) {
        this.aactive = aactive;
    }

    public String getAactivecode() {
        return aactivecode;
    }

    public void setAactivecode(String aactivecode) {
        this.aactivecode = aactivecode == null ? null : aactivecode.trim();
    }

    public Date getAcreatedate() {
        return acreatedate;
    }

    public void setAcreatedate(Date acreatedate) {
        this.acreatedate = acreatedate;
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname == null ? null : aname.trim();
    }

    public Integer getAgender() {
        return agender;
    }

    public void setAgender(Integer agender) {
        this.agender = agender;
    }

    public String getAmail() {
        return amail;
    }

    public void setAmail(String amail) {
        this.amail = amail == null ? null : amail.trim();
    }

    public String getAphone() {
        return aphone;
    }

    public void setAphone(String aphone) {
        this.aphone = aphone == null ? null : aphone.trim();
    }

    public String getAheadimg() {
        return aheadimg;
    }

    public void setAheadimg(String aheadimg) {
        this.aheadimg = aheadimg == null ? null : aheadimg.trim();
    }
}
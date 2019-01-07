package com.mmmgdzl.domain;

import com.mmmgdzl.pojo.ResourceColumn;

import java.text.SimpleDateFormat;

public class LayUIResourceColumn {

    private Integer cid;

    private String cname;

    private String ccreatedate;

    private String ccreater;

    private String cshowinheader;

    private String cenable;

    public LayUIResourceColumn() {};

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getCcreatedate() {
        return ccreatedate;
    }

    public void setCcreatedate(String ccreatedate) {
        this.ccreatedate = ccreatedate;
    }

    public String getCcreater() {
        return ccreater;
    }

    public void setCcreater(String ccreater) {
        this.ccreater = ccreater;
    }

    public String getCshowinheader() {
        return cshowinheader;
    }

    public void setCshowinheader(String cshowinheader) {
        this.cshowinheader = cshowinheader;
    }

    public String getCenable() {
        return cenable;
    }

    public void setCenable(String cenable) {
        this.cenable = cenable;
    }
}

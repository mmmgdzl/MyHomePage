package com.mmmgdzl.pojo;

import java.util.Date;

public class ResourceColumn {
    private Integer cid;

    private String cname;

    private Date ccreatedate;

    private Integer ccreater;

    private Integer cshowinheader;

    private Integer cenable;

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
        this.cname = cname == null ? null : cname.trim();
    }

    public Date getCcreatedate() {
        return ccreatedate;
    }

    public void setCcreatedate(Date ccreatedate) {
        this.ccreatedate = ccreatedate;
    }

    public Integer getCcreater() {
        return ccreater;
    }

    public void setCcreater(Integer ccreater) {
        this.ccreater = ccreater;
    }

    public Integer getCshowinheader() {
        return cshowinheader;
    }

    public void setCshowinheader(Integer cshowinheader) {
        this.cshowinheader = cshowinheader;
    }

    public Integer getCenable() {
        return cenable;
    }

    public void setCenable(Integer cenable) {
        this.cenable = cenable;
    }
}
package com.mmmgdzl.pojo;

import java.util.Date;

public class ResourceColumn {
    private Integer cid;

    private String cname;

    private Integer cparent;

    private Integer cisparent;

    private Date ccreatedate;

    private Integer ccreater;

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

    public Integer getCparent() {
        return cparent;
    }

    public void setCparent(Integer cparent) {
        this.cparent = cparent;
    }

    public Integer getCisparent() {
        return cisparent;
    }

    public void setCisparent(Integer cisparent) {
        this.cisparent = cisparent;
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
}
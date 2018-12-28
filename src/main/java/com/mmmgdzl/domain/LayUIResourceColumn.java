package com.mmmgdzl.domain;

import com.mmmgdzl.pojo.ResourceColumn;

import java.text.SimpleDateFormat;

public class LayUIResourceColumn {

    private Integer cid;

    private String cname;

    private String ccreatedate;

    private String ccreater;

    public LayUIResourceColumn() {};
    public LayUIResourceColumn(ResourceColumn resourceColumn) {
        //÷¥––‰÷»æ
        this.cid = resourceColumn.getCid();
        this.cname = resourceColumn.getCname();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        this.ccreatedate = sdf.format(resourceColumn.getCcreatedate());
    }

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
}

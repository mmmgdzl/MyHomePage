package com.mmmgdzl.pojo;

import java.util.Date;

public class SystemResourceColumn {
    private Integer srcid;

    private String srcname;

    private Integer srcenable;

    private Integer srccreater;

    private Date srccreatedate;

    public Integer getSrcid() {
        return srcid;
    }

    public void setSrcid(Integer srcid) {
        this.srcid = srcid;
    }

    public String getSrcname() {
        return srcname;
    }

    public void setSrcname(String srcname) {
        this.srcname = srcname == null ? null : srcname.trim();
    }

    public Integer getSrcenable() {
        return srcenable;
    }

    public void setSrcenable(Integer srcenable) {
        this.srcenable = srcenable;
    }

    public Integer getSrccreater() {
        return srccreater;
    }

    public void setSrccreater(Integer srccreater) {
        this.srccreater = srccreater;
    }

    public Date getSrccreatedate() {
        return srccreatedate;
    }

    public void setSrccreatedate(Date srccreatedate) {
        this.srccreatedate = srccreatedate;
    }
}
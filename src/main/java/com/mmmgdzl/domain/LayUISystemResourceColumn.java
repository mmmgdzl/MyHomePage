package com.mmmgdzl.domain;

public class LayUISystemResourceColumn {
    private Integer srcid;

    private String srcname;

    private String srcenable;

    private String srccreater;

    private String srccreatedate;

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

    public String getSrcenable() {
        return srcenable;
    }

    public void setSrcenable(String srcenable) {
        this.srcenable = srcenable;
    }

    public String getSrccreater() {
        return srccreater;
    }

    public void setSrccreater(String srccreater) {
        this.srccreater = srccreater;
    }

    public String getSrccreatedate() {
        return srccreatedate;
    }

    public void setSrccreatedate(String srccreatedate) {
        this.srccreatedate = srccreatedate;
    }
}
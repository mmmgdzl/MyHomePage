package com.mmmgdzl.pojo;

import java.util.Date;

public class ResourceColumnWebsite {
    private Integer rcwid;

    private Integer rcwcid;

    private String rcwname;

    private String rcwhref;

    private String rcwlogo;

    private Integer rcwcreater;

    private Date rcwcreatedate;

    private Integer rcwenable;

    public Integer getRcwid() {
        return rcwid;
    }

    public void setRcwid(Integer rcwid) {
        this.rcwid = rcwid;
    }

    public Integer getRcwcid() {
        return rcwcid;
    }

    public void setRcwcid(Integer rcwcid) {
        this.rcwcid = rcwcid;
    }

    public String getRcwname() {
        return rcwname;
    }

    public void setRcwname(String rcwname) {
        this.rcwname = rcwname == null ? null : rcwname.trim();
    }

    public String getRcwhref() {
        return rcwhref;
    }

    public void setRcwhref(String rcwhref) {
        this.rcwhref = rcwhref == null ? null : rcwhref.trim();
    }

    public String getRcwlogo() {
        return rcwlogo;
    }

    public void setRcwlogo(String rcwlogo) {
        this.rcwlogo = rcwlogo == null ? null : rcwlogo.trim();
    }

    public Integer getRcwcreater() {
        return rcwcreater;
    }

    public void setRcwcreater(Integer rcwcreater) {
        this.rcwcreater = rcwcreater;
    }

    public Date getRcwcreatedate() {
        return rcwcreatedate;
    }

    public void setRcwcreatedate(Date rcwcreatedate) {
        this.rcwcreatedate = rcwcreatedate;
    }

    public Integer getRcwenable() {
        return rcwenable;
    }

    public void setRcwenable(Integer rcwenable) {
        this.rcwenable = rcwenable;
    }
}
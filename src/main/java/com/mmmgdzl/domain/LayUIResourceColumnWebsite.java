package com.mmmgdzl.domain;

import com.mmmgdzl.pojo.ResourceColumnWebsite;

import java.text.SimpleDateFormat;
import java.util.Date;

public class LayUIResourceColumnWebsite {

    private Integer rcwid;

    private String rcwcid;

    private String rcwname;

    private String rcwhref;

    private String rcwlogo;

    private String rcwcreater;

    private String rcwcreatedate;

    private String rcwenable;

    public LayUIResourceColumnWebsite() {}

    public LayUIResourceColumnWebsite(ResourceColumnWebsite resourceColumnWebsite) {

    }

    public Integer getRcwid() {
        return rcwid;
    }

    public void setRcwid(Integer rcwid) {
        this.rcwid = rcwid;
    }

    public String getRcwcid() {
        return rcwcid;
    }

    public void setRcwcid(String rcwcid) {
        this.rcwcid = rcwcid;
    }

    public String getRcwname() {
        return rcwname;
    }

    public void setRcwname(String rcwname) {
        this.rcwname = rcwname;
    }

    public String getRcwhref() {
        return rcwhref;
    }

    public void setRcwhref(String rcwhref) {
        this.rcwhref = rcwhref;
    }

    public String getRcwlogo() {
        return rcwlogo;
    }

    public void setRcwlogo(String rcwlogo) {
        this.rcwlogo = rcwlogo;
    }

    public String getRcwcreater() {
        return rcwcreater;
    }

    public void setRcwcreater(String rcwcreater) {
        this.rcwcreater = rcwcreater;
    }

    public String getRcwcreatedate() {
        return rcwcreatedate;
    }

    public void setRcwcreatedate(String rcwcreatedate) {
        this.rcwcreatedate = rcwcreatedate;
    }

    public String getRcwenable() {
        return rcwenable;
    }

    public void setRcwenable(String rcwenable) {
        this.rcwenable = rcwenable;
    }
}

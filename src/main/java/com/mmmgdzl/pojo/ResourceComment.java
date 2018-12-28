package com.mmmgdzl.pojo;

import java.util.Date;

public class ResourceComment {
    private Integer rcid;

    private Integer rccount;

    private Date rccreatedate;

    private Integer rccreater;

    private Integer rcresource;

    private Integer rcreply;

    private String rccontent;

    private Integer rcenable;

    public Integer getRcid() {
        return rcid;
    }

    public void setRcid(Integer rcid) {
        this.rcid = rcid;
    }

    public Integer getRccount() {
        return rccount;
    }

    public void setRccount(Integer rccount) {
        this.rccount = rccount;
    }

    public Date getRccreatedate() {
        return rccreatedate;
    }

    public void setRccreatedate(Date rccreatedate) {
        this.rccreatedate = rccreatedate;
    }

    public Integer getRccreater() {
        return rccreater;
    }

    public void setRccreater(Integer rccreater) {
        this.rccreater = rccreater;
    }

    public Integer getRcresource() {
        return rcresource;
    }

    public void setRcresource(Integer rcresource) {
        this.rcresource = rcresource;
    }

    public Integer getRcreply() {
        return rcreply;
    }

    public void setRcreply(Integer rcreply) {
        this.rcreply = rcreply;
    }

    public String getRccontent() {
        return rccontent;
    }

    public void setRccontent(String rccontent) {
        this.rccontent = rccontent == null ? null : rccontent.trim();
    }

    public Integer getRcenable() {
        return rcenable;
    }

    public void setRcenable(Integer rcenable) {
        this.rcenable = rcenable;
    }
}
package com.mmmgdzl.pojo;

import java.util.Date;

public class ResourceComment {
    private Integer rcid;

    private Integer rccount;

    private Integer rccreater;

    private Date rccreatedate;

    private Integer rcupdater;

    private Date rcupdatedate;

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

    public Integer getRccreater() {
        return rccreater;
    }

    public void setRccreater(Integer rccreater) {
        this.rccreater = rccreater;
    }

    public Date getRccreatedate() {
        return rccreatedate;
    }

    public void setRccreatedate(Date rccreatedate) {
        this.rccreatedate = rccreatedate;
    }

    public Integer getRcupdater() {
        return rcupdater;
    }

    public void setRcupdater(Integer rcupdater) {
        this.rcupdater = rcupdater;
    }

    public Date getRcupdatedate() {
        return rcupdatedate;
    }

    public void setRcupdatedate(Date rcupdatedate) {
        this.rcupdatedate = rcupdatedate;
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
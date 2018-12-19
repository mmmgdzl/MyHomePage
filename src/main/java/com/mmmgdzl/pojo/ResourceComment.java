package com.mmmgdzl.pojo;

import java.util.Date;

public class ResourceComment {
    private Integer rcId;

    private Date rccreatedate;

    private Integer rccreater;

    private Integer rcresource;

    private String rccontent;

    public Integer getRcId() {
        return rcId;
    }

    public void setRcId(Integer rcId) {
        this.rcId = rcId;
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

    public String getRccontent() {
        return rccontent;
    }

    public void setRccontent(String rccontent) {
        this.rccontent = rccontent == null ? null : rccontent.trim();
    }
}
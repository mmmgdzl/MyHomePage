package com.mmmgdzl.domain;

import com.mmmgdzl.pojo.Resource;

import java.text.SimpleDateFormat;

public class LayUIResource {
    private Integer rid;

    private String rtitle;

    private String rcolumn;

    private String rcreatedate;

    private String rcreater;

    private String rupdatedate;

    private String rupdater;

    private Integer rviews;

    private String renable;

    private String rcontent;

    private String rtitleimg;

    public LayUIResource(){};

    public String getRtitleimg() {
        return rtitleimg;
    }

    public void setRtitleimg(String rtitleimg) {
        this.rtitleimg = rtitleimg;
    }

    public String getRcontent() {
        return rcontent;
    }

    public void setRcontent(String rcontent) {
        this.rcontent = rcontent;
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public String getRtitle() {
        return rtitle;
    }

    public void setRtitle(String rtitle) {
        this.rtitle = rtitle;
    }

    public String getRcolumn() {
        return rcolumn;
    }

    public void setRcolumn(String rcolumn) {
        this.rcolumn = rcolumn;
    }

    public String getRcreatedate() {
        return rcreatedate;
    }

    public void setRcreatedate(String rcreatedate) {
        this.rcreatedate = rcreatedate;
    }

    public String getRcreater() {
        return rcreater;
    }

    public void setRcreater(String rcreater) {
        this.rcreater = rcreater;
    }

    public String getRupdatedate() {
        return rupdatedate;
    }

    public void setRupdatedate(String rupdatedate) {
        this.rupdatedate = rupdatedate;
    }

    public String getRupdater() {
        return rupdater;
    }

    public void setRupdater(String rupdater) {
        this.rupdater = rupdater;
    }

    public Integer getRviews() {
        return rviews;
    }

    public void setRviews(Integer rviews) {
        this.rviews = rviews;
    }

    public String getRenable() {
        return renable;
    }

    public void setRenable(String renable) {
        this.renable = renable;
    }
}
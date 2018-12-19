package com.mmmgdzl.pojo;

import java.util.Date;

public class Resource {
    private Integer rid;

    private String rtitle;

    private String rtitleimg;

    private Integer rcolumn;

    private Date rcreatedate;

    private Integer rcreater;

    private Date rupdatedate;

    private Integer rupdater;

    private Integer rviews;

    private String rcontent;

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
        this.rtitle = rtitle == null ? null : rtitle.trim();
    }

    public String getRtitleimg() {
        return rtitleimg;
    }

    public void setRtitleimg(String rtitleimg) {
        this.rtitleimg = rtitleimg == null ? null : rtitleimg.trim();
    }

    public Integer getRcolumn() {
        return rcolumn;
    }

    public void setRcolumn(Integer rcolumn) {
        this.rcolumn = rcolumn;
    }

    public Date getRcreatedate() {
        return rcreatedate;
    }

    public void setRcreatedate(Date rcreatedate) {
        this.rcreatedate = rcreatedate;
    }

    public Integer getRcreater() {
        return rcreater;
    }

    public void setRcreater(Integer rcreater) {
        this.rcreater = rcreater;
    }

    public Date getRupdatedate() {
        return rupdatedate;
    }

    public void setRupdatedate(Date rupdatedate) {
        this.rupdatedate = rupdatedate;
    }

    public Integer getRupdater() {
        return rupdater;
    }

    public void setRupdater(Integer rupdater) {
        this.rupdater = rupdater;
    }

    public Integer getRviews() {
        return rviews;
    }

    public void setRviews(Integer rviews) {
        this.rviews = rviews;
    }

    public String getRcontent() {
        return rcontent;
    }

    public void setRcontent(String rcontent) {
        this.rcontent = rcontent == null ? null : rcontent.trim();
    }
}
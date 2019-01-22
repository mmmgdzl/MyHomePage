package com.mmmgdzl.pojo;

import java.util.Date;

public class SystemResource {
    private Integer srid;

    private String srname;

    private Integer srcolumn;

    private Integer srcreater;

    private Date srcreatedate;

    private Integer srenable;

    private String srdesc;

    public Integer getSrid() {
        return srid;
    }

    public void setSrid(Integer srid) {
        this.srid = srid;
    }

    public String getSrname() {
        return srname;
    }

    public void setSrname(String srname) {
        this.srname = srname == null ? null : srname.trim();
    }

    public Integer getSrcolumn() {
        return srcolumn;
    }

    public void setSrcolumn(Integer srcolumn) {
        this.srcolumn = srcolumn;
    }

    public Integer getSrcreater() {
        return srcreater;
    }

    public void setSrcreater(Integer srcreater) {
        this.srcreater = srcreater;
    }

    public Date getSrcreatedate() {
        return srcreatedate;
    }

    public void setSrcreatedate(Date srcreatedate) {
        this.srcreatedate = srcreatedate;
    }

    public Integer getSrenable() {
        return srenable;
    }

    public void setSrenable(Integer srenable) {
        this.srenable = srenable;
    }

    public String getSrdesc() {
        return srdesc;
    }

    public void setSrdesc(String srdesc) {
        this.srdesc = srdesc == null ? null : srdesc.trim();
    }
}
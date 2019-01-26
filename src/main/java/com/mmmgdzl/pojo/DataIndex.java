package com.mmmgdzl.pojo;

public class DataIndex {
    private Integer diid;

    private String diname;

    private String divalue;

    public Integer getDiid() {
        return diid;
    }

    public void setDiid(Integer diid) {
        this.diid = diid;
    }

    public String getDiname() {
        return diname;
    }

    public void setDiname(String diname) {
        this.diname = diname == null ? null : diname.trim();
    }

    public String getDivalue() {
        return divalue;
    }

    public void setDivalue(String divalue) {
        this.divalue = divalue == null ? null : divalue.trim();
    }
}
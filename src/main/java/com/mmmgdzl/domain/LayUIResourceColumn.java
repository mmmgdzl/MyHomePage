package com.mmmgdzl.domain;

import com.mmmgdzl.pojo.ResourceColumn;

import java.text.SimpleDateFormat;

public class LayUIResourceColumn {

    private Integer cid;

    private String cname;

    private String ccreatedate;

    private String ccreater;

    private String cshowinheader;

    private String cenable;

    public LayUIResourceColumn() {};
    public LayUIResourceColumn(ResourceColumn resourceColumn) {
        //ִ����Ⱦ
        this.cid = resourceColumn.getCid();
        this.cname = resourceColumn.getCname();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        this.ccreatedate = sdf.format(resourceColumn.getCcreatedate());
        if(resourceColumn.getCenable() == 0) {
            this.cenable = "������";
        } else if(resourceColumn.getCenable() == 1) {
            this.cenable = "����";
        } else if(resourceColumn.getCenable() == 2) {
            this.cenable = "ɾ��";
        }
        if(resourceColumn.getCshowinheader() == 0) {
            this.cshowinheader = "��";
        } else {
            this.cshowinheader = "��";
        }
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getCcreatedate() {
        return ccreatedate;
    }

    public void setCcreatedate(String ccreatedate) {
        this.ccreatedate = ccreatedate;
    }

    public String getCcreater() {
        return ccreater;
    }

    public void setCcreater(String ccreater) {
        this.ccreater = ccreater;
    }

    public String getCshowinheader() {
        return cshowinheader;
    }

    public void setCshowinheader(String cshowinheader) {
        this.cshowinheader = cshowinheader;
    }

    public String getCenable() {
        return cenable;
    }

    public void setCenable(String cenable) {
        this.cenable = cenable;
    }
}

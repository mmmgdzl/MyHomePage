package com.mmmgdzl.domain;

import com.mmmgdzl.pojo.Admin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResourceCommentPageBean {

    private Integer rcCount;//�����Դ����������
    private Integer rcTotalPage;//�����Դ������ҳ��
    private Integer rcCurrentPage;//�����Դ���۵�ǰҳ
    private Integer rcPageSize;//�����Դ����ÿҳ����
    private List<LayUIResourceComment> resourceCommentList;//�����Դ��������
    private Map<Integer, Admin> resourceCommentAdminMap = new HashMap<>();//�����Դ�����û�����

    public Integer getRcCount() {
        return rcCount;
    }

    public void setRcCount(Integer rcCount) {
        this.rcCount = rcCount;
    }

    public Integer getRcTotalPage() {
        return rcTotalPage;
    }

    public void setRcTotalPage(Integer rcTotalPage) {
        this.rcTotalPage = rcTotalPage;
    }

    public Integer getRcCurrentPage() {
        return rcCurrentPage;
    }

    public void setRcCurrentPage(Integer rcCurrentPage) {
        this.rcCurrentPage = rcCurrentPage;
    }

    public Integer getRcPageSize() {
        return rcPageSize;
    }

    public void setRcPageSize(Integer rcPageSize) {
        this.rcPageSize = rcPageSize;
    }

    public List<LayUIResourceComment> getResourceCommentList() {
        return resourceCommentList;
    }

    public void setResourceCommentList(List<LayUIResourceComment> resourceCommentList) {
        this.resourceCommentList = resourceCommentList;
    }

    public Map<Integer, Admin> getResourceCommentAdminMap() {
        return resourceCommentAdminMap;
    }

    public void setResourceCommentAdminMap(Map<Integer, Admin> resourceCommentAdminMap) {
        this.resourceCommentAdminMap = resourceCommentAdminMap;
    }
}

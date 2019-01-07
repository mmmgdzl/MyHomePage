package com.mmmgdzl.domain;

import com.mmmgdzl.pojo.Admin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResourceCommentPageBean {

    private Integer rcCount;//存放资源评论总条数
    private Integer rcTotalPage;//存放资源评论总页数
    private Integer rcCurrentPage;//存放资源评论当前页
    private Integer rcPageSize;//存放资源评论每页条数
    private List<LayUIResourceComment> resourceCommentList;//存放资源评论数据
    private Map<Integer, Admin> resourceCommentAdminMap = new HashMap<>();//存放资源评论用户数据

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

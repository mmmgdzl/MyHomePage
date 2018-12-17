package com.mmmgdzl.domain;

import java.util.List;

public class PageBean<T> {

    //当前页码
    private Integer currentPage;
    //总页数
    private Integer totalPage;
    //总条数
    private Integer totalNum;
    //每页显示条数
    private Integer pageSize;

    //用于存放查询条件的对象,也可作他用
    private T obj;

    //用于存放列表数据
    private List<T> data;

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public Integer getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(Integer totalNum) {
        this.totalNum = totalNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public T getObj() {
        return obj;
    }

    public void setObj(T obj) {
        this.obj = obj;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}

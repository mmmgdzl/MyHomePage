package com.mmmgdzl.domain;

import java.util.List;

public class PageBean<T> {

    //��ǰҳ��
    private Integer currentPage;
    //��ҳ��
    private Integer totalPage;
    //������
    private Integer totalNum;
    //ÿҳ��ʾ����
    private Integer pageSize;

    //���ڴ�Ų�ѯ�����Ķ���,Ҳ��������
    private T obj;

    //���ڴ���б�����
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

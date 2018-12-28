package com.mmmgdzl.domain;

import java.util.List;

public class ResourceListPageBean<T> {

    //��ǰҳ��
    private Integer currentPage;
    //��ҳ��
    private Integer totalPage;
    //������
    private Integer totalNum;
    //ÿҳ��ʾ����
    private Integer pageSize;
    //��ǰҳ������
    private String type;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}

package com.mmmgdzl.domain;

import com.mmmgdzl.pojo.Admin;

public class ResourceInfoPageBean<T> {

    private T data;//�����Դ����
    private Admin creater;//��Ŵ���������
    private Admin updater;//�������޸�������

    public Admin getCreater() {
        return creater;
    }

    public void setCreater(Admin creater) {
        this.creater = creater;
    }

    public Admin getUpdater() {
        return updater;
    }

    public void setUpdater(Admin updater) {
        this.updater = updater;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
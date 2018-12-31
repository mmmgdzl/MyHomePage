package com.mmmgdzl.domain;

import com.mmmgdzl.pojo.Admin;

public class ResourceInfoPageBean<T> {

    private T data;//存放资源数据
    private Admin creater;//存放创建者数据
    private Admin updater;//存放最后修改者数据

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

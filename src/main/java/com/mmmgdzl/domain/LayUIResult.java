package com.mmmgdzl.domain;

import java.util.List;

public class LayUIResult<T>{

    //0-success -1-false
    private int code;
    //错误打印信息
    private String msg = null;
    //总条数
    private Integer count = null;
    //请求数据
    private List<T> data = null;

    public LayUIResult(int code, Integer count, List<T> data) {
        this.code = code;
        this.count = count;
        this.data = data;
    }

    public LayUIResult(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "LayUIResult{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", count=" + count +
                ", data=" + data +
                '}';
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}

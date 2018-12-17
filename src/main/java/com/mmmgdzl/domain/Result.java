package com.mmmgdzl.domain;

public class Result {
	
	private Integer code;
	private String msg;
	private Object data;
	
	/**
	 * ������Ϊ200�ĳɹ����
	 */
	public static Result OK() {
		Result result = new Result();
		result.code = 200;
		return result;
	}
	
	/**
	 * ������Ϊ200�Ĵ����ݵĳɹ����
	 */
	public static Result OK(Object data) {
		Result result = new Result();
		result.code = 200;
		result.data = data;
		return result;
	}
	
	/**
	 * �����Զ�����
	 */
	public static Result build(Integer code, String msg) {
		Result result = new Result();
		result.code = code;
		result.msg = msg;
		return result;
	}
	
	/**
	 * �����Զ�����
	 */
	public static Result build(Integer code, Object data) {
		Result result = new Result();
		result.code = code;
		result.data = data;
		return result;
	}
	
	/**
	 * �����Զ�����
	 */
	public static Result build(Integer code, String msg, Object data) {
		Result result = new Result();
		result.code = code;
		result.msg = msg;
		result.data = data;
		return result;
	}
	
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	
	
	
}

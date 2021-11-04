package com.tms.common.resp;

import java.io.Serializable;

public class ResponseData<T> implements Serializable {
private static final long serialVersionUID = 1L;
private String code;
private String msg;
private T data;
public ResponseData() {
	super();
}
public ResponseData(ResultCode resultCode) {
	super();
	this.code = resultCode.getCode();
	this.msg = resultCode.getMsg();
	
}
public ResponseData(String code, String msg) {
	super();
	this.code = code;
	this.msg = msg;
}
public ResponseData(ResultCode resultCode,T data) {
	super();
	this.code = resultCode.getCode();
	this.msg = resultCode.getMsg();
	this.data = data;
}
public ResponseData<T> success() {
	return new ResponseData<T>(ResultCode.SUCCESS);
}
public ResponseData<T> success(T data) {
	return new ResponseData<T>(ResultCode.SUCCESS, data);
}
public ResponseData<T> failure() {
	return new ResponseData<T>(ResultCode.FAILURE);
}
public ResponseData<T> failure(String msg) {
	return new ResponseData<T>(ResultCode.FAILURE.getCode(), msg);
}
public String getCode() {
	return code;
}
public void setCode(String code) {
	this.code = code;
}
public String getMsg() {
	return msg;
}
public void setMsg(String msg) {
	this.msg = msg;
}
public T getData() {
	return data;
}
public void setData(T data) {
	this.data = data;
}

}

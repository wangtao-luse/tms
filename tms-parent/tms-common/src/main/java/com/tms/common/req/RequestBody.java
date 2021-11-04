package com.tms.common.req;

import java.io.Serializable;

import com.alibaba.fastjson.JSONObject;

public class RequestBody implements Serializable {
private static final long serialVersionUID = 1L;
private JSONObject content;
public JSONObject getContent() {
	return content;
}
public void setContent(JSONObject content) {
	this.content = content;
}



}

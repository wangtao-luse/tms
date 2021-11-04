package com.tms.common.resp;

public enum ResultCode  {
	FAILURE("00", "系统错误！"),
	SUCCESS("10","操作成功！"),	
	AUTHORITY("20","你没有操作该资源权限,请联系管理员！");
	private final String code;
    private final String msg;	
	public String getCode() {
		return code;
	}
	public String getMsg() {
		return msg;
	}
	private ResultCode(String code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	
}

package com.weidong.blog.commons.until;


public class JsonResult {
	public final static int SUCCESS = 1;
	public final static int ERROR = 0;
	private int state;
	private String message;
	private Object data;
	public JsonResult() {
		this.state = SUCCESS;
		this.message = "OK";
	}
	
	public JsonResult(Throwable e) {
		this.state = ERROR;
		this.message = e.getMessage();
	}
	
	public JsonResult(Object data) {
		this.data = data;
		this.state = SUCCESS;
		this.message = "OK";
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "JsonResult [state=" + state + ", message=" + message + ", data=" + data + "]";
	}
 
	

}

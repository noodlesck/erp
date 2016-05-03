package com.noodles.vo;

import java.io.Serializable;

public class Json implements Serializable {
     private boolean success;
     private String msg = "";
     private Object obj = null;
	public boolean isSuccess() {
		return success;
	}
	public String getMsg() {
		return msg;
	}
	public Object getObj() {
		return obj;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public void setObj(Object obj) {
		this.obj = obj;
	}
     
}

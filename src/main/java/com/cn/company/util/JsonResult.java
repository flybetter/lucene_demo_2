package com.cn.company.util;

import java.io.Serializable;

public class JsonResult implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3342982794658391370L;
	private boolean success = true;
	private String message = "";
	private Object value;

	public boolean isSuccess() {
		return this.success;
	}

	public JsonResult setSuccess(boolean success) {
		this.success = success;
		return this;
	}

	public String getMessage() {
		return this.message;
	}

	public JsonResult setMessage(String message) {
		this.message = message;
		return this;
	}

	public Object getValue() {
		return this.value;
	}

	public JsonResult setValue(Object value) {
		this.value = value;
		return this;
	}


}

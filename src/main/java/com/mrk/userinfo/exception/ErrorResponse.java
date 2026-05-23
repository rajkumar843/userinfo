package com.mrk.userinfo.exception;

import java.time.LocalDateTime;

public class ErrorResponse {

	private String message;
	private Integer status;
	private LocalDateTime localtime;
	
	public ErrorResponse(String message, Integer status, LocalDateTime localtime) {
		super();
		this.message = message;
		this.status = status;
		this.localtime = localtime;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public LocalDateTime getLocaltime() {
		return localtime;
	}

	public void setLocaltime(LocalDateTime localtime) {
		this.localtime = localtime;
	}
	
	
	
}

package com.ibm.pe.primaxgo.microservices.dto;

import java.io.Serializable;

public class ResponseDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer errorCode;
	private String errorMessage;
	private String httpCode;
	private Object data;
	
	public ResponseDTO() {
		
	}
	
	public ResponseDTO(Integer errorCode, String errorMessage, String httpCode, Object data) {
		super();
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
		this.httpCode = httpCode;
		this.data = data;
	}

	public Integer getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(Integer errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public String getHttpCode() {
		return httpCode;
	}
	public void setHttpCode(String httpCode) {
		this.httpCode = httpCode;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	
}

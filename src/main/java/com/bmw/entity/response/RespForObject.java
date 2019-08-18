package com.bmw.entity.response;

import java.util.List;

public class RespForObject {
	private Integer code;
	private String message;
	private List<Object> basicInfoList;
	public RespForObject(Integer code, String message, List<Object> basicInfoList) {
		super();
		this.code = code;
		this.message = message;
		this.basicInfoList = basicInfoList;
	}
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public List<Object> getBasicInfoList() {
		return basicInfoList;
	}
	public void setBasicInfoList(List<Object> basicInfoList) {
		this.basicInfoList = basicInfoList;
	}
	public RespForObject() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}

package com.bmw.entity.response;

import java.util.List;

import com.bmw.entity.StationModel;


public class RespForStationList {
	private Integer code;
	private String message;
	
	
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

	private List<StationModel> items;
	
	public List<StationModel> getItems() {
		return items;
	}

	public void setItems(List<StationModel> items) {
		this.items = items;
	}

}

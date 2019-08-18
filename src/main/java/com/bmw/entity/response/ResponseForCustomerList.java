package com.bmw.entity.response;

import java.util.List;

import com.bmw.entity.CustomerModel;

public class ResponseForCustomerList {
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

	private List<CustomerModel> items;
	
	public List<CustomerModel> getItems() {
		return items;
	}

	public void setItems(List<CustomerModel> items) {
		this.items = items;
	}


}

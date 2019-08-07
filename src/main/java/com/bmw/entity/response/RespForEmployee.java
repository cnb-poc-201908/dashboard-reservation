package com.bmw.entity.response;

import java.util.List;

import javax.validation.constraints.NotNull;

import com.bmw.entity.EmployeeModel;

import io.swagger.annotations.ApiModelProperty;

public class RespForEmployee {
	@ApiModelProperty(notes = "返回码", example = "200", required = true, dataType = "java.lang.Integer")
	@NotNull
	private Integer code;

	@ApiModelProperty(notes = "返回信息", example = "成功", required = true, dataType = "java.lang.String")
	@NotNull
	private String message;

	@ApiModelProperty(notes = "返回employee数据", required = true, dataType = "java.lang.Object")
	private List<EmployeeModel> data;
	
	@ApiModelProperty(notes = "返回employee group数据", required = true, dataType = "java.lang.Object")
	private List<Object> employGroupData;

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public List<Object> getEmployGroupData() {
		return employGroupData;
	}

	public void setEmployGroupData(List<Object> employGroupData) {
		this.employGroupData = employGroupData;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<EmployeeModel> getData() {
		return data;
	}

	public void setData(List<EmployeeModel> data) {
		this.data = data;
	}

	public RespForEmployee(@NotNull Integer code, @NotNull String message, List<EmployeeModel> data,
			List<Object> employGroupData) {
		super();
		this.code = code;
		this.message = message;
		this.data = data;
		this.employGroupData = employGroupData;
	}

	public RespForEmployee() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	
}

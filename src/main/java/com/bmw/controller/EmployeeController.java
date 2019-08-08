package com.bmw.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.bmw.entity.EmployeeModel;
import com.bmw.entity.response.RespForEmployee;
import com.bmw.service.EmployeeServiceImpl;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;



@RestController
@Api(description = "Employee Controller")
public class EmployeeController {
	
	@Autowired
	private EmployeeServiceImpl employeeapp;
	
	
	private static Logger logger = LoggerFactory.getLogger(EmployeeController.class);
	/*
	@RequestMapping(value = "/employee", method = RequestMethod.GET, produces = "application/json")
	@ApiOperation(value = "全部技师列表查询")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "查询成功"), @ApiResponse(code = 400, message = "错误的请求"),
			@ApiResponse(code = 401, message = "没有权限查看此资源"), @ApiResponse(code = 404, message = "资源不存在"),
			@ApiResponse(code = 500, message = "内部错误请联系管理员") })
	public RespForEmployee getAllEmployees() {
		RespForEmployee response = new RespForEmployee();
		Gson gson = new Gson();
		JsonParser parser = new JsonParser();
		JsonObject employeeobject = (JsonObject) parser.parse(employeeapp.EmployeeServiceGetAll());
		JsonArray employarray = employeeobject.get("employees").getAsJsonArray();
		List<EmployeeModel> employlist = JSONObject.parseArray(employarray.toString(), EmployeeModel.class);
		
		response.setCode(200);
		response.setMessage("成功");
		response.setData(employlist);
		
		
		return response;
		
	}
	*/
	
	@RequestMapping(value = "/employeeGlist", method = RequestMethod.GET, produces = "application/json")
	@ApiOperation(value = "全部技师列表查询")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "查询成功"), @ApiResponse(code = 400, message = "错误的请求"),
			@ApiResponse(code = 401, message = "没有权限查看此资源"), @ApiResponse(code = 404, message = "资源不存在"),
			@ApiResponse(code = 500, message = "内部错误请联系管理员") })
	public RespForEmployee getAllEmployeeGroups() {
		RespForEmployee response = new RespForEmployee();
		Gson gson = new Gson();
		JsonParser parser = new JsonParser();
		JsonObject employeeobject = (JsonObject) parser.parse(employeeapp.EmployeeServiceGetAll());
		JsonArray employarray = employeeobject.get("employeegroup").getAsJsonArray();
		List<Object> employlist = JSONObject.parseArray(employarray.toString(), Object.class);
		
		response.setCode(200);
		response.setMessage("成功");
		response.setEmployGroupData(employlist);
		
		return response;
	}

	

}

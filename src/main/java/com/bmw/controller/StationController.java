package com.bmw.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.bmw.entity.StationModel;
import com.bmw.entity.response.RespForStationList;
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
@Api(description = "Station Controller")
public class StationController {

	@Autowired
	private EmployeeServiceImpl employeeapp;
	
	@RequestMapping(value = "/stationlist", method = RequestMethod.GET, produces = "application/json")
	@ApiOperation(value = "全部工位列表查询")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "查询成功"), @ApiResponse(code = 400, message = "错误的请求"),
			@ApiResponse(code = 401, message = "没有权限查看此资源"), @ApiResponse(code = 404, message = "资源不存在"),
			@ApiResponse(code = 500, message = "内部错误请联系管理员") })
	public RespForStationList getAllStations() {
		RespForStationList response = new RespForStationList();
		Gson gson = new Gson();
		JsonParser parser = new JsonParser();
		JsonObject stationobject = (JsonObject) parser.parse(employeeapp.StationGetAll());
		JsonArray stationarray = stationobject.get("stations").getAsJsonArray();
		List<StationModel> stationslist = JSONObject.parseArray(stationarray.toString(), StationModel.class);
		System.out.println(stationslist);
		
		response.setCode(200);
		response.setMessage("成功");
		response.setItems(stationslist);
		
		return response;
	}
}

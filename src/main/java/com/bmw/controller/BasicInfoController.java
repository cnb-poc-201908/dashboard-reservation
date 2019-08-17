package com.bmw.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.bmw.entity.response.RespForObject;
import com.bmw.service.BasicInfoService;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.apache.commons.lang.StringUtils;
import java.lang.reflect.Field;

@RestController
@Api(description = "basic info Controller")
public class BasicInfoController {
	@Autowired
	private BasicInfoService basicapp;
	
	private static Logger logger = LoggerFactory.getLogger(EmployeeController.class);
	
	@RequestMapping(value = "/GetBasicInfolist", method = RequestMethod.GET, produces = "application/json")
	@ApiOperation(value = "全部客户和车辆列表查询")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "查询成功"), @ApiResponse(code = 400, message = "错误的请求"),
			@ApiResponse(code = 401, message = "没有权限查看此资源"), @ApiResponse(code = 404, message = "资源不存在"),
			@ApiResponse(code = 500, message = "内部错误请联系管理员") })
	public RespForObject getAllCustomerList() {
		RespForObject response = new RespForObject();
		Gson gson = new Gson();
		JsonParser parser = new JsonParser();
		JsonObject basicObject = (JsonObject) parser.parse(basicapp.getAllBasicInfoList());
		JsonArray basicArray = basicObject.get("basic_info").getAsJsonArray();
		List<Object> basicList = JSONObject.parseArray(basicArray.toString(), Object.class);
		
		response.setCode(200);
		response.setMessage("成功");
		response.setBasicInfoList(basicList);
		
		return response;
	}
	
	@RequestMapping(value = "/GetBasicInfo/{regid}", method = RequestMethod.GET, produces = "application/json")
	@ApiOperation(value = "指定车辆查询")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "查询成功"), @ApiResponse(code = 400, message = "错误的请求"),
			@ApiResponse(code = 401, message = "没有权限查看此资源"), @ApiResponse(code = 404, message = "资源不存在"),
			@ApiResponse(code = 500, message = "内部错误请联系管理员") })
	public RespForObject getBasicInfoByRegId(@ApiParam("regid") @PathVariable("regid") String regid) {
		RespForObject response = new RespForObject();
		Gson gson = new Gson();
		JsonParser parser = new JsonParser();
		JsonObject basicObject = (JsonObject) parser.parse(basicapp.getAllBasicInfoList());
		JsonArray basicArray = basicObject.get("basic_info").getAsJsonArray();
		List<Object> basicList = JSONObject.parseArray(basicArray.toString(), Object.class);
		List<Object> basicItemList = new ArrayList<>();
		boolean isExist = false;
		if(StringUtils.isNotBlank(regid) ) {
			for(int i=0; i < basicArray.size(); i++) {
				String objItem = basicArray.get(i).toString();
				JSONObject basicObj = JSONObject.parseObject(objItem);
				String vercleItem = basicObj.getString("VEHICLE");
				if(vercleItem.contains(regid)) {
					isExist = true;
					response.setCode(200);
					response.setMessage("成功");
					basicItemList.add(basicObj);
				}
			}
			if(!isExist){
				response.setCode(-1);
			}
			response.setBasicInfoList(basicItemList);
			
		}
		else {
			response.setCode(200);
			response.setMessage("成功");
			response.setBasicInfoList(basicList);
		}
		return response;
	}
	
	@RequestMapping(value = "/GetPackagelist", method = RequestMethod.GET, produces = "application/json")
	@ApiOperation(value = "全部package列表查询")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "查询成功"), @ApiResponse(code = 400, message = "错误的请求"),
			@ApiResponse(code = 401, message = "没有权限查看此资源"), @ApiResponse(code = 404, message = "资源不存在"),
			@ApiResponse(code = 500, message = "内部错误请联系管理员") })
	public RespForObject getAllPackageList() {
		RespForObject response = new RespForObject();
		Gson gson = new Gson();
		JsonParser parser = new JsonParser();
		JsonObject packageObject = (JsonObject) parser.parse(basicapp.getPackageList());
		JsonArray packageArray = packageObject.get("compackage").getAsJsonArray();
		List<Object> packageList = JSONObject.parseArray(packageArray.toString(), Object.class);
		
		response.setCode(200);
		response.setMessage("成功");
		response.setBasicInfoList(packageList);
		
		return response;
	}
	
	@RequestMapping(value = "/GetPaintPackagelist", method = RequestMethod.GET, produces = "application/json")
	@ApiOperation(value = "全部package列表查询")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "查询成功"), @ApiResponse(code = 400, message = "错误的请求"),
			@ApiResponse(code = 401, message = "没有权限查看此资源"), @ApiResponse(code = 404, message = "资源不存在"),
			@ApiResponse(code = 500, message = "内部错误请联系管理员") })
	public RespForObject getAllPaintPackageList() {
		RespForObject response = new RespForObject();
		Gson gson = new Gson();
		JsonParser parser = new JsonParser();
		JsonObject packageObject = (JsonObject) parser.parse(basicapp.getPaintingPackageList());
		JsonArray packageArray = packageObject.get("contents").getAsJsonArray();
		List<Object> packageList = JSONObject.parseArray(packageArray.toString(), Object.class);
		
		response.setCode(200);
		response.setMessage("成功");
		response.setBasicInfoList(packageList);
		
		return response;
	}

}

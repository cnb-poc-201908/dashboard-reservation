package com.bmw.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.bmw.common.BMWPocConstants;
import com.bmw.entity.RepairOrder;
import com.bmw.entity.response.RepairOrderListResponse;
import com.bmw.entity.response.RestResponse;
import com.bmw.utils.DateUtil;

@RestController
@RequestMapping("/repair-orders")
public class RepairOrderController {
	private static Logger logger = LoggerFactory.getLogger(RepairOrderController.class);

	private final ObjectMapper objectMapper = new ObjectMapper();

	@Value("${api.gatewayUri}")
	private String gatewayUri;

	@Value("${api.endpoints.repairOrders}")
	private String endpoint;

	@Autowired
	RestTemplate restTemplate;

//	@Autowired
//	RepairOrderListResponse cachedRepairOrderList;
//
//	@GetMapping(value = "", produces = "application/json")
//	public RestResponse<RepairOrderListResponse> getRepairOrdersByDate(
//			@RequestParam(value = "date", required = false) String date) {
//
//		RestResponse<RepairOrderListResponse> response = new RestResponse<>();
//		response.setData(cachedRepairOrderList);
//    	return response;
//	}
	
	@GetMapping(value = "", produces = "application/json")
	public RestResponse<RepairOrderListResponse> getRepairOrdersByDate(
			@RequestParam(value = "date", required = false) String date) {
		
		List<RepairOrder> orderList = new ArrayList<>();
		RepairOrderListResponse respData = new RepairOrderListResponse();
		RestResponse<RepairOrderListResponse> response = new RestResponse<>();
		respData.setItems(orderList);
		
		try {
			Date d = new Date();
		    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		    System.out.println("格式化输出：" + sdf.format(d));
	    	StringBuilder urlBuilder = new StringBuilder();
	    	urlBuilder.append(gatewayUri)
	    			 .append(BMWPocConstants.API_V1)
	    			 .append(endpoint);
	    	

	    	UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(urlBuilder.toString())
	    	        .queryParam("DueInDateFrom", sdf.format(d));

	    	String result = restTemplate.getForObject(builder.build().toString(), String.class);
	    	RepairOrderListResponse orderResp = objectMapper.readValue(result, RepairOrderListResponse.class);

	    	
	    	for(RepairOrder order : orderResp.getItems()) {
	    		getRepairOrderById(orderList, urlBuilder, order);
	    	}
	    	respData.setTotalPages(1);
	    	respData.setTotalItems(orderList.size());
	    	response.setData(respData);
	    	
		} catch (RestClientResponseException rce) {
			logger.error("failed to get repair order list, id is {}", rce);
		} catch (IOException e) {
			logger.error("failed to parse json object of repair order list, id is {}", e);
		}

    	return response;
	}
	
	private void getRepairOrderById(List<RepairOrder> orderList, StringBuilder urlBuilder, RepairOrder order) {
		String result;
		String repairOrderId = order.getRepairOrderId();
		try {
			urlBuilder.setLength(0);
			urlBuilder.append(gatewayUri)
				.append(BMWPocConstants.API_V2)
				.append(endpoint)
				.append("/")
				.append(repairOrderId);
			result = restTemplate.getForObject(urlBuilder.toString(), String.class);
			RepairOrder repairOrder = objectMapper.readValue(result, RepairOrder.class);
			orderList.add(repairOrder);
		} catch (RestClientResponseException rce) {
			logger.error("failed to get repairOrder, id is {}", repairOrderId);
		} catch (IOException e) {
			logger.error("failed to parse json object of repair order list, id is {}", e);
		}
	}




	@GetMapping(value = "/{repairOrderId}", produces = "application/json")
	public RestResponse<RepairOrder> getRepairOrder(@PathVariable("repairOrderId") String repairOrderId) {

		StringBuilder urlBuilder = new StringBuilder();
		urlBuilder.append(gatewayUri)
			.append(BMWPocConstants.API_V2)
			.append(endpoint)
			.append("/")
			.append(repairOrderId);

		RestResponse<RepairOrder> response = new RestResponse<>();

		try {
			String result = restTemplate.getForObject(urlBuilder.toString(), String.class, repairOrderId);
			RepairOrder repairOrder = objectMapper.readValue(result, RepairOrder.class);
			response.setData(repairOrder);
		} catch (RestClientResponseException rce) {
			response.setCode(BMWPocConstants.REST_ERROR_CODE);
			response.setMessage(rce.getMessage());
			logger.error("failed to get repairOrder, id is {}", repairOrderId, rce);
		} catch (IOException e) {
			response.setCode(BMWPocConstants.REST_ERROR_CODE);
			response.setMessage(e.getMessage());
			logger.error("failed to parse json object of repairOrder, id is {}", repairOrderId, e);
		}
		return response;
	}
}

package com.bmw.controller;

import java.io.IOException;

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

import com.bmw.common.BMWPocConstants;
import com.bmw.entity.RepairOrder;
import com.bmw.entity.response.RepairOrderListResponse;
import com.bmw.entity.response.RestResponse;

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

	@Autowired
	RepairOrderListResponse cachedRepairOrderList;

	@GetMapping(value = "", produces = "application/json")
	public RestResponse<RepairOrderListResponse> getRepairOrdersByDate(
			@RequestParam(value = "date", required = false) String date) {

		RestResponse<RepairOrderListResponse> response = new RestResponse<>();
		response.setData(cachedRepairOrderList);
    	return response;
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

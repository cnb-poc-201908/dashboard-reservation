package com.bmw.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
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

	@GetMapping(value = "", produces = "application/json")
	public RestResponse<RepairOrderListResponse> getRepairOrdersByDate(
			@RequestParam(value = "date", required = false) String date) throws IOException {
		logger.info("date: {}", date);
		RestResponse<RepairOrderListResponse> response = new RestResponse<>();
		File resource = new ClassPathResource("static/data.json", this.getClass().getClassLoader()).getFile();
		FileInputStream fis = new FileInputStream(resource);
		RepairOrderListResponse ordersResp = objectMapper.readValue(fis, RepairOrderListResponse.class);
		fis.close();

		response.setData(ordersResp);
		return response;
	}


	@GetMapping(value = "/{repairOrderId}", produces = "application/json")
	public RestResponse<RepairOrder> getRepairOrder(@PathVariable("repairOrderId") String repairOrderId)
			throws IOException {

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
			response.setCode(-1);
			response.setMessage(rce.getMessage());
			logger.error("failed to get repairOrder, id is {}", repairOrderId);
		}

		return response;
	}
}

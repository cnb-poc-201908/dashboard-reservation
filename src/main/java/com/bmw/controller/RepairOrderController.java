package com.bmw.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bmw.entity.RepairOrder;
import com.bmw.entity.RestResponse;

@RestController
@RequestMapping("/repair-orders")
public class RepairOrderController {
	private static Logger logger = LoggerFactory.getLogger(RepairOrderController.class);
	
    @GetMapping(value = "/{date}", produces = "application/json")
    public RestResponse<RepairOrder> getRepairOrdersByDate(
    		@PathVariable("date") String date){
    	
    	logger.info("getRepairOrdersByDate date:{}", date);
    	RestResponse<RepairOrder> response = new RestResponse<>();
    	response.setCode("0");
    	response.setMessage("success");
    	RepairOrder order = new RepairOrder();
    	order.setId("1111");
    	response.setData(order);
    	return response;
    }
}

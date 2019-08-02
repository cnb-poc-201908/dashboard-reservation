package com.bmw.entity.response;
import java.util.List;

import com.bmw.entity.RepairOrder;

public class RepairOrderListResponse {

	private Integer totalItems;
	private Integer totalPages;
	private List<RepairOrder> repairOrders;

    public Integer getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(Integer totalItems) {
        this.totalItems = totalItems;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public List<RepairOrder> getRepairOrders() {
        return repairOrders;
    }

    public void setRepairOrders(List<RepairOrder> repairOrders) {
        this.repairOrders = repairOrders;
    }
	
	

}
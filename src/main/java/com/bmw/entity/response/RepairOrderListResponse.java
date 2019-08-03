package com.bmw.entity.response;
import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import com.bmw.entity.RepairOrder;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RepairOrderListResponse {

	private Integer totalItems;
	private Integer totalPages;
	private List<RepairOrder> items;

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

	public List<RepairOrder> getItems() {
		return items;
	}

	public void setItems(List<RepairOrder> items) {
		this.items = items;
	}



}
package com.bmw.entity;

public class StationModel {
	private String stationid;
	private String type;
	private String status;
	private String techid;
	public String getStationid() {
		return stationid;
	}
	public void setStationid(String stationid) {
		this.stationid = stationid;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getTechid() {
		return techid;
	}
	public void setTechid(String techid) {
		this.techid = techid;
	}
	public StationModel(String stationid, String type, String status, String techid) {
		super();
		this.stationid = stationid;
		this.type = type;
		this.status = status;
		this.techid = techid;
	}
	public StationModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}

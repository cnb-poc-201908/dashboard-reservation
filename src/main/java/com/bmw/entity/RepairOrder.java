package com.bmw.entity;

import java.util.List;
import java.util.Map;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

import com.bmw.common.BMWPocConstants;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RepairOrder {
	private String repairOrderId;
	private String status;
	private String notes;
	private String checkInDateTime;
	private String checkOutDateTime;
	private Integer checkInMileage;
	private Integer checkOutMileage;
	private String onHoldReason;
	private String vehicleId;
	private String vehicleClass;
	private String vehicleDescription;
	private String vehicleVin;
	private String vehiclelicensePlate;
	private String vehicleEngineNumber;
	private Integer vehicleMileage;
	private String customerId;
	private String companyId;
	private String contactName;
	private String contactPhone;
	private String assignedAdvisorId;
	private String assignedAdvisorName;
	private String contactAdvisorId;
	private String contactAdvisorName;
	private String appointmentNotes;
	private String bookingType;
	private String dueInDateTime;
	private String dueOutDateTime;
	private String plannedIn;
	private String plannedOut;
	private List<RepairOrderJob> jobs;


	@JsonProperty("vehicle")
	private void unpackVehicle(Map<String,Object> vehicle) {
		this.vehicleId = (String)vehicle.get("vehicleId");
		this.vehicleClass = (String)vehicle.get("class");
		this.vehicleDescription = (String)vehicle.get("description");

		Map<String,String> vIdentification = (Map<String,String>)vehicle.get("identification");
		this.vehicleVin = vIdentification.get("vin");
		this.vehiclelicensePlate = vIdentification.get("licensePlate");
		this.vehicleEngineNumber = vIdentification.get("engineNumber");

		Map<String,Object> mileage = (Map<String,Object>)vehicle.get("mileage");
		this.vehicleMileage = (Integer)mileage.get(BMWPocConstants.KEY_NAME_VALUE);
	}

	@JsonProperty("details")
	private void unpackDetails(Map<String,Object> details) {
		this.notes = (String)details.get("notes");
		this.checkInDateTime = (String)details.get("checkInDateTime");
		this.checkOutDateTime = (String)details.get("checkOutDateTime");
		this.onHoldReason = (String)details.get("onHoldReason");
		Map<String,Object> checkinMap = (Map<String,Object>)details.get("checkInMileage");
		Map<String,Object> checkoutMap = (Map<String,Object>)details.get("checkOutMileage");
		this.checkInMileage = (Integer)checkinMap.get(BMWPocConstants.KEY_NAME_VALUE);
		this.checkOutMileage = (Integer)checkoutMap.get(BMWPocConstants.KEY_NAME_VALUE);
	}

	@JsonProperty("customer")
	private void unpackCustomer(Map<String,Object> customer) {
		this.customerId = (String)customer.get("customerId");
	}

	@JsonProperty("company")
	private void unpackCompany(Map<String,Object> company) {
		this.companyId = (String)company.get("companyId");
	}

	@JsonProperty("contact")
	private void unpackContact(Map<String,Object> contact) {
		this.contactName = (String)contact.get("name");
		this.contactPhone = (String)contact.get("phone");
	}

	@JsonProperty("resources")
	private void unpackResources(Map<String,Object> resources) {
		Map<String,Object> assignedAdvisor = (Map<String,Object>)resources.get("assignedAdvisor");
		this.assignedAdvisorId = (String)assignedAdvisor.get("serviceAdvisorId");
		this.assignedAdvisorName = (String)assignedAdvisor.get("name");

		Map<String,Object> contactAdvisor = (Map<String,Object>)resources.get("contactAdvisor");
		this.contactAdvisorId = (String)contactAdvisor.get("serviceAdvisorId");
		this.contactAdvisorName = (String)contactAdvisor.get("name");
	}

	@JsonProperty("appointment")
	private void unpackAppointment(Map<String,Object> appointment) {
		this.appointmentNotes = (String)appointment.get("notes");
		this.dueInDateTime = (String)appointment.get("dueInDateTime");
		this.dueOutDateTime = (String)appointment.get("dueOutDateTime");

		Map<String,Object> options = (Map<String,Object>)appointment.get("bookingOptions");
		this.bookingType = (String)options.get("type");
	}

	@JsonProperty("planning")
	private void unpackPlanning(Map<String,Object> planning) {
		this.plannedIn = (String)planning.get("plannedIn");
		this.plannedOut = (String)planning.get("plannedOut");

	}




	public String getRepairOrderId() {
		return repairOrderId;
	}

	public void setRepairOrderId(String repairOrderId) {
		this.repairOrderId = repairOrderId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getCheckInDateTime() {
		return checkInDateTime;
	}

	public void setCheckInDateTime(String checkInDateTime) {
		this.checkInDateTime = checkInDateTime;
	}

	public String getCheckOutDateTime() {
		return checkOutDateTime;
	}

	public void setCheckOutDateTime(String checkOutDateTime) {
		this.checkOutDateTime = checkOutDateTime;
	}

	public Integer getCheckInMileage() {
		return checkInMileage;
	}

	public void setCheckInMileage(Integer checkInMileage) {
		this.checkInMileage = checkInMileage;
	}

	public Integer getCheckOutMileage() {
		return checkOutMileage;
	}

	public void setCheckOutMileage(Integer checkOutMileage) {
		this.checkOutMileage = checkOutMileage;
	}

	public String getOnHoldReason() {
		return onHoldReason;
	}

	public void setOnHoldReason(String onHoldReason) {
		this.onHoldReason = onHoldReason;
	}

	public String getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(String vehicleId) {
		this.vehicleId = vehicleId;
	}

	public String getVehicleClass() {
		return vehicleClass;
	}

	public void setVehicleClass(String vehicleClass) {
		this.vehicleClass = vehicleClass;
	}

	public String getVehicleDescription() {
		return vehicleDescription;
	}

	public void setVehicleDescription(String vehicleDescription) {
		this.vehicleDescription = vehicleDescription;
	}

	public String getVehicleVin() {
		return vehicleVin;
	}

	public void setVehicleVin(String vehicleVin) {
		this.vehicleVin = vehicleVin;
	}

	public String getVehiclelicensePlate() {
		return vehiclelicensePlate;
	}

	public void setVehiclelicensePlate(String vehiclelicensePlate) {
		this.vehiclelicensePlate = vehiclelicensePlate;
	}

	public String getVehicleEngineNumber() {
		return vehicleEngineNumber;
	}

	public void setVehicleEngineNumber(String vehicleEngineNumber) {
		this.vehicleEngineNumber = vehicleEngineNumber;
	}

	public Integer getVehicleMileage() {
		return vehicleMileage;
	}

	public void setVehicleMileage(Integer vehicleMileage) {
		this.vehicleMileage = vehicleMileage;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getContactPhone() {
		return contactPhone;
	}

	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}

	public String getAssignedAdvisorId() {
		return assignedAdvisorId;
	}

	public void setAssignedAdvisorId(String assignedAdvisorId) {
		this.assignedAdvisorId = assignedAdvisorId;
	}

	public String getAssignedAdvisorName() {
		return assignedAdvisorName;
	}

	public void setAssignedAdvisorName(String assignedAdvisorName) {
		this.assignedAdvisorName = assignedAdvisorName;
	}

	public String getContactAdvisorId() {
		return contactAdvisorId;
	}

	public void setContactAdvisorId(String contactAdvisorId) {
		this.contactAdvisorId = contactAdvisorId;
	}

	public String getContactAdvisorName() {
		return contactAdvisorName;
	}

	public void setContactAdvisorName(String contactAdvisorName) {
		this.contactAdvisorName = contactAdvisorName;
	}

	public String getAppointmentNotes() {
		return appointmentNotes;
	}

	public void setAppointmentNotes(String appointmentNotes) {
		this.appointmentNotes = appointmentNotes;
	}

	public String getBookingType() {
		return bookingType;
	}

	public void setBookingType(String bookingType) {
		this.bookingType = bookingType;
	}

	public String getDueInDateTime() {
		return dueInDateTime;
	}

	public void setDueInDateTime(String dueInDateTime) {
		this.dueInDateTime = dueInDateTime;
	}

	public String getDueOutDateTime() {
		return dueOutDateTime;
	}

	public void setDueOutDateTime(String dueOutDateTime) {
		this.dueOutDateTime = dueOutDateTime;
	}

	public String getPlannedIn() {
		return plannedIn;
	}

	public void setPlannedIn(String plannedIn) {
		this.plannedIn = plannedIn;
	}

	public String getPlannedOut() {
		return plannedOut;
	}

	public void setPlannedOut(String plannedOut) {
		this.plannedOut = plannedOut;
	}

	public List<RepairOrderJob> getJobs() {
		return jobs;
	}

	public void setJobs(List<RepairOrderJob> jobs) {
		this.jobs = jobs;
	}



}

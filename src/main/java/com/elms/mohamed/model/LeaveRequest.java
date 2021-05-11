package com.elms.mohamed.model;

import java.time.DateTimeException;
import java.time.LocalDate;

public class LeaveRequest {
	LocalDate today = LocalDate.now();
	private int leaveId =0;
	private String name;
	private int id;
	private LocalDate fromDate;
	private LocalDate toDate;
	private String reason;
	private String status = "Waiting for approval";
	public String getName() {
		return name;
	}
	public void setName(String name) {
		if(name==null || name.trim().isEmpty()) {
			throw new IllegalArgumentException("Name cannot be empty or null");
		}
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		if(id<999||id>9999) {
			throw new IllegalArgumentException("Employee Id must be a 4-digit Positive number");
		}
		this.id = id;
	}
	public LocalDate getFromDate() {
		return fromDate;
	}
	public void setFromDate(LocalDate fromDate) {
		if(fromDate.isBefore(today)) {
			throw new DateTimeException("Date cannot be past date");
		}
		this.fromDate = fromDate;
	}
	public LocalDate getToDate() {
		return toDate;
	}
	public void setToDate(LocalDate toDate) {
		if(toDate.isBefore(today)) {
			throw new DateTimeException("Date cannot be past date");
		}
		this.toDate = toDate;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		if(reason.isEmpty() || reason.replaceAll(" ","").isEmpty()) {
			throw new IllegalArgumentException("Reason cannot be empty");
		}
		this.reason = reason;
	}
	public int getLeaveId() {
		return leaveId;
	}
	public void setLeaveId(int leaveID) {
		if(leaveID<0) {
			throw new IllegalArgumentException("Id cannot be negative");
		}
		this.leaveId = leaveID;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		if(status.isEmpty() || status.replaceAll(" ","").isEmpty()) {
			throw new IllegalArgumentException("Status cannot be empty");
		}
		this.status = status;
	}
	
}

package com.msalazar.data;

import java.util.Date;

public class AppointmentLog {

	private int id;
	private int appointmentId;
	private String userId;
	private Date applogDatetime;
	private int statusId;
		
	public AppointmentLog() {
		
	}

	public AppointmentLog(int id, int appointmentId, String userId, Date applogDatetime, int statusId) {
		super();
		this.id = id;
		this.appointmentId = appointmentId;
		this.userId = userId;
		this.applogDatetime = applogDatetime;
		this.statusId = statusId;
	}
	
	public AppointmentLog(int appointmentId, String userId, int statusId) {
		super();
		this.appointmentId = appointmentId;
		this.userId = userId;
		this.statusId = statusId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(int appointmentId) {
		this.appointmentId = appointmentId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Date getApplogDatetime() {
		return applogDatetime;
	}

	public void setApplogDatetime(Date applogDatetime) {
		this.applogDatetime = applogDatetime;
	}

	public int getStatusId() {
		return statusId;
	}

	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}
		
}

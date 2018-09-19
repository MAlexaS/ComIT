package com.msalazar.data;

import java.util.Date;

public class Appointment {

	private int id;
	private Date date;
	private Person doctor;
	private Patient patient;
	private Type speciality;
	private Type status;
	private int duration;
	
	public Appointment() {
		
	}
	
	public Appointment(int id, Date date, Person doctor, Patient patient, Type speciality, Type status, int duration) {
		this.id = id;
		this.date = date;
		this.doctor = doctor;
		this.patient = patient;
		this.speciality = speciality;
		this.status = status;
		this.duration = duration;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Person getDoctor() {
		return doctor;
	}
	public void setDoctor(Person doctor) {
		this.doctor = doctor;
	}
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	public Type getSpeciality() {
		return speciality;
	}
	public void setSpeciality(Type speciality) {
		this.speciality = speciality;
	}
	public Type getStatus() {
		return status;
	}
	public void setStatus(Type status) {
		this.status = status;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}

	@Override
	public String toString() {
		return "Appointment [id=" + id + ", date=" + date + ", doctor=" + doctor + ", patient=" + patient
				+ ", speciality=" + speciality + ", status=" + status + ", duration=" + duration + "]";
	}
	
	
}

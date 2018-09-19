package com.msalazar.data;

import java.sql.Date;

public class DoctorSchedule {

	int id;
	String day;
	Date timeIni;
	Date timeEnd;
	int duration;
	double price;
	Date dini;
	Date dend;
	Person doctor;
	Type speciality;
	
	
	public DoctorSchedule() {
		// TODO Auto-generated constructor stub
	}

	public DoctorSchedule(int id, String day, Date timeIni, Date timeEnd, int duration, double price, Date dini,
			Date dend, Person doctor, Type speciality) {
		super();
		this.id = id;
		this.day = day;
		this.timeIni = timeIni;
		this.timeEnd = timeEnd;
		this.duration = duration;
		this.price = price;
		this.dini = dini;
		this.dend = dend;
		this.doctor = doctor;
		this.speciality = speciality;
	}

	/* getters and setters */
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getDay() {
		return day;
	}


	public void setDay(String day) {
		this.day = day;
	}


	public Date getTimeIni() {
		return timeIni;
	}


	public void setTimeIni(Date timeIni) {
		this.timeIni = timeIni;
	}


	public Date getTimeEnd() {
		return timeEnd;
	}


	public void setTimeEnd(Date timeEnd) {
		this.timeEnd = timeEnd;
	}


	public int getDuration() {
		return duration;
	}


	public void setDuration(int duration) {
		this.duration = duration;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public Date getDini() {
		return dini;
	}


	public void setDini(Date dini) {
		this.dini = dini;
	}


	public Date getDend() {
		return dend;
	}


	public void setDend(Date dend) {
		this.dend = dend;
	}


	public Person getDoctor() {
		return doctor;
	}


	public void setDoctor(Person doctor) {
		this.doctor = doctor;
	}


	public Type getSpeciality() {
		return speciality;
	}


	public void setSpeciality(Type speciality) {
		this.speciality = speciality;
	}

	@Override
	public String toString() {
		return "DoctorSchedule [id=" + id + ", day=" + day + ", timeIni=" + timeIni + ", timeEnd=" + timeEnd
				+ ", duration=" + duration + ", price=" + price + ", dini=" + dini + ", dend=" + dend + ", doctor="
				+ doctor + ", speciality=" + speciality + "]";
	}
	
	

}

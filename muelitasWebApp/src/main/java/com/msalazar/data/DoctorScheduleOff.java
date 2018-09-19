package com.msalazar.data;
import java.sql.Date;

/**
 * 
 */

/**
 * @author msalazar

 *
 */
public class DoctorScheduleOff {

	/**
	 * 
	 */
	Date id;
	Date begin;
	Date end;
	int allday;
	Person doctor;
	
	
	public DoctorScheduleOff() {
		// TODO Auto-generated constructor stub
		
	}

	public DoctorScheduleOff(Date id, Date begin, Date end, int allday, Person doctor) {
		super();
		this.id = id;
		this.begin = begin;
		this.end = end;
		this.allday = allday;
		this.doctor = doctor;
	}


	/* getters and setters */

	public Date getId() {
		return id;
	}


	public void setId(Date id) {
		this.id = id;
	}


	public Date getBegin() {
		return begin;
	}


	public void setBegin(Date begin) {
		this.begin = begin;
	}


	public Date getEnd() {
		return end;
	}


	public void setEnd(Date end) {
		this.end = end;
	}


	public int getAllday() {
		return allday;
	}


	public void setAllday(int allday) {
		this.allday = allday;
	}


	public Person getDoctor() {
		return doctor;
	}


	public void setDoctor(Person doctor) {
		this.doctor = doctor;
	}

	@Override
	public String toString() {
		return "DoctorScheduleOff [id=" + id + ", begin=" + begin + ", end=" + end + ", allday=" + allday + ", doctor="
				+ doctor + "]";
	}
	
	

}

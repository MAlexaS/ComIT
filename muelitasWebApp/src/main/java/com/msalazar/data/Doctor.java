package com.msalazar.data;
import java.util.Date;
import java.util.List;


public class Doctor extends Person {

	private int id;
	private User user;
	private List<Type> specialities;
	private List<DoctorSchedule> schedule;
	private List<DoctorScheduleOff> scheduleOff;
	
	/* constructors */
	
	public Doctor(){
		super();
	}
	
	
	
	public Doctor(int id, String name, String lastName, String address, String zipcode, Date bornDate, String phone,
			String cellphone, String email, Type personType, User user) {
		super(id, name, lastName, address, zipcode, bornDate, phone, cellphone, email, personType);
		this.user=user;
		// TODO Auto-generated constructor stub
	}


	public Doctor(int id, List<Type> specialities, List<DoctorSchedule> schedule, List<DoctorScheduleOff> scheduleOff) {
		super();
		this.id = id;
		this.specialities = specialities;
		this.schedule = schedule;
		this.scheduleOff = scheduleOff;
	}
	
	public Doctor(int id) {
		super();
		this.id = id;
		this.specialities = null;
		this.schedule = null;
		this.scheduleOff = null;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Type> getSpecialities() {
		return specialities;
	}

	public void setSpecialities(List<Type> specialities) {
		this.specialities = specialities;
	}
	

	public User getUser() {
		return user;
	}



	public void setUser(User user) {
		this.user = user;
	}



	public List<DoctorSchedule> getSchedule() {
		return schedule;
	}

	public void setSchedule(List<DoctorSchedule> schedule) {
		this.schedule = schedule;
	}

	public List<DoctorScheduleOff> getScheduleOff() {
		return scheduleOff;
	}

	public void setScheduleOff(List<DoctorScheduleOff> scheduleOff) {
		this.scheduleOff = scheduleOff;
	}



	@Override
	public String toString() {
		return "Doctor [id=" + id + ", user=" + user + ", specialities=" + specialities + ", schedule=" + schedule
				+ ", scheduleOff=" + scheduleOff + "]";
	}
	
	

}

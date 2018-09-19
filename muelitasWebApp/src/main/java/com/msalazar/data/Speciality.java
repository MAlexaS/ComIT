package com.msalazar.data;
import java.util.List;


public class Speciality extends Type {

	private List<Doctor> doctors;

	public Speciality() {
		super();
		this.doctors = null;
	}
	
	public Speciality(Type obj) {
		super(obj.getId(),obj.getDesc(),obj.getParent());
		this.doctors = null;
	}
	
	public Speciality(Type obj,List<Doctor> doctors) {
		super(obj.getId(),obj.getDesc(),obj.getParent());
		this.doctors = doctors;
	}

	public List<Doctor> getDoctors() {
		return doctors;
	}

	public void setDoctors(List<Doctor> doctors) {
		this.doctors = doctors;
	}

	@Override
	public String toString() {
		return "Speciality [doctors=" + doctors + ", id=" + id + ", desc=" + desc + ", parent=" + parent + "]";
	}
	
	

}

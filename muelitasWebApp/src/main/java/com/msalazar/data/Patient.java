package com.msalazar.data;
import java.util.Date;


public class Patient extends Person {

	private int id;
	private String healthNumber;
	private String emergencyContactName;
	private String emergencyContactPhone;
	private Type ocupation;
	
	/* constructors */
	
	public Patient(){
		super();
	}

	public Patient(int id, String name, String lastName, String address, String zipcode, Date bornDate, String phone,
			String cellphone, String email, Type personType,String healthNumber, String emergencyContactName, String emergencyContactPhone,
			Type ocupation) {
		super(id, name, lastName, address, zipcode, bornDate, phone, cellphone, email, personType);
		// TODO Auto-generated constructor stub
		this.id = id;
		this.healthNumber = healthNumber;
		this.emergencyContactName = emergencyContactName;
		this.emergencyContactPhone = emergencyContactPhone;
		this.ocupation = ocupation;
	}

	public int getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getHealthNumber() {
		return healthNumber;
	}

	public void setHealthNumber(String healthNumber) {
		this.healthNumber = healthNumber;
	}

	public String getEmergencyContactName() {
		return emergencyContactName;
	}

	public void setEmergencyContactName(String emergencyContactName) {
		this.emergencyContactName = emergencyContactName;
	}

	public String getEmergencyContactPhone() {
		return emergencyContactPhone;
	}

	public void setEmergencyContactPhone(String emergencyContactPhone) {
		this.emergencyContactPhone = emergencyContactPhone;
	}

	public Type getOcupation() {
		return ocupation;
	}

	public void setOcupation(Type ocupation) {
		this.ocupation = ocupation;
	}

	@Override
	public String toString() {
		return "Patient [id=" + id + ", healthNumber=" + healthNumber + ", emergencyContactName=" + emergencyContactName
				+ ", emergencyContactPhone=" + emergencyContactPhone + ", ocupation=" + ocupation + "]";
	}
	
	

}

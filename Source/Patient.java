
public class Patient extends Person {

	private Integer id;
	private String healthNumber;
	private String emergencyContactName;
	private String emergencyContactPhone;
	private Type ocupation;
	
	public Patient(){
		super();
	}

	public Integer getId() {
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

}

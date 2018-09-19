package com.msalazar.data;
import java.util.Date;

public class Person
{
	private int id;
	
	private String name;
	private String lastName;
	private String address;
	private String zipcode;
	private Date bornDate;
	private String phone;
	private String cellphone;
	private String email;
	private Type personType;
	
	/* constructors */
	
	public Person(){
		
	}
	
	public Person(int id,String name, String lastName, String address, String zipcode, Date bornDate, String phone, String cellphone,String email, Type personType)
	{
		this.id=id;
		this.name=name;
		this.lastName= lastName;
		this.address = address;
		this.zipcode = zipcode;
		this.bornDate = bornDate;
		this.phone = phone;
		this.cellphone = cellphone;
		this.email = email;
		this.personType = personType;
	}
	
	/* getters and setters */

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public Date getBornDate() {
		return bornDate;
	}

	public void setBornDate(Date bornDate) {
		this.bornDate = bornDate;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCellphone() {
		return cellphone;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Type getPersonType() {
		return personType;
	}

	public void setPersonType(Type personType) {
		this.personType = personType;
	}

	public boolean deletePerson(int id){
		//delete person with equal id
		return true;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", lastName=" + lastName + ", address=" + address + ", zipcode="
				+ zipcode + ", bornDate=" + bornDate + ", phone=" + phone + ", cellphone=" + cellphone + ", email="
				+ email + ", personType=" + personType + "]";
	}
	
	
	
}

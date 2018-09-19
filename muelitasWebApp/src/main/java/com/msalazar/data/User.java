package com.msalazar.data;
import java.util.Date;


public class User extends Person {

	private String userName;
	private String password;
	private Type role;
	
	/* constructors */
	
	public User() {
		super();
		this.userName=null;
		this.password=null;
		this.role=null;
	}
	
	
	public User(String userName, String password, Type role){
		super();
		this.userName=userName;
		this.password=password;
		this.role=role;
	}

	public User(int id, String name, String lastName, String address, String zipcode, Date bornDate, String phone,
			String cellphone, String email, Type personType,String userName, String password, Type role) {
		super(id, name, lastName, address, zipcode, bornDate, phone, cellphone, email, personType);
		// TODO Auto-generated constructor stub
		this.userName = userName;
		this.password = password;
		this.role = role;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Type getRole() {
		return role;
	}

	public void setRole(Type role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [userName=" + userName + ", password=" + password + ", role=" + role + "]";
	}

}

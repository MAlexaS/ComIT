package com.msalazar;

import java.util.List;

import com.msalazar.data.Type;
import com.msalazar.data.User;
import com.msalazar.exceptions.MuelitasException;
import com.msalazar.persistence.TypePersistence;
import com.msalazar.persistence.UserPersistence;

public class AdminService {
	
	public List<User> getAll() throws MuelitasException{
		UserPersistence userPer = new UserPersistence();
		try {
			return userPer.getAll();
		} catch (MuelitasException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public User getUser(int id) throws MuelitasException{
		UserPersistence userPer = new UserPersistence();
		try {
			return userPer.getById(id);
		} catch (MuelitasException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean updateUser(int id,String password) throws MuelitasException{
		UserPersistence userPer = new UserPersistence();
		return userPer.updatePassword(id, password);
	}
	
	public User deleteUser(int id) throws MuelitasException{
		UserPersistence userPer = new UserPersistence();
		User u = new User();
		u = userPer.getById(id);
		userPer.delete(u);
		return u;
	}
	
	public User insertUser(User u) throws MuelitasException{
		UserPersistence userPer = new UserPersistence();
		u = userPer.insert(u);
		return u;
	}
	
	public User insertUser(String name,String lastName, String username,String roleUser, String password) throws MuelitasException{
		TypePersistence roPer = new TypePersistence();
		
		User u = new User(0, name, lastName, "", "", null, "", "", "", null, username, password, roPer.getById(Integer.parseInt(roleUser)));
		UserPersistence userPer = new UserPersistence();
		u = userPer.insert(u);
		return u;
	}
	
	public User isUserValid(String username, String password) {
		UserPersistence userP = new UserPersistence();
		User obj = null;
		
		System.out.println("username:" + username);
		
		try {
			obj=userP.getByUsernamePassword(username, password);
			if(username.equals(obj.getUserName()))  {
				
				return obj;
			} else {
				return null;
			}
			
		} catch (MuelitasException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}

package com.msalazar;

import com.msalazar.data.User;
import com.msalazar.exceptions.MuelitasException;
import com.msalazar.persistence.UserPersistence;

public class UserValidationService {
	
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

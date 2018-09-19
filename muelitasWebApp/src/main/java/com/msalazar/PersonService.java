package com.msalazar;

import java.util.List;

import com.msalazar.data.Person;
import com.msalazar.data.User;
import com.msalazar.exceptions.MuelitasException;
import com.msalazar.persistence.PersonPersistence;
import com.msalazar.persistence.UserPersistence;

public class PersonService {
	
	public List<Person> getAll() throws MuelitasException{
		PersonPersistence perPer = new PersonPersistence();
		try {
			return perPer.getAll();
		} catch (MuelitasException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public Person getPerson(int id) throws MuelitasException{
		PersonPersistence perPer = new PersonPersistence();
		try {
			return perPer.getById(id);
		} catch (MuelitasException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean updatePerson(Person p) throws MuelitasException{
		PersonPersistence perPer = new PersonPersistence();
		perPer.update(p);
		return true;
	}
	
	public boolean updatePerson(int id) throws MuelitasException{
		PersonPersistence perPer = new PersonPersistence();
		Person per = perPer.getById(id);
		perPer.update(per);
		return true;
	}
	
	public Person deletePerson(int id) throws MuelitasException{
		PersonPersistence perPer = new PersonPersistence();
		Person p = new Person();
		p = perPer.getById(id);
		perPer.delete(p);
		return p;
	}
	
	public Person insertPerson(Person u) throws MuelitasException{
		PersonPersistence perPer = new PersonPersistence();
		u = perPer.insert(u);
		return u;
	}

}

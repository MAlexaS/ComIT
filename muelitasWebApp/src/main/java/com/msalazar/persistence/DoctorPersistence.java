package com.msalazar.persistence;

import com.msalazar.common.ConnectionDB;
import com.msalazar.data.Doctor;
import com.msalazar.data.Patient;
import com.msalazar.data.Person;
import com.msalazar.data.Type;
import com.msalazar.data.User;
import com.msalazar.exceptions.MuelitasException;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


/***
 * 
 * @author msalazar
 *
 */
public class DoctorPersistence {
    //implement
	public Patient insert(Patient patient) throws MuelitasException {
        Connection conn = null;
                
        Person auxPerson = new Person(0, patient.getName(), patient.getLastName(), patient.getAddress(), patient.getZipcode(), patient.getBornDate(), patient.getPhone(), patient.getCellphone(), patient.getEmail(), patient.getPersonType());
        
        
        try {
            conn = ConnectionDB.connectDB();
            
            // 1: insert into person and get the person Id
            PersonPersistence personPersistence = new PersonPersistence();
            auxPerson = personPersistence.insert(auxPerson);    
            // 2: insert into patient
            
            String sql = "insert into patient (patient_id,patient_healthNumber,patient_emergencyContactName,patient_emergencyContactPhone,ocupation_id) values (?,?,?,?,?)";
            
            PreparedStatement ps = conn.prepareStatement(sql);
            
            ps.setInt(1, auxPerson.getId());
            ps.setString(2, patient.getHealthNumber());
            ps.setString(3, patient.getEmergencyContactName());
            ps.setString(4, patient.getEmergencyContactPhone());
            ps.setInt(5, patient.getOcupation().getId());
            
            
            if (ps.executeUpdate() ==0) {
                throw new MuelitasException("Failed to insert Patient");
            }
            
            return patient;
            

        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new MuelitasException("Error.  Patient's insert action failed");
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            return patient;
        }
    }
    
	//implement
    public Patient update(Patient patient) throws MuelitasException {
        Connection conn = null;
                
        Person auxPerson = new Person(patient.getId(), patient.getName(), patient.getLastName(), patient.getAddress(), patient.getZipcode(), patient.getBornDate(), patient.getPhone(), patient.getCellphone(), patient.getEmail(), patient.getPersonType());
                
        try {
            conn = ConnectionDB.connectDB();
            
            // 1: insert into person and get the person Id
            PersonPersistence personPersistence = new PersonPersistence();
            personPersistence.update(auxPerson);
            
            String sql = "update patient "
            		+ "set patient_healthNumber=?,patient_emergencyContactName=?,patient_emergencyContactPhone=?,ocupation_id=? "
            		+ "where patient_id=?";
            
            PreparedStatement ps = conn.prepareStatement(sql);
            
            ps.setString(1, patient.getHealthNumber());
            ps.setString(2, patient.getEmergencyContactName());
            ps.setString(3, patient.getEmergencyContactPhone());
            ps.setInt(4, patient.getOcupation().getId());
            ps.setInt(5, patient.getOcupation().getId());
            
            
            if (ps.executeUpdate() ==0) {
                throw new MuelitasException("Failed to update Patient");
            }
            
            return patient;
            

        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new MuelitasException("Error.  Patient's update action failed");
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            return patient;
        }
    }

    //implement
    public void delete(Patient data) throws MuelitasException{
        Connection conn = null;
        try {
            conn = ConnectionDB.connectDB();
            
            String sql = "delete from patient where patient_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, data.getId());
            if (ps.executeUpdate() == 0){
                throw new MuelitasException("Failed to delete Patient");
            }
            
            sql = "delete from person where person_id = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, data.getId());
            if (ps.executeUpdate() == 0){
                throw new MuelitasException("Failed to delete Person");
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new MuelitasException("Error. Person's delete action failed");
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    /***
     * Load person_id to object obj and return true if it exists or false 
     * @param obj
     * @return
     * @throws MuelitasException
     */
    public Boolean exist(Doctor obj) throws MuelitasException{
        Boolean aux = false;
        
        Connection conn= null;

        try {
            conn = ConnectionDB.connectDB();

            String sql = "select p.person_id "
            		+"from person p "
            		+ "inner join user u on (p.person_id=u.patient_id) "
            		+ "where p.person_id=? "
            		+ "and p.persontype_id=2 and u.role_id=13";
            		
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, obj.getId());

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                obj.setId(rs.getInt("person_id"));
                aux = true;
                obj = this.getById(obj.getId());
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new MuelitasException("DoctorPersistence: Problem getting data");
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

        return aux;
    }
    
    public Doctor getById(int id) throws MuelitasException{
        Doctor objDoctor = new Doctor();

        Connection conn= null;

        try {
            conn = ConnectionDB.connectDB();

            String sql = "select p.person_id,p.person_name,p.person_lastname,p.person_address,p.person_zipcode,p.person_borndate,p.person_phone,p.person_cellphone,p.person_email " + 
            		",p.persontype_id,pt.type_desc persontypeDesc,pt.type_parent persontypeParent " + 
            		",u.user_id,u.user_name,u.role_id,ro.type_desc roleDesc,ro.type_parent roleParent " + 
            		"from person p " + 
            		"inner join user u on (p.person_id=u.person_id) " + 
            		"inner join type pt on (p.persontype_id=pt.type_id) " + 
            		"inner join type ro on (p.persontype_id=ro.type_id) " + 
            		"where p.person_id=? ";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
            	
            	objDoctor = new Doctor(rs.getInt("person_id"),rs.getString("person_name"),rs.getString("person_lastname"),rs.getString("person_address"),rs.getString("person_zipcode"),rs.getDate("person_borndate"),rs.getString("person_phone"),rs.getString("person_cellphone"),rs.getString("person_email"),new Type(rs.getInt("persontype_id"),rs.getString("type_desc"),rs.getString("type_parent")), new User(rs.getString("user_id"),rs.getString("user_name"),new Type(rs.getInt("role_id"),rs.getString("roleDesc"),rs.getString("roleParent"))));
                
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new MuelitasException("PersonPersistence: Problem to get data");
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

        return objDoctor;
    }
    
    public List<Doctor>  getAll() throws MuelitasException{
        List<Doctor> rsDoctor = new ArrayList<Doctor>();
        Doctor objAux = null;

        Connection conn= null;

        try {
            conn = ConnectionDB.connectDB();

            String sql = "select p.person_id,p.person_name,p.person_lastname,p.person_address,p.person_zipcode,p.person_borndate,p.person_phone,p.person_cellphone,p.person_email " + 
            		",p.persontype_id,pt.type_desc persontypeDesc,pt.type_parent persontypeParent " + 
            		",u.user_id,u.user_name,u.role_id,ro.type_desc roleDesc,ro.type_parent roleParent " + 
            		"from person p " + 
            		"inner join user u on (p.person_id=u.person_id) " + 
            		"inner join type pt on (p.persontype_id=pt.type_id) " + 
            		"inner join type ro on (p.persontype_id=ro.type_id) " + 
            		"where p.persontype_id=2 and u.role_id=13" +
            		"order by 3,2 ";

            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
            	objAux = new Doctor(rs.getInt("person_id"),rs.getString("person_name"),rs.getString("person_lastname"),rs.getString("person_address"),rs.getString("person_zipcode"),rs.getDate("person_borndate"),rs.getString("person_phone"),rs.getString("person_cellphone"),rs.getString("person_email"),new Type(rs.getInt("persontype_id"),rs.getString("type_desc"),rs.getString("type_parent")), new User(rs.getString("user_id"),rs.getString("user_name"),new Type(rs.getInt("role_id"),rs.getString("roleDesc"),rs.getString("roleParent"))));
            	
                rsDoctor.add(objAux);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new MuelitasException("DoctorPersistence: Problem to get data");
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return rsDoctor;
    }
 	
}

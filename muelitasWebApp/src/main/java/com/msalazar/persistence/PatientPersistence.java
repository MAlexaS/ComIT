package com.msalazar.persistence;

import com.msalazar.common.ConnectionDB;
import com.msalazar.data.Patient;
import com.msalazar.data.Person;
import com.msalazar.data.Type;
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
public class PatientPersistence {
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
    public Boolean exist(Patient obj) throws MuelitasException{
        Boolean aux = false;
        
        Connection conn= null;

        try {
            conn = ConnectionDB.connectDB();

            String sql = "select pa.patient_id "
            		+"from patient pa "
            		+ "inner join person pe on (pe.person_id=pa.patient_id) "
            		+ "where pa.patient_id=? ";
            		
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, obj.getId());

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                obj.setId(rs.getInt("person_id"));
                aux = true;
            }
            
            obj = this.getById(obj.getId());

        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new MuelitasException("PatientPersistence: Problem getting data");
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
    
    public Patient getById(int id) throws MuelitasException{
        Patient objPatient = new Patient();
    	Person objPerson = null;
        TypePersistence personType = new TypePersistence();

        Connection conn= null;

        try {
            conn = ConnectionDB.connectDB();

            String sql = "select pe.person_id,pe.person_name,pe.person_lastname,pe.person_address,pe.person_zipcode,pe.person_borndate,pe.person_phone,pe.person_cellphone,pe.person_email " +
            		",pe.persontype_id,pt.type_desc,pt.type_parent" + 
            		",pa.patient_id,pa.patient_healthNumber,pa.patient_emergencyContactName,pa.patient_emergencyContactPhone " + 
            		",pa.ocupation_id, oc.type_desc octypedesc,oc.type_parent octypeparent " + 
            		"from patient pa " + 
            		"inner join person pe on (pe.person_id=pa.patient_id) " + 
            		"inner join type pt on (pt.type_id=pe.persontype_id) " + 
            		"inner join type oc on (oc.type_id=pa.ocupation_id) " + 
            		"where pa.patient_id=? ";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
            	objPatient = new Patient(rs.getInt("person_id"),rs.getString("person_name"),rs.getString("person_lastname"),rs.getString("person_address"),rs.getString("person_zipcode"),rs.getDate("person_borndate"),rs.getString("person_phone"),rs.getString("person_cellphone"),rs.getString("person_email"),new Type(rs.getInt("persontype_id"),rs.getString("type_desc"),rs.getString("type_parent")),rs.getString("patient_healthnumber"),rs.getString("patient_emergencyContactName"),rs.getString("patient_emergencycontactphone"),new Type(rs.getInt("ocupation_id"),rs.getString("octypedesc"),rs.getString("octypeparent")));
                
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

        return objPatient;
    }
    
    public List<Patient>  getAll() throws MuelitasException{
        List<Patient> rsPatient = new ArrayList<Patient>();
        Patient objAux = null;

        Connection conn= null;

        try {
            conn = ConnectionDB.connectDB();

            String sql = "select pe.person_id,pe.person_name,pe.person_lastname,pe.person_address,pe.person_zipcode,"
            		+ "pe.person_borndate,pe.person_phone,pe.person_cellphone,pe.person_email " + 
            		",pe.persontype_id,pt.type_desc,pt.type_parent" + 
            		",pa.patient_id,pa.patient_healthNumber,pa.patient_emergencyContactName,pa.patient_emergencyContactPhone " + 
            		",pa.ocupation_id, oc.type_desc,oc.type_parent " + 
            		"from patient pa " + 
            		"inner join person pe on (pe.person_id=pa.patient_id) " + 
            		"inner join type pt on (pt.type_id=pe.persontype_id) " + 
            		"inner join type oc on (oc.type_id=pa.ocupation_id) "
            		+"order by 3,2";

            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
            	objAux = new Patient(rs.getInt("person_id"),rs.getString("person_name"),rs.getString("person_lastname"),rs.getString("person_address"),rs.getString("person_zipcode"),rs.getDate("person_borndate"),rs.getString("person_phone"),rs.getString("person_cellphone"),rs.getString("person_email"),new Type(rs.getInt("persontype_id"),rs.getString("type_desc"),rs.getString("type_parent")),rs.getString("patient_healthnumber"),rs.getString("patient_emergencyContactName"),rs.getString("patient_emergencycontactphone"),new Type(rs.getInt("ocupation_id"),rs.getString("octypedesc"),rs.getString("octypeparent")));
            	
                rsPatient.add(objAux);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new MuelitasException("PatientPersitence: Problem to get data");
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return rsPatient;
    }
 	
}

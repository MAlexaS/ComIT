package com.msalazar.persistence;

import com.msalazar.common.ConnectionDB;
import com.msalazar.data.Appointment;
import com.msalazar.data.AppointmentLog;
import com.msalazar.data.Doctor;
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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


/***
 * 
 * @author msalazar
 *
 */
public class AppointmentPersistence {
    private int duration=15;
    private AppointmentLogPersistence log;
	
	public Appointment insert(Appointment appointment,String userId) throws MuelitasException {
        Connection conn = null;
        AppointmentLog appLog= new AppointmentLog();
                
        Appointment auxAppointment = new Appointment(0, appointment.getDate(), appointment.getDoctor(), appointment.getPatient(), appointment.getSpeciality(), appointment.getStatus(), appointment.getDuration());
        
        try {
            conn = ConnectionDB.connectDB();
            
            //validate appointment
            
            // insert into appointment
            
            String sql = "insert into appointment (appointment_date,doctor_id,patient_id,speciality_id,status_id,appointment_duration) values (str_to_date(?,'%Y-%m-%d %H%i'),?,?,?,?,?)";
            
            PreparedStatement ps = conn.prepareStatement(sql);
            
            //ps.setDate(1, new SimpleDateFormat("yyyy-MM-dd HHmm").parse(auxAppointment.getDate()));
            ps.setDate(1, new java.sql.Date(auxAppointment.getDate().getTime()));
            ps.setInt(2, auxAppointment.getDoctor().getId());
            ps.setInt(3, auxAppointment.getPatient().getId());
            ps.setInt(4, auxAppointment.getSpeciality().getId());
            ps.setInt(5, auxAppointment.getStatus().getId());
            ps.setInt(6, duration);
            
            if(this.exist(appointment)) {
            	appLog = this.log.insert(new AppointmentLog(appointment.getId(),userId,appointment.getStatus().getId()));
            }
            
            if (ps.executeUpdate() ==0) {
                throw new MuelitasException("Failed to insert AppointmentLog -> "+auxAppointment.toString());
            }
            
            return appointment;
            

        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new MuelitasException("Error.  Appointment Log's insert action failed");
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            return appointment;
        }
    }
	
    /***
     * Load person_id to object obj and return true if it exists or false 
     * @param obj
     * @return
     * @throws MuelitasException
     */
    public Boolean exist(Appointment obj) throws MuelitasException{
        Boolean aux = false;
        
        Connection conn= null;

        try {
            conn = ConnectionDB.connectDB();

            String sql = "select a.appointment_id " + 
            		"from appointment a " + 
            		"where date_format(a.appointment_date,'%Y-%m-%d %H:%i')=?  and a.doctor_id=? and a.patient_id=? ";
            		
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setDate(1, new java.sql.Date(obj.getDate().getTime()));
            ps.setInt(2, obj.getDoctor().getId());
            ps.setInt(3, obj.getPatient().getId());

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                obj.setId(rs.getInt("appointment_id"));
                aux = true;
            }
            
            obj = this.getById(obj.getId());

        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new MuelitasException("AppointmentPersistence: Problem getting data. " + obj.toString());
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

    public void delete(Appointment data) throws MuelitasException{
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
    

    
    public Appointment getById(int id) throws MuelitasException{
        
        Appointment objApp = new Appointment();
        Doctor auxDoc = new Doctor();
        Patient auxPatient = new Patient();
        DoctorPersistence objDoctor = new DoctorPersistence();
        PatientPersistence objPatient = new PatientPersistence();
        TypePersistence objType = new TypePersistence();
        

        Connection conn= null;

        try {
            conn = ConnectionDB.connectDB();

            String sql = "select a.appointment_id,a.appointment_date,a.doctor_id,a.patient_id,a.appointment_duration" + 
            		",a.speciality_id,sp.type_desc speciality_desc,sp.type_parent speciality_parent " + 
            		",a.status_id,st.type_desc status_desc,st.type_parent status_parent " + 
            		"from appointment a " + 
            		"inner join type sp on (sp.type_id=a.speciality_id) " + 
            		"inner join type st on (st.type_id=a.status_id) " + 
            		"where a.appointment_id= ? ";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
            	
            	objApp = new Appointment(rs.getInt("appointment_id"), rs.getDate("appointment_date"), objDoctor.getById(rs.getInt("doctor_id")), objPatient.getById(rs.getInt("patient_id")), objType.getById(rs.getInt("speciality_id")), objType.getById(rs.getInt("status_id")),duration);
            	    
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

        return objApp;
    }
    
    public List<Appointment>  getAll() throws MuelitasException{
        List<Appointment> rsAppointment = new ArrayList<Appointment>();
        Appointment objAux = null;

        Connection conn= null;

        try {
            conn = ConnectionDB.connectDB();

            String sql = "select a.appointment_id,a.appointment_date " + 
            		"from appointment a " + 
            		"where a.appointment_date >= date_add(now(),interval -1 MONTH) " + 
            		"order by 2";

            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
            	objAux= this.getById(rs.getInt("appointment_id"));
                rsAppointment.add(objAux);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new MuelitasException("AppointmentPersistence: Problem to get data." + objAux.toString());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return rsAppointment;
    }
 	
}

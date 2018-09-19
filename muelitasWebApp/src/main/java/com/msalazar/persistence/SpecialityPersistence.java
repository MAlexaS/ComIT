package com.msalazar.persistence;

import com.msalazar.common.ConnectionDB;
import com.msalazar.data.Appointment;
import com.msalazar.data.AppointmentLog;
import com.msalazar.data.Doctor;
import com.msalazar.data.Patient;
import com.msalazar.data.Person;
import com.msalazar.data.Speciality;
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
public class SpecialityPersistence {
	
        
    public Speciality getById(int id) throws MuelitasException{
        TypePersistence objSpecPer = new TypePersistence();
        
        DoctorPersistence objDocPer = new DoctorPersistence();
        List <Doctor> doctors=new ArrayList<Doctor>();
        Doctor objAux = new Doctor();
        
        Speciality spec = new Speciality(objSpecPer.getById(id));
        
        Connection conn= null;

        try {
            conn = ConnectionDB.connectDB();

            String sql = "select distinct sp.type_id,sp.type_desc,sp.type_parent,ds.doctor_id,concat(p.person_lastname,' ',p.person_name) doc " + 
            		"from type sp " + 
            		"inner join doctor_schedule ds on (sp.type_id=ds.speciality_id) " + 
            		"inner join person p on (p.person_id=ds.doctor_id)" + 
            		"where sp.type_parent='SP' " + 
            		"and now() between ds.docsche_dini and ifnull(ds.docsche_dend,str_to_date('2099-12-31','%Y-%m-%d')) " + 
            		"and ds.speciality_id=? " + 
            		"order by 2,5";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
            	objAux=objDocPer.getById(rs.getInt("doctor_id"));
            	doctors.add(objAux);            	    
            }
            spec.setDoctors(doctors);
            return spec;

        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new MuelitasException("SpecialityPersistence: Problem to get data");
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            return null;
        }
    }
    
    public Speciality getByIdDate(int id,Date date) throws MuelitasException{
        TypePersistence objSpecPer = new TypePersistence();
        
        DoctorPersistence objDocPer = new DoctorPersistence();
        List <Doctor> doctors=new ArrayList<Doctor>();
        Doctor objAux = new Doctor();
        
        Speciality spec = new Speciality(objSpecPer.getById(id));
        
        Connection conn= null;

        try {
            conn = ConnectionDB.connectDB();

            String sql = "select distinct sp.type_id,sp.type_desc,sp.type_parent,ds.doctor_id,concat(p.person_lastname,' ',p.person_name) doc " + 
            		"from type sp " + 
            		"inner join doctor_schedule ds on (sp.type_id=ds.speciality_id) " + 
            		"inner join person p on (p.person_id=ds.doctor_id)" + 
            		"where sp.type_parent='SP' " + 
            		"and now() between ds.docsche_dini and ifnull(ds.docsche_dend,str_to_date('2099-12-31','%Y-%m-%d')) " + 
            		"and ds.speciality_id=? " + 
            		"order by 2,5";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
            	objAux=objDocPer.getById(rs.getInt("doctor_id"));
            	doctors.add(objAux);            	    
            }
            spec.setDoctors(doctors);
            return spec;

        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new MuelitasException("SpecialityPersistence: Problem to get data");
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            return null;
        }
    }
    
    public List<Speciality> getAll() throws MuelitasException{
        TypePersistence objSpecPer = new TypePersistence();
        Speciality spec = null;
        List<Speciality> listSpec=new ArrayList<Speciality>();
        
        Connection conn= null;

        try {
            conn = ConnectionDB.connectDB();

            String sql = "select distinct sp.type_id,sp.type_desc,sp.type_parent " + 
            		"from type sp " + 
            		"inner join doctor_schedule ds on (sp.type_id=ds.speciality_id) " + 
            		"inner join person p on (p.person_id=ds.doctor_id)" + 
            		"where sp.type_parent='SP' " + 
            		"and now() between ds.docsche_dini and ifnull(ds.docsche_dend,str_to_date('2099-12-31','%Y-%m-%d')) " + 
            		"order by 2";

            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
            	spec = this.getById(rs.getInt("type_id"));
            	listSpec.add(spec);            	    
            }
            return listSpec;

        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new MuelitasException("SpecialityPersistence: Problem to get data.  "+spec.toString());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            return null;
        }
    }
    
    public Speciality getAllByDate(int id,Date date) throws MuelitasException{
        TypePersistence objSpecPer = new TypePersistence();
        
        DoctorPersistence objDocPer = new DoctorPersistence();
        List <Doctor> doctors=new ArrayList<Doctor>();
        Doctor objAux = new Doctor();
        
        Speciality spec = new Speciality(objSpecPer.getById(id));
        
        Connection conn= null;

        try {
            conn = ConnectionDB.connectDB();

            String sql = "select distinct sp.type_id,sp.type_desc,sp.type_parent,ds.doctor_id,concat(p.person_lastname,' ',p.person_name) doc" + 
            		"from type sp " + 
            		"inner join doctor_schedule ds on (sp.type_id=ds.speciality_id) " + 
            		"inner join person p on (p.person_id=ds.doctor_id)" + 
            		"where sp.type_parent='SP' " + 
            		"and now() between ds.docsche_dini and ifnull(ds.docsche_dend,str_to_date('2099-12-31','%Y-%m-%d')) \n" + 
            		"and ds.speciality_id=? " + 
            		"order by 2,5";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
            	objAux=objDocPer.getById(rs.getInt("doctor_id"));
            	doctors.add(objAux);            	    
            }
            spec.setDoctors(doctors);
            return spec;

        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new MuelitasException("SpecialityPersistence: Problem to get data");
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            return null;
        }
    }
 	
}

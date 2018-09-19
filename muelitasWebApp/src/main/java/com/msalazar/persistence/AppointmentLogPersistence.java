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
public class AppointmentLogPersistence {
	
	public AppointmentLog insert(AppointmentLog log) throws MuelitasException {
        Connection conn = null;
                
        AppointmentLog auxAppLog = new AppointmentLog(log.getAppointmentId(),log.getUserId(),log.getStatusId());
        
        try {
            conn = ConnectionDB.connectDB();
            
            //validate appointment
            
            // insert into appointment
            
            String sql = "insert into appointment_log (appointment_id,user_id,applog_datetime,status_id) values (?,?,now(),?)";
            
            PreparedStatement ps = conn.prepareStatement(sql);
            
            ps.setInt(1, log.getAppointmentId());
            ps.setString(2, log.getUserId());
            ps.setInt(3, log.getStatusId());            
            
            if (ps.executeUpdate() ==0) {
                throw new MuelitasException("Failed to insert AppointmentLog -> "+log.toString());
            }
            
            return log;
            

        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new MuelitasException("Error.  AppointmentLog's insert action failed");
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            return log;
        }
    }
 	
}

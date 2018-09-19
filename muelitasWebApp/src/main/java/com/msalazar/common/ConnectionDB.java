/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.msalazar.common;

import com.msalazar.exceptions.MuelitasException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author JAVA
 */
public class ConnectionDB {
    public static Connection connectDB() throws MuelitasException{
        Connection conn = null;
        try {
            //Class.forName("com.mysql.jdbc.Driver");
            Class.forName("com.mysql.cj.jdbc.Driver");

            //conn = DriverManager.getConnection("jdbc:mysql://192.168.56.59:3306/biblioteca", "root", "root");
            // jdbc:mysql://localhost:3306/biblioteca?autoReconnect=true&useSSL=false
            //useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/muelitasdb?useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "userMuelitas", "123456");

        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
            throw new MuelitasException("Error connecting to the database");
        } catch (SQLException ex){
            ex.printStackTrace();
            throw new MuelitasException("Error connecting to the database");
        } catch (Exception ex) {
        	ex.printStackTrace();
        	throw new MuelitasException("Unknowledge error");
        }
        return conn;
    }
    



}

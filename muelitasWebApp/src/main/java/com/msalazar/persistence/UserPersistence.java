package com.msalazar.persistence;

import com.msalazar.common.ConnectionDB;
import com.msalazar.data.Person;
import com.msalazar.data.Type;
import com.msalazar.data.User;
import com.msalazar.exceptions.MuelitasException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/***
 * 
 * @author msalazar
 *
 */
public class UserPersistence {
    public User insert(User user) throws MuelitasException {
        Connection conn = null;
                
        Person auxPerson = new Person(0, user.getName(), user.getLastName(), user.getAddress(), user.getZipcode(), user.getBornDate(), user.getPhone(), user.getCellphone(), user.getEmail(), user.getPersonType());
        
        
        try {
            conn = ConnectionDB.connectDB();
            
            // 1: insert into person and get the person Id
            PersonPersistence personPersistence = new PersonPersistence();
            auxPerson = personPersistence.insert(auxPerson);    
            // 2: insert into User
            
            String sql = "insert into user (person_id,user_id,user_password,role_id,user_name,user_lastname,user_email) values (?,?,?,?,?,?,?)";
            
            PreparedStatement ps = conn.prepareStatement(sql);
            
            ps.setInt(1, auxPerson.getId());
            ps.setString(2, user.getUserName());
            ps.setString(3, user.getPassword());
            ps.setInt(4, user.getRole().getId());
            ps.setString(5, user.getName());
            ps.setString(6, user.getLastName());
            ps.setString(7, user.getEmail());
            
            if (ps.executeUpdate() ==0) {
                throw new MuelitasException("Failed to insert User");
            }
            
            return user;
            

        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new MuelitasException("Error.  User's insert action failed");
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            return user;
        }
    }
    
    public User update(User user) throws MuelitasException {
        Connection conn = null;
                
        Person auxPerson = new Person(user.getId(), user.getName(), user.getLastName(), user.getAddress(), user.getZipcode(), user.getBornDate(), user.getPhone(), user.getCellphone(), user.getEmail(), user.getPersonType());
        
        try {
            conn = ConnectionDB.connectDB();
            
            // 1: update person and get the person Id
            PersonPersistence personPersistence = new PersonPersistence();
            personPersistence.update(auxPerson);
            
            String sql = "update user "
            		+ "set role_id=? "
            		+ "where person_id=?";
            
            PreparedStatement ps = conn.prepareStatement(sql);
            
            ps.setInt(1, user.getRole().getId());
            
            if (ps.executeUpdate() ==0) {
                throw new MuelitasException("Failed to update User " + this.toString());
            }
            
            return user;
            

        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new MuelitasException("Error.  Patient's update action failed. " + this.toString());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            return user;
        }
    }
    
    public Boolean updatePassword(int userId,String password) throws MuelitasException {
        Connection conn = null;
        
        System.out.println(userId + " " + password );
        
        try {
        	User u = this.getById(userId);
            
            if(!u.getPassword().equals(password))
            {
            	conn = ConnectionDB.connectDB();
                
                // 1: update person and get the person Id
                
                String sql = "update user "
                		+ "set user_password=? "
                		+ "where person_id=?";
                
                PreparedStatement ps = conn.prepareStatement(sql);
                
                ps.setString(1, password);
                ps.setInt(2, userId);
                
                if (ps.executeUpdate() ==0) {
                    throw new MuelitasException("Failed to update User " + this.toString());
                }
                
                return true;	
            }
            else {
            	return true;
            }
        	
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new MuelitasException("Error.  User's update action failed. " + this.toString());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            return false;
        }
    }

    public void delete(User data) throws MuelitasException{
        Connection conn = null;
        try {
            conn = ConnectionDB.connectDB();
            
            String sql = "delete from user where person_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, data.getId());
            if (ps.executeUpdate() == 0){
                throw new MuelitasException("Failed to delete User.  "+ this.toString());
            }
            
            sql = "delete from person where person_id = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, data.getId());
            if (ps.executeUpdate() == 0){
                throw new MuelitasException("Failed to delete Person.  "+ this.toString());
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
    public Boolean exist(User obj) throws MuelitasException{
        Boolean aux = false;
        
        Connection conn= null;

        try {
            conn = ConnectionDB.connectDB();

            String sql = "select pe.person_id,u.user_id "
            		+"from user u "
            		+ "inner join person pe on (pe.person_id=u.person_id) "
            		+ "where u.user_id=? ";
            		
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, obj.getUserName());

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                obj.setId(rs.getInt("person_id"));
                obj.setUserName(rs.getString("user_id"));
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
    
    public User getById(int id) throws MuelitasException{
        User objUser = new User();
    	Person objPerson = null;
        TypePersistence roleType = new TypePersistence();

        Connection conn= null;

        try {
            conn = ConnectionDB.connectDB();

            String sql = "select pe.person_id,pe.person_name,pe.person_lastname,pe.person_address,pe.person_zipcode,pe.person_borndate,pe.person_phone,pe.person_cellphone,pe.person_email " +
            		",pe.persontype_id,pt.type_desc,pt.type_parent" + 
            		",u.user_id,u.user_password,u.role_id,ro.type_desc roledesc,ro.type_parent roleparent " + 
            		"from user u " + 
            		"inner join person pe on (pe.person_id=u.person_id) " + 
            		"inner join type pt on (pt.type_id=pe.persontype_id) " + 
            		"inner join type ro on (ro.type_id=u.role_id) " + 
            		"where u.person_id=? ";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
            	objUser = new User(rs.getInt("person_id"),rs.getString("person_name"),rs.getString("person_lastname"),rs.getString("person_address"),rs.getString("person_zipcode"),rs.getDate("person_borndate"),rs.getString("person_phone"),rs.getString("person_cellphone"),rs.getString("person_email"),new Type(rs.getInt("persontype_id"),rs.getString("type_desc"),rs.getString("type_parent")),rs.getString("user_id"),rs.getString("user_password"),new Type(rs.getInt("role_id"),rs.getString("roledesc"),rs.getString("roleparent")));
                //System.out.println(objUser);
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

        return objUser;
    }
    
    public User getByUsernamePassword(String username, String password) throws MuelitasException{
        User objUser = new User();
    	Person objPerson = null;
        TypePersistence roleType = new TypePersistence();

        Connection conn= null;

        try {
            conn = ConnectionDB.connectDB();

            String sql = "select pe.person_id,pe.person_name,pe.person_lastname,pe.person_address,pe.person_zipcode,pe.person_borndate,pe.person_phone,pe.person_cellphone,pe.person_email " +
            		",pe.persontype_id,pt.type_desc,pt.type_parent" + 
            		",u.user_id,u.user_password,u.role_id,ro.type_desc roledesc,ro.type_parent roleparent " + 
            		"from user u " + 
            		"inner join person pe on (pe.person_id=u.person_id) " + 
            		"inner join type pt on (pt.type_id=pe.persontype_id) " + 
            		"inner join type ro on (ro.type_id=u.role_id) " + 
            		"where u.user_id=? and u.user_password=? ";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
            	objUser = new User(rs.getInt("person_id"),rs.getString("person_name"),rs.getString("person_lastname"),rs.getString("person_address"),rs.getString("person_zipcode"),rs.getDate("person_borndate"),rs.getString("person_phone"),rs.getString("person_cellphone"),rs.getString("person_email"),new Type(rs.getInt("persontype_id"),rs.getString("type_desc"),rs.getString("type_parent")),rs.getString("user_id"),rs.getString("user_password"),new Type(rs.getInt("role_id"),rs.getString("roledesc"),rs.getString("roleparent")));
                
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

        return objUser;
    }
    
    public List<User> getAll() throws MuelitasException{
        List<User> rsUser = new ArrayList<User>();
        User objAux = null;

        Connection conn= null;

        try {
            conn = ConnectionDB.connectDB();

            String sql = "select pe.person_id,pe.person_name,pe.person_lastname,pe.person_address,pe.person_zipcode"
            		+ ",pe.person_borndate,pe.person_phone,pe.person_cellphone,pe.person_email " + 
            		",pe.persontype_id,pt.type_desc,pt.type_parent " + 
            		",u.user_id,u.user_password,u.role_id,ro.type_desc roledesc,ro.type_parent roleparent " + 
            		"from user u " + 
            		"inner join person pe on (pe.person_id=u.person_id) " + 
            		"inner join type pt on (pt.type_id=pe.persontype_id) " + 
            		"inner join type ro on (ro.type_id=u.role_id) " +  
            		"order by 3,2";

            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

            	objAux = new User(rs.getInt("person_id"),rs.getString("person_name"),rs.getString("person_lastname"),rs.getString("person_address"),rs.getString("person_zipcode"),rs.getDate("person_borndate"),rs.getString("person_phone"),rs.getString("person_cellphone"),rs.getString("person_email"),new Type(rs.getInt("persontype_id"),rs.getString("type_desc"),rs.getString("type_parent")),rs.getString("user_id"),rs.getString("user_password"),new Type(rs.getInt("role_id"),rs.getString("roledesc"),rs.getString("roleparent")));
            	
            	//System.out.println(objAux.toString());

                rsUser.add(objAux);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new MuelitasException("UserPersistence: Problem to get data.");
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return rsUser;
    }
 	

}

package com.msalazar.persistence;

import com.msalazar.common.ConnectionDB;
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
public class PersonPersistence {
    public Person insert(Person person) throws MuelitasException {
        Connection conn = null;
        Boolean exist = false;
        try {
            conn = ConnectionDB.connectDB();
            //0. verify if person exists
            exist = this.exist(person);
            if (!exist) {
                //1. insert data
                String sql = "insert into person (person_name,person_lastname,person_address,person_zipcode,person_borndate,person_phone,person_cellphone,person_email,persontype_id) values (?,?,?,?,?,?,?,?,?)";
                
                PreparedStatement ps = conn.prepareStatement(sql);
                
                ps.setString(1, person.getName());
                ps.setString(2, person.getLastName());
                ps.setString(3, person.getAddress());
                ps.setString(4, person.getZipcode());
                if(person.getBornDate()!=null) {
                	ps.setDate(5, new java.sql.Date(person.getBornDate().getTime()));
                }
                else {
                	java.util.Date date = new java.util.Date();
                	ps.setDate(5, new java.sql.Date(date.getTime()));
                }
                	
          
                ps.setString(6, person.getPhone());
                ps.setString(7, person.getCellphone());
                ps.setString(8, person.getEmail());
                if(person.getPersonType()!=null) {
                	ps.setInt(9, person.getPersonType().getId());
                } else {
                	ps.setInt(9,3);
                }
                
                
                if (ps.executeUpdate() ==0) {
                    throw new MuelitasException("Failed to insert Person");
                }
                
                //2. get person_id
                exist = this.exist(person);
                if (exist) {
                	return person;
                }
                else {
                	throw new MuelitasException("PersonPersistence: Something happened. Insertion failed");
                }
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new MuelitasException("Error.  Person's insert action failed");
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            return person;
        }
    }

    public void update(Person data) throws MuelitasException{
        Connection conn = null;
        try {
            conn = ConnectionDB.connectDB();

            String sql = "update person set person_name=?, person_lastname=?, person_address=?, person_zipcode=?, person_borndate=?, person_phone=?, person_cellphone=?, person_email=? where person_id = ? ";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, data.getName());
            ps.setString(2, data.getLastName());
            ps.setString(3, data.getAddress());
            ps.setString(4, data.getZipcode());
            ps.setDate(5, (Date) data.getBornDate());
            ps.setString(6, data.getPhone());
            ps.setString(7, data.getCellphone());
            ps.setString(8, data.getEmail());
            ps.setInt(9, data.getId());

            if (ps.executeUpdate() ==0) {
                throw new MuelitasException("Failed to update Person");
            }


        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new MuelitasException("Error.  Person's update action failed");
        } finally {
            try{
                if (conn != null){
                    conn.close();
                }
            } catch (Exception ex){
                ex.printStackTrace();
            }
        }
         


    }

    public void delete(Person data) throws MuelitasException{
        Connection conn = null;
        try {
            conn = ConnectionDB.connectDB();
            
            String sql = "delete from person where person_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
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
     * Load person_id to object obj and return true if it exists 
     * @param obj
     * @return
     * @throws MuelitasException
     */
    public Boolean exist(Person obj) throws MuelitasException{
        Boolean aux = false;
        
        Connection conn= null;

        try {
            conn = ConnectionDB.connectDB();

            String sql = "select person_id,count(*) qty "
            		+"from person "
            		+"where person_name=? and person_lastname=? and person_address=? and person_zipcode=? "
            		+"group by person_id ";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, obj.getName());
            ps.setString(2, obj.getLastName());
            ps.setString(3, obj.getAddress());
            ps.setString(4, obj.getZipcode());

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                obj.setId(rs.getInt("person_id"));
                aux = true;
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

        return aux;
    }
    
    public Person getById(int id) throws MuelitasException{
        Person objAux = null;
        TypePersistence personType = new TypePersistence();

        Connection conn= null;

        try {
            conn = ConnectionDB.connectDB();

            String sql = "select person_id,person_name,person_lastname,person_address,person_zipcode," 
            		+"person_borndate,person_phone,person_cellphone,person_email,persontype_id "
            		+"from person "
            		+"where person_id = ?";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                objAux = new Person(rs.getInt("person_id"),rs.getString("person_name"),rs.getString("person_lastname"),rs.getString("person_address"),rs.getString("person_zipcode"),rs.getDate("person_borndate"),rs.getString("person_phone"),rs.getString("person_cellphone"),rs.getString("person_email"),personType.getById(rs.getInt("persontype_id")));
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

        return objAux;
    }
    
    public List<Person>  getAll() throws MuelitasException{
        List<Person> rsPerson = new ArrayList<Person>();
        Person objAux = null;
        TypePersistence personType = new TypePersistence();

        Connection conn= null;

        try {
            conn = ConnectionDB.connectDB();

            String sql = "select person_id,person_name,person_lastname,person_address,person_zipcode," 
            		+"person_borndate,person_phone,person_cellphone,person_email,persontype_id "
            		+"from person "
            		+"order by 1";

            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
            	objAux = new Person(rs.getInt("person_id"),rs.getString("person_name"),rs.getString("person_lastname"),rs.getString("person_address"),rs.getString("person_zipcode"),rs.getDate("person_borndate"),rs.getString("person_phone"),rs.getString("person_cellphone"),rs.getString("person_email"),personType.getById(rs.getInt("persontype_id")));
                rsPerson.add(objAux);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new MuelitasException("PersonPersitence: Problem to get data");
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return rsPerson;
    }
    
    public List<Person>  getAllStaff() throws MuelitasException{
        List<Person> rsPerson = new ArrayList<Person>();
        Person objAux = null;
        TypePersistence personType = new TypePersistence();

        Connection conn= null;

        try {
            conn = ConnectionDB.connectDB();

            String sql = "select p.person_id,p.person_name,p.person_lastname,p.person_address,p.person_zipcode," 
            		+"p.person_borndate,p.person_phone,p.person_cellphone,p.person_email,p.persontype_id "
            		+"from person p "
            		+"inner join user u on (u.person_id=p.person_id) "
            		+"order by 1";

            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
            	objAux = new Person(rs.getInt("person_id"),rs.getString("person_name"),rs.getString("person_lastname"),rs.getString("person_address"),rs.getString("person_zipcode"),rs.getDate("person_borndate"),rs.getString("person_phone"),rs.getString("person_cellphone"),rs.getString("person_email"),personType.getById(rs.getInt("persontype_id")));
                rsPerson.add(objAux);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new MuelitasException("PersonPersitence: Problem to get data");
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return rsPerson;
    }
    
    
 	

}

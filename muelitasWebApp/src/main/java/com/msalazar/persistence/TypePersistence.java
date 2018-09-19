package com.msalazar.persistence;

import com.msalazar.common.ConnectionDB;
import com.msalazar.data.Type;
import com.msalazar.exceptions.MuelitasException;

import java.sql.Connection;
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
public class TypePersistence {
    public void insert(Type type) throws MuelitasException {
        Connection conn = null;
        try {
            conn = ConnectionDB.connectDB();
            //1. Crear sentencia sql, colocando ? en las partes variable
            String sql = "insert into type (type_desc,type_parent) values (?,?)";
            //2. Crear objeto PreparedStatement asiciado a la sentencia
            PreparedStatement ps = conn.prepareStatement(sql);
            //3. Reemplazar las incognitas por valores
            ps.setString(1, type.getDesc());
            ps.setString(2, type.getParent());
            //4. Ejecutar la sentencia
            if (ps.executeUpdate() ==0) {
                throw new MuelitasException("Failed to insert Type");
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new MuelitasException("Error.  Type's insert action failed");
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

    public void update(Type type) throws MuelitasException{
        Connection conn = null;
        try {
            conn = ConnectionDB.connectDB();

            String sql = "update type set type_desc= ? where type_id = ? and type_parent = ?";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, type.getDesc());
            ps.setInt(2, type.getId());
            ps.setString(3, type.getParent());

            if (ps.executeUpdate() ==0) {
                throw new MuelitasException("Failed to update Type");
            }


        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new MuelitasException("Error.  Type's update action failed");
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

    public void eliminar(Type type) throws MuelitasException{
        Connection conn = null;
        try {
            conn = ConnectionDB.connectDB();
            //1. Crear sentencia sql, colocando ? en las partes variable
            String sql = "delete from type where type_id = ?";
            //2. Crear objeto PreparedStatement asociado a la sentencia
            PreparedStatement ps = conn.prepareStatement(sql);
            //3. Reemplazar las incognitas por valores
            ps.setInt(1, type.getId());
            //4. Ejecutar la senencia
            if (ps.executeUpdate() == 0){
                throw new MuelitasException("Failed to delete Type");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new MuelitasException("Error. Type's delete action failed");
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

    public List<Type>  getAllByParent(String parent) throws MuelitasException {
        return getAllSQL(parent);
    }

    private List<Type>  getAllSQL(String condition) throws MuelitasException{
        List<Type> types = new ArrayList<Type>();
        Type type = null;
        String aux = "";
        
        if (condition.length()>0)
        	aux = "where type_parent='"+condition+"' ";

        Connection conn= null;

        try {
            conn = ConnectionDB.connectDB();

            String sql = "select type_id , type_desc " 
            		+ "from type "
                    + aux   
                    + "order by type_desc";

            Statement st = conn.createStatement();

            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                type = new Type(rs.getInt("type_id"), rs.getString("type_desc"),condition);
                types.add(type);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new MuelitasException("TypePersistence: Problem to get data");
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
 
        return types;
    }

    public Type getById(int typeId) throws MuelitasException{
        Type typeAux = null;

        Connection conn= null;

        try {
            conn = ConnectionDB.connectDB();

            String sql = "select type_id , type_desc, type_parent from type where type_id = ?";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, typeId);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                typeAux = new Type(rs.getInt("type_id"), rs.getString("type_desc"), rs.getString("type_parent")) ;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new MuelitasException("TypePersistence: Problem to get data");
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

        return typeAux;
    }

    public List<Type>  getAll() throws MuelitasException{
        List<Type> rsType = new ArrayList<Type>();
        Type typeAux = null;

        Connection conn= null;

        try {
            conn = ConnectionDB.connectDB();

            String sql = "select type_id , type_desc, type_parent from type order by type_parent,type_desc";

            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                typeAux = new Type(rs.getInt("type_id"), rs.getString("type_desc"), rs.getString("type_parent"));
                rsType.add(typeAux);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new MuelitasException("TypePersitence: Problem to get data");
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

        return rsType;
    }
    
    public List<Type>  getPersonTypes() throws MuelitasException{
      	return getAllSQL("PT");
    }
    
    public List<Type>  getOccupations() throws MuelitasException{
      	return getAllSQL("OC");
    }
    
    public List<Type>  getSpecialities() throws MuelitasException{
      	return getAllSQL("SP");
    }
    
    public List<Type>  getAppointmentStatus() throws MuelitasException{
      	return getAllSQL("ST");
    }
    	

}

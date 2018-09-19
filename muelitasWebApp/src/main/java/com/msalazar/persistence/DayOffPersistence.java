package com.msalazar.persistence;

import com.msalazar.common.ConnectionDB;
import com.msalazar.data.DayOff;
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
public class DayOffPersistence {
    public void insert(DayOff data) throws MuelitasException {
        Connection conn = null;
        try {
            conn = ConnectionDB.connectDB();
            //1. Crear sentencia sql, colocando ? en las partes variable
            String sql = "insert into day_off (dayoff_id,dayoff_desc) values (?,?)";
            //2. Crear objeto PreparedStatement asiciado a la sentencia
            PreparedStatement ps = conn.prepareStatement(sql);
            //3. Reemplazar las incognitas por valores
            ps.setDate(1, (Date) data.getId());
            ps.setString(2, data.getDesc());
            //4. Ejecutar la sentencia
            if (ps.executeUpdate() ==0) {
                throw new MuelitasException("Failed to insert Day-Off");
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new MuelitasException("Error.  Day-Off action's failed");
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

    public void update(DayOff data) throws MuelitasException{
        Connection conn = null;
        try {
            conn = ConnectionDB.connectDB();

            String sql = "update day_off set dayoff_desc= ? where dayoff_id = ? ";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, data.getDesc());
            ps.setDate(2, (Date) data.getId());

            if (ps.executeUpdate() ==0) {
                throw new MuelitasException("Failed to update Day-Off");
            }


        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new MuelitasException("Error.  Day Off's update action failed");
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

    public void eliminar(DayOff data) throws MuelitasException{
        Connection conn = null;
        try {
            conn = ConnectionDB.connectDB();
            //1. Crear sentencia sql, colocando ? en las partes variable
            String sql = "delete from day_off where dayoff_id = ?";
            //2. Crear objeto PreparedStatement asociado a la sentencia
            PreparedStatement ps = conn.prepareStatement(sql);
            //3. Reemplazar las incognitas por valores
            ps.setDate(1, (Date) data.getId());
            //4. Ejecutar la sentencia
            if (ps.executeUpdate() == 0){
                throw new MuelitasException("Failed to delete Day-Off");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new MuelitasException("Error. Day-Off's delete action failed");
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

    public DayOff getById(Date dayoffId) throws MuelitasException{
        DayOff objAux = null;

        Connection conn= null;

        try {
            conn = ConnectionDB.connectDB();

            String sql = "select dayoff_id , dayoff_desc from day_off where dayoff_id = ?";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setDate(1, dayoffId);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                objAux = new DayOff(rs.getDate("dayoff_id"), rs.getString("dayoff_desc")) ;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new MuelitasException("DayOffPersistence: Problem to get data");
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

    public List<DayOff>  getAll() throws MuelitasException{
        List<DayOff> rsType = new ArrayList<DayOff>();
        DayOff objAux = null;

        Connection conn= null;

        try {
            conn = ConnectionDB.connectDB();

            String sql = "select dayoff_id , dayoff_desc from day_off order by 1";

            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                objAux = new DayOff(rs.getDate("dayoff_id"), rs.getString("dayoff_desc"));
                rsType.add(objAux);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new MuelitasException("DayoffPersitence: Problem to get data");
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

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import config.Configuration;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Alumno;
import model.Asignatura;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author oscar
 */
public class AsignaturasDAO {
     public int insertAsignaturaJDBC(Asignatura a) {
        Connection con = null;
        PreparedStatement stmt = null;
        int filas = -1;
        try {
           con=DBConnectionPool.getInstance().getConnection();

            stmt = con.prepareStatement("INSERT INTO asignaturas "
              + "(NOMBRE,CURSO,CICLO)  "
              + "VALUES (?,?,?) ", Statement.RETURN_GENERATED_KEYS);

            stmt.setString(1, a.getNombre());

            stmt.setString(2,a.getCurso());

            stmt.setString(3, a.getCiclo());

            

            filas = stmt.executeUpdate();
            
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                a.setId(rs.getInt(1));
            }
            
            
        } catch (Exception ex) {
            Logger.getLogger(AlumnosDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBConnectionPool.getInstance().cerrarConexion(con);

        }
        return filas;

    }
      public int DeleteAsignaturaJDBC(int idWhere) {//Actualizar Aasignatura
        Connection con = null;
        PreparedStatement stmt = null;
        int filas = -1;
        try {
            con=DBConnectionPool.getInstance().getConnection();

            stmt = con.prepareStatement("DELETE FROM asignaturas"
                    + " WHERE id=?;");

            stmt.setInt(1, idWhere);

            filas = stmt.executeUpdate();


        } catch (Exception ex) {
            Logger.getLogger(AlumnosDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
           DBConnectionPool.getInstance().cerrarConexion(con);

        }
        return filas;

    }
       public int updateAsignaturaJDBC(Asignatura a) {//Actualizar Aasignatura
        Connection con = null;
        PreparedStatement stmt = null;
        int filas = -1;
        try {
            con=DBConnectionPool.getInstance().getConnection();

            stmt = con.prepareStatement("UPDATE asignaturas "
                    + "SET NOMBRE=?,CURSO=?,CICLO=? where id=?");

            stmt.setString(1, a.getNombre());

            stmt.setString(2,a.getCurso());

            stmt.setString(3,a.getCiclo());

            stmt.setInt(4, a.getId());

            filas = stmt.executeUpdate();

        } catch (Exception ex) {
            Logger.getLogger(AlumnosDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
           DBConnectionPool.getInstance().cerrarConexion(con);
        }
        return filas;

    }
       public int updateJDBCTemplate(Asignatura a) {
        JdbcTemplate jtm = new JdbcTemplate(
          DBConnectionPool.getInstance().getDataSource());
        String updateQuery = "update asignaturas set NOMBRE=?,CURSO=?,CICLO=? where id = ?";
        int filas = jtm.update(updateQuery, a.getNombre(),a.getCurso(),a.getCiclo(), a.getId());
        return filas;
    }
       
       
       public List<Asignatura> getAllAlumnosJDBCTemplate() {

        JdbcTemplate jtm = new JdbcTemplate(
          DBConnectionPool.getInstance().getDataSource());
        List<Asignatura> asignatura = jtm.query("Select * from asignaturas",
          new BeanPropertyRowMapper(Asignatura.class));
        return asignatura;
    }
}

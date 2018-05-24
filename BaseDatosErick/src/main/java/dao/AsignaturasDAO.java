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
import model.Asignatura;

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
        public List<Asignatura> getAllAsignaturasJDBC() {
        List<Asignatura> lista = new ArrayList<>();
        Asignatura nuevo = null;

        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            con=DBConnectionPool.getInstance().getConnection();

            stmt = con.createStatement();
            String sql;

            sql = "SELECT * FROM asignaturas";
            rs = stmt.executeQuery(sql);

            //STEP 5: Extract data from result set
            while (rs.next()) {
                //Retrieve by column name
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String curso = rs.getNString("curso");
                String ciclo = rs.getString("ciclo");
                nuevo = new Asignatura();
                nuevo.setCurso(curso);
                nuevo.setId(id);
                nuevo.setCiclo(ciclo);
                nuevo.setNombre(nombre);
                lista.add(nuevo);
            }

        } catch (Exception ex) {
            Logger.getLogger(AlumnosDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBConnectionPool.getInstance().cerrarConexion(con);

        }
        return lista;

    }
}

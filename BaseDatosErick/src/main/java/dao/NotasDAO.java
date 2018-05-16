/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import config.Configuration;
import dao.AlumnosDAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Alumno;
import model.Asignatura;

/**
 *
 * @author daw
 */
public class NotasDAO {

    public int enlasarAlumnoJDBC(Alumno a, Asignatura b) {
        Connection con = null;
        DBConnection abreCierra = new DBConnection();
        PreparedStatement stmt = null;
        int filas = -1;
        try {
            con = abreCierra.getConnection();

            stmt = con.prepareStatement("INSERT INTO `baseerick`.`notas` (`id_alumnos`, `id_asignaturas`) VALUES (?,?);");

            stmt.setInt(1, a.getId());

            stmt.setInt(2, b.getId());
            filas = stmt.executeUpdate();

        } catch (Exception ex) {
            Logger.getLogger(NotasDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            abreCierra.cerrarConexion(con);
        }
        return filas;

    }

    public int delUser2(Alumno a) {
        DBConnection db = new DBConnection();
        Connection con = null;
        int filas = 0;
        try {
            con = db.getConnection();
            con.setAutoCommit(false);
            String sql = "DELETE FROM notas WHERE id_alumnos = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setLong(1, a.getId());

            filas += stmt.executeUpdate();

            sql = "DELETE FROM alumnos WHERE id = ?";
            stmt = con.prepareStatement(sql);
            stmt.setLong(1, a.getId());

            filas += stmt.executeUpdate();
            con.commit();

        } catch (Exception ex) {
            Logger.getLogger(AlumnosDAO.class.getName()).log(Level.SEVERE, null, ex);
            try {
                if (con != null) {
                    con.rollback();
                }
            } catch (SQLException ex1) {
                Logger.getLogger(AlumnosDAO.class.getName()).log(Level.SEVERE, null, ex1);
            }
        } finally {
            db.cerrarConexion(con);
        }
        return filas;

    }
    
    public int delAsig2(Asignatura a) {
        DBConnection db = new DBConnection();
        Connection con = null;
        int filas = 0;
        try {
            con = db.getConnection();
            con.setAutoCommit(false);
            String sql = "DELETE FROM notas WHERE id_asignaturas = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setLong(1, a.getId());

            filas += stmt.executeUpdate();

            sql = "DELETE FROM asignaturas WHERE id = ?";
            stmt = con.prepareStatement(sql);
            stmt.setLong(1, a.getId());

            filas += stmt.executeUpdate();
            con.commit();

        } catch (Exception ex) {
            Logger.getLogger(AlumnosDAO.class.getName()).log(Level.SEVERE, null, ex);
            try {
                if (con != null) {
                    con.rollback();
                }
            } catch (SQLException ex1) {
                Logger.getLogger(AlumnosDAO.class.getName()).log(Level.SEVERE, null, ex1);
            }
        } finally {
            db.cerrarConexion(con);
        }
        return filas;

    }
    public List<Alumno> getCambia( Asignatura a) {
        List<Alumno> lista = new ArrayList<>();
        Alumno nuevo = null;

        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            Class.forName(Configuration.getInstance().getDriverDB());

            con = DriverManager.getConnection(
                    Configuration.getInstance().getUrlDB(),
                    Configuration.getInstance().getUserDB(),
                    Configuration.getInstance().getPassDB());

            stmt = con.createStatement();
            String sql;

            sql = "SELECT a.NOMBRE FROM alumnos a join notas n on a.ID=n.id_alumnos join asignaturas s on s.ID=n.id_asignaturas   ";
            rs = stmt.executeQuery(sql);

            //STEP 5: Extract data from result set
            while (rs.next()) {
                //Retrieve by column name
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                Date fecha_nacimiento = rs.getDate("fecha_nacimiento");
                Boolean mayor_edad = rs.getBoolean("mayor_edad");
                nuevo = new Alumno();
                nuevo.setNombre(nombre);
                nuevo.setId(id);
                nuevo.setFecha_nacimiento(fecha_nacimiento);
                nuevo.setMayor_edad(mayor_edad);
                lista.add(nuevo);
            }

        } catch (Exception ex) {
            Logger.getLogger(AlumnosDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(AlumnosDAO.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return lista;

    }
}

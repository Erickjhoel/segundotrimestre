/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import config.Configuration;
import model.Alumno;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import model.Asignatura;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

/**
 *
 * @author oscar
 */
public class AlumnosDAO {

    ////////Apache commmons**************************************************************************************
    public List<Alumno> getAllAlumnosDBUtils() {
        List<Alumno> lista = null;

        Connection con = null;
        try {
            con = DBConnectionPool.getInstance().getConnection();

            QueryRunner qr = new QueryRunner();
            ResultSetHandler<List<Alumno>> handler
                    = new BeanListHandler<>(Alumno.class);
            lista = qr.query(con, "select * FROM ALUMNOS", handler);

        } catch (Exception ex) {
            Logger.getLogger(AlumnosDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            DBConnectionPool.getInstance().cerrarConexion(con);
        }
        return lista;
    }

    public Alumno addUserDBUtils(Alumno alumno) {

        Connection con = null;

        try {
            con = DBConnectionPool.getInstance().getConnection();
            con.setAutoCommit(false);
            QueryRunner qr = new QueryRunner();
            Integer id = qr.insert(con,
                    "INSERT INTO alumnos (NOMBRE,FECHA_NACIMIENTO,MAYOR_EDAD) "
                    + "VALUES(?,?,?)",
                    new ScalarHandler<>(),
                    alumno.getNombre(), alumno.getFecha_nacimiento(), alumno.getMayor_edad());
            alumno.setId(id.intValue());
            con.commit();

        } catch (Exception ex) {
            try {
                Logger.getLogger(AlumnosDAO.class.getName()).log(Level.SEVERE, null, ex);
                if (con != null) {
                    con.rollback();
                }
            } catch (SQLException ex1) {
                Logger.getLogger(AlumnosDAO.class.getName()).log(Level.SEVERE, null, ex1);
            }
        } finally {
            DBConnectionPool.getInstance().cerrarConexion(con);
        }
        return alumno;

    }

    public Alumno updateUserDBUtils(Alumno alumno) {//-*/-*/-*/-*/-*/-*/-*/-*/-*/*-/-*/-*/-*/-*/-*/-*
        Connection con = null;
        try {
            con = DBConnectionPool.getInstance().getConnection();
            QueryRunner qr = new QueryRunner();
            int filas = qr.update(con,
                    "UPDATE ALUMNOS SET NOMBRE = ? WHERE ID = ?",
                    alumno.getNombre(), alumno.getId());
        } catch (Exception ex) {
            Logger.getLogger(AlumnosDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBConnectionPool.getInstance().cerrarConexion(con);
        }
        return alumno;
    }

    public int DeleteUserDBUtils(Alumno alumno) {//-*/-*/-*/-*/-*/-*/-*/-*/-*/*-/-*/-*/-*/-*/-*/-*
        Connection con = null;
        int filas = -1;
        try {
            con = DBConnectionPool.getInstance().getConnection();
            QueryRunner qr = new QueryRunner();
            filas = qr.update(con,
                    "DELETE FROM ALUMNOS WHERE ID = ?",
                    alumno.getId());
        } catch (SQLException ex) {
            if (ex.getMessage().indexOf("violación") != -1) {
                eliminalReferenciado(alumno);
            }
        } catch (Exception ex) {
            Logger.getLogger(AlumnosDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBConnectionPool.getInstance().cerrarConexion(con);
        }
        return filas;
    }

    public int eliminalReferenciado(Alumno alumno) {
        Connection con = null;
        int filas = 0;
        try {
            con = DBConnectionPool.getInstance().getConnection();
            QueryRunner qr = new QueryRunner();
            filas = qr.update(con,
                    "DELETE FROM notas WHERE ID_ALUMNO = ?",
                    alumno.getId());
            con.commit();

            filas = qr.update(con,
                    "DELETE FROM ALUMNOS WHERE ID = ?",
                    alumno.getId());

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
            DBConnectionPool.getInstance().cerrarConexion(con);
        }
        return filas;

    }
}

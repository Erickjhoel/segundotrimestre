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
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Alumno;
import model.Asignaturas;

/**
 *
 * @author daw
 */
public class NotasDAO {

    public int enlasarAlumnoJDBC(Alumno a, Asignaturas b) {
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

}

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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Alumno;
import model.Asignatura;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

/**
 *
 * @author oscar
 */
public class AsignaturasDAO {
    
       public int updateJDBCTemplate(Asignatura a) {
        JdbcTemplate jtm = new JdbcTemplate(
          DBConnectionPool.getInstance().getDataSource());
        String updateQuery = "delete from asignaturas where id = ?";
        int filas = jtm.update(updateQuery,a.getId());
        return filas;
    }
       public int deleteJDBCTemplate(Asignatura a) {
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
       public Asignatura addUserJDBCTemplate(Asignatura a) {

        SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(
          DBConnectionPool.getInstance().getDataSource()).withTableName("ALUMNOS").usingGeneratedKeyColumns("ID");
        Map<String, Object> parameters = new HashMap<String, Object>();

        parameters.put("NOMBRE", a.getNombre());
        parameters.put("CICLO", a.getCiclo());
        parameters.put("CURSO", a.getCurso());
        a.setId(jdbcInsert.executeAndReturnKey(parameters).intValue());
        return a;
    }
}

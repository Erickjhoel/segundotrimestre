/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import dao.AlumnosDAO;
import java.util.List;
import model.Alumno;

/**
 *
 * @author oscar
 */
public class AlumnosServicios {
    
    
    public List<Alumno> getAllAlumnos()
    {
        AlumnosDAO dao = new AlumnosDAO();
        
        return dao.getAllAlumnoJDBC();
    }
    
    public int getBorrarAlum(int id){
        AlumnosDAO dao = new AlumnosDAO();
        
        return dao.DeleteAlumnoJDBC(id);
        
    }
    public int getActualizarAlum(Alumno alumnoNuevo)
    {
        AlumnosDAO dao = new AlumnosDAO();
       return dao.updateAlumnoJDBC(alumnoNuevo);
    }
    public int getInsertAlum(Alumno alumnoNuevo)
    {
        AlumnosDAO dao = new AlumnosDAO();
       return dao.insertAlumnoJDBC(alumnoNuevo);
    }
    
}

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
        
        return dao.getAllAlumnosDBUtils();
    }
    
    
    public int getBorrarAlum(Alumno eliminal){
        AlumnosDAO dao = new AlumnosDAO();
        
        return dao.DeleteUserDBUtils(eliminal);
        
    }
     public int getEliminarAlumReferenciado(Alumno eliminar)
    {
        AlumnosDAO dao = new AlumnosDAO();
       return dao.eliminalReferenciado(eliminar);
    }
    public Alumno getActualizarAlum(Alumno alumnoNuevo)
    {
        AlumnosDAO dao = new AlumnosDAO();
       return dao.updateUserDBUtils(alumnoNuevo);
    }
    public Alumno getInsertAlum(Alumno alumnoNuevo)
    {
        AlumnosDAO dao = new AlumnosDAO();
       return dao.addUserDBUtils(alumnoNuevo);
    }

    
}

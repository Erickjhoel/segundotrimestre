/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import dao.AlumnosDAO;
import dao.AsignaturasDAO;
import java.util.List;
import model.Alumno;
import model.Asignaturas;

/**
 *
 * @author daw
 */
public class AsignaturasServicios {
    public List<Asignaturas> getAllAsignatura()
    {
        AsignaturasDAO dao = new AsignaturasDAO();
        
        return dao.getAllAsignaturasJDBC();
    }
    
    public int getBorrarAsignatura(int id){
        AsignaturasDAO dao = new AsignaturasDAO();
        
        return dao.DeleteAsignaturaJDBC(id);
        
    }
    public int getActualizarAsignatura(Asignaturas asignueva)
    {
        AsignaturasDAO dao = new AsignaturasDAO();
       return dao.updateAsignaturaJDBC(asignueva);
    }
    public int getInsertAsignatura(Asignaturas asignueva)
    {
        AsignaturasDAO dao = new AsignaturasDAO();
       return dao.insertAsignaturaJDBC(asignueva);
    }
}

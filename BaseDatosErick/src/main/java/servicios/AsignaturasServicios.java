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
import model.Asignatura;

/**
 *
 * @author daw
 */
public class AsignaturasServicios {
    public List<Asignatura> getAllAsignatura()
    {
        AsignaturasDAO dao = new AsignaturasDAO();
        
        return dao.getAllAsignaturasJDBC();
    }
    
    public int getBorrarAsignatura(int id){
        AsignaturasDAO dao = new AsignaturasDAO();
        
        return dao.DeleteAsignaturaJDBC(id);
        
    }
    public int getActualizarAsignatura(Asignatura asignueva)
    {
        AsignaturasDAO dao = new AsignaturasDAO();
       return dao.updateAsignaturaJDBC(asignueva);
    }
    public int getInsertAsignatura(Asignatura asignueva)
    {
        AsignaturasDAO dao = new AsignaturasDAO();
       return dao.insertAsignaturaJDBC(asignueva);
    }
}

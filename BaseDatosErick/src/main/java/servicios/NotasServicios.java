/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import dao.AlumnosDAO;
import dao.NotasDAO;
import model.Alumno;
import model.Asignaturas;
import model.Notas;

/**
 *
 * @author daw
 */
public class NotasServicios {
    public int getInsertAlum(Alumno enlasito, Asignaturas enlasar)
    {
        NotasDAO dao = new NotasDAO();
       return dao.enlasarAlumnoJDBC(enlasito, enlasar);
    }
}

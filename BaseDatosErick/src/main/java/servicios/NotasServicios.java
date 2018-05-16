/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import dao.AlumnosDAO;
import dao.NotasDAO;
import model.Alumno;
import model.Asignatura;
import model.Notas;

/**
 *
 * @author daw
 */
public class NotasServicios {
    public int getInsertAlum(Alumno enlasito, Asignatura enlasar)
    {
        NotasDAO dao = new NotasDAO();
       return dao.enlasarAlumnoJDBC(enlasito, enlasar);
    }
    public int getEliminarAlum(Alumno eliminar)
    {
        NotasDAO dao = new NotasDAO();
       return dao.delUser2(eliminar);
    }
    public int getEliminarAsig(Asignatura eliminar)
    {
        NotasDAO dao = new NotasDAO();
       return dao.delAsig2(eliminar);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import dao.ConexionSimpleBD;
import java.util.List;
import model.Alumno;
import model.Asignaturas;

/**
 *
 * @author user
 */
public class Main {
    
    public static void main(String[] args) {
     ConexionSimpleBD c = new    ConexionSimpleBD();
     
     
     List<Asignaturas> asignatura = c.getAllAlumnosJDBC();
     for (Asignaturas a : asignatura)
       {
           System.out.println(a.toString());
       }
    }
    
}

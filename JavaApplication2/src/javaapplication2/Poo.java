/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;

import clases.Actividades;
import clases.Alumno;
import clases.Horario;
import java.util.Scanner;

/**
 *
 * @author daw
 */
public class Poo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        Actividades[] tipo = new Actividades[11];
        Alumno[] alumnos = new Alumno[50];
        
       //aerobic
        tipo[0]=new Actividades("aerobic", 35, 47.60f,new Horario("L,X,V", 10, 11));//da valores
        tipo[1]=new Actividades("aerobic", 35, 47.60f,new Horario("L,X,V", 11, 12));
        tipo[2]=new Actividades("aerobic", 35, 47.60f,new Horario("L,X,V", 19, 20));
        tipo[3]=new Actividades("aerobic", 35, 35.70f,new Horario("M,J", 9, 10));
        tipo[4]=new Actividades("aerobic", 35, 35.70f,new Horario("M,J", 10, 11));
        tipo[5]=new Actividades("aerobic", 35, 35.70f,new Horario("M,J", 18, 19));
        //Artes Marciales
        tipo[6]=new Actividades("artes marciales", 15, 45.00f,new Horario("L,X,V", 19, 20));
        tipo[7]=new Actividades("artes marciales", 15, 34.00f,new Horario("M,J", 18, 19));
        tipo[8]=new Actividades("artes marciales", 15, 34.00f,new Horario("M,J", 19, 20));
        //Natacion
        tipo[9]=new Actividades("natacion", 35, 47.60f,new Horario("L,X,V", 18, 19));
        tipo[10]=new Actividades("natacion", 35, 35.70f,new Horario("M,J", 17, 18));
        System.out.println("precio"+tipo[1].getTipo());//imprime el tipo
// dar de alta 
//dar de baja
//matricular-->buscar
//generar reciboalumno
//enerar recibo clases

    System.out.println("Elije el numero de ejercicio del 1 al 17, los enunciados son:\n"
          + "1. Dar Alta. \n"
          + "2. Baja Alumno \n"
          + "3. Matricular Alumno \n"
          + "4. Recibo Alumno \n"
          + "5. Recibo Actividad \n"
          + "4. Imprimir Alumnos \n"
          + "5. Imprimir Actividades \n");
        int opcion = sc.nextInt();
        sc.nextLine();
        int numAlumnos=0;
        switch (opcion) {
            case 1:
                alumnos[numAlumnos] = darAltaAlumno(sc);
                numAlumnos++;
                break;
            case 2:
                break;
            default:
                System.out.println("opcion no valida");
        }
    }
    
    public static Alumno darAltaAlumno(Scanner sc) {
        String nombre;
        String apellido;
        // pedir nombre y apellidos por teclado
        System.out.println("Introduzca el nombre del alumno");
        nombre= sc.nextLine();
        System.out.println("Introduzca el apellido del alumno");
        apellido= sc.nextLine();
        //crear el alumno
        Alumno daralta =new Alumno(nombre,apellido);
        System.out.println("El alumno introducido es "+daralta.getNombre()+" - "+daralta.getApellido());
        //devolver alumno
        return daralta;
    }
    
    public static void darBajaAlumno(Alumno[] alumnos) {
        //encontrar Alumno
        
        //Dar de baja de las actividades, aumentar plaza
        
        //reordenar array para no dejar huecos
        
        return;
    }
    public static void encontrarAlumno(){
        
        
        return ;
    }
}

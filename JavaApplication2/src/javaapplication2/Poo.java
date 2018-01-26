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
        private Horario [] horario=new Horario[4];
        private Actividades[] tipo = new Actividades[11];
        private Alumno[] alumnos = new Alumno[50];
        int numAlumnos=0;
    public Poo() {
        tipo[0] = new Actividades("aerobic", 35, 47.60f, new Horario("L,X,V", 10, 11));//da valores
        tipo[1] = new Actividades("aerobic", 35, 47.60f, new Horario("L,X,V", 11, 12));
        tipo[2] = new Actividades("aerobic", 35, 47.60f, new Horario("L,X,V", 19, 20));
        tipo[3] = new Actividades("aerobic", 35, 35.70f, new Horario("M,J", 9, 10));
        tipo[4] = new Actividades("aerobic", 35, 35.70f, new Horario("M,J", 10, 11));
        tipo[5] = new Actividades("aerobic", 35, 35.70f, new Horario("M,J", 18, 19));
        //Artes Marciales
        tipo[6] = new Actividades("artes marciales", 15, 45.00f, new Horario("L,X,V", 19, 20));
        tipo[7] = new Actividades("artes marciales", 15, 34.00f, new Horario("M,J", 18, 19));
        tipo[8] = new Actividades("artes marciales", 15, 34.00f, new Horario("M,J", 19, 20));
        //Natacion
        tipo[9] = new Actividades("natacion", 35, 47.60f, new Horario("L,X,V", 18, 19));
        tipo[10] = new Actividades("natacion", 35, 35.70f, new Horario("M,J", 17, 18));
        System.out.println("precio" + tipo[1].getTipo());//imprime el tipo
    } 
    public void darAltaAlumno(Scanner sc) {
        String nombre;
        String apellido;
        
        // pedir nombre y apellidos por teclado
        System.out.println("Introduzca el nombre del alumno");
        nombre = sc.nextLine();
        System.out.println("Introduzca el apellido del alumno");
        apellido = sc.nextLine();
        //crear el alumno
        Alumno daralta = new Alumno(nombre, apellido);
        System.out.println("El alumno introducido es " + daralta.getNombre() + " - " + daralta.getApellido());
        //devolver alumno
        alumnos[numAlumnos]=daralta;
        numAlumnos++;
       
    }
        public  void darBajaAlumno(Scanner sc) {
        //encontrar Alumno
        String nombre;
        String apellido;
        int darbaja;
        System.out.println("Introduzca el nombre del alumno");
        nombre = sc.nextLine();
        System.out.println("Introduzca el apellido del alumno");
        apellido = sc.nextLine();
        //Dar de baja de las actividades, aumentar plaza//PROXIMAMENTE
        //reordenar array para no dejar huecos
        darbaja = encontrarAlumno(alumnos, nombre, apellido, numAlumnos);
        alumnos[darbaja] = null;
        alumnos[darbaja] = alumnos[numAlumnos - 1];
        alumnos[numAlumnos - 1] = null;
        numAlumnos--;
    }

    private  int encontrarAlumno(Alumno[] alumnos, String nombre, String apellido, int numAlumnos) {
        int posicion = -1;
        Alumno temp = new Alumno(nombre, apellido);
        //recorrer array de alumno buscando nombre y apellidos
        for (int i = 0; i < numAlumnos ||posicion==-1; i++) {
            if (alumnos[i].equals(temp)) {
                posicion = i;
            } else {
                System.out.println("No existe ese alumno");
            }
        }
        return posicion;
    }
    // alumnos[i].getNombre().equals(nombre) && 
    // alumnos[i].getApellidos().equals(apellidos)
    //alumnos[i].equals(temp) sustituye a todo lo de arriba al colocarlo en una variable
    public  void matricularAlumno(Scanner sc) {
        //pedir alumno
        String nombre;
        String apellido;
        System.out.println("Introduzca el nombre del alumno");
        nombre = sc.nextLine();
        System.out.println("Introduzca el apellido del alumno");
        apellido = sc.nextLine();
        //encontrarle en el array
        int matricular;
        matricular=encontrarAlumno(alumnos, nombre, apellido,numAlumnos);
        //encontrar actividad
        
        for (int i = 0; i < tipo.length; i++) {
            System.out.println("Las actividades son");
            System.out.println(tipo[i].getTipo());
        }
        Alumno alumnote = new Alumno(nombre, apellido);
        
            int actividad=sc.nextInt();
                           sc.nextLine();
            tipo[actividad].addAlumno(alumnote);
        //quitar plaza
        // aumentar el dinero del alumno
    }
}

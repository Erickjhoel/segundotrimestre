/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;

import clases.Actividad;
import clases.Alumno;
import clases.Horario;
import java.util.Scanner;

/**
 *
 * @author daw
 */
public class Poo {

    private Actividad[] tipo = new Actividad[11];
    private Alumno[] alumnos = new Alumno[50];
    int numAlumnos = 0;

    public Poo() {
        tipo[0] = new Actividad("aerobic", 35, 47.60f, new Horario("L,X,V", 10, 11));//da valores
        tipo[1] = new Actividad("aerobic", 35, 47.60f, new Horario("L,X,V", 11, 12));
        tipo[2] = new Actividad("aerobic", 35, 47.60f, new Horario("L,X,V", 19, 20));
        tipo[3] = new Actividad("aerobic", 35, 35.70f, new Horario("M,J", 9, 10));
        tipo[4] = new Actividad("aerobic", 35, 35.70f, new Horario("M,J", 10, 11));
        tipo[5] = new Actividad("aerobic", 35, 35.70f, new Horario("M,J", 18, 19));
        //Artes Marciales
        tipo[6] = new Actividad("artes marciales", 15, 45.00f, new Horario("L,X,V", 19, 20));
        tipo[7] = new Actividad("artes marciales", 15, 34.00f, new Horario("M,J", 18, 19));
        tipo[8] = new Actividad("artes marciales", 15, 34.00f, new Horario("M,J", 19, 20));
        //Natacion
        tipo[9] = new Actividad("natacion", 35, 47.60f, new Horario("L,X,V", 18, 19));
        tipo[10] = new Actividad("natacion", 35, 35.70f, new Horario("M,J", 17, 18));
        //System.out.println("precio" + tipo[1].getTipo());//imprime el tipo
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
        alumnos[numAlumnos] = daralta;
        numAlumnos++;
    }

    public void darBajaAlumno(Scanner sc) {
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

    private int encontrarAlumno(Alumno[] alumnos, String nombre, String apellido, int numAlumnos) {
        int posicion = -1;
        Alumno temp = new Alumno(nombre, apellido);
        //recorrer array de alumno buscando nombre y apellidos
        for (int i = 0; i < numAlumnos || posicion == -1; i++) {
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
    public void matricularAlumno(Scanner sc) {
        //pedir alumno
        String nombre;
        String apellido;
        System.out.println("Introduzca el nombre del alumno");
        nombre = sc.nextLine();
        System.out.println("Introduzca el apellido del alumno");
        apellido = sc.nextLine();
        //encontrarle en el array
        int posicionalumno;
        posicionalumno = encontrarAlumno(alumnos, nombre, apellido, numAlumnos);
        //encontrar actividad
        int actividad;
        if (posicionalumno > -1) {
            imprimiractividades();
        }//añadir el alumno a la actividad
        Alumno alumnote = new Alumno(nombre, apellido);
        System.out.println("Seleccione una actividad de 0-10");
        actividad = sc.nextInt();
        sc.nextLine();
        tipo[actividad].addAlumno(alumnote);
        //añadir el precio de la actividad en la que el alumno se matriculo
        float preciamen = tipo[actividad].addprecio();
        alumnos[posicionalumno].addprecioalum(preciamen);
    }

    public void imprimiractividades() {
        System.out.println("Las actividades son");
        for (int i = 0; i < tipo.length; i++) {
            System.out.print(i + " " + tipo[i].getTipo());
            System.out.print(" " + tipo[i].getPrecio());
            System.out.println("");
        }
    }

    public void imprimiralumnos() {
        System.out.println("Los alumnos son");
        for (int i = 0; i < alumnos.length; i++) {
            System.out.print(i + " " + alumnos[i].getNombre());
            System.out.print(" " + alumnos[i].getApellido());
            System.out.println("");
        }
    }

    public void reciboalum(Scanner sc) {
        String nombre;
        String apellido;
        System.out.println("Introduzca el nombre del alumno");
        nombre = sc.nextLine();
        System.out.println("Introduzca el apellido del alumno");
        apellido = sc.nextLine();
        //encontrarle en el array
        int encontrar;
        encontrar = encontrarAlumno(alumnos, nombre, apellido, numAlumnos);
        if (encontrar > -1) {
            System.out.println("El ");
            System.out.println(alumnos[encontrar].getPagames());
        }
    }

    public void horario() {
        System.out.println("Los horarios de las actividades son");
        for (int i = 0; i < tipo.length; i++) {
            System.out.println(tipo[i].getHorario());
        }
    }
    
    public void reciboactividades(Scanner sc) {
        int seleccion;
        imprimiractividades();
        System.out.println("Seleccione la actividad de la que quiere saber el precio");
        seleccion = sc.nextInt();
        sc.nextLine();
        System.out.println(tipo[seleccion].getPrecio());
    }
}

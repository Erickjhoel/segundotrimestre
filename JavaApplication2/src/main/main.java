/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import javaapplication2.Poo;
import java.util.Scanner;

/**
 *
 * @author daw
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        Poo polideportivo = new Poo();
        Scanner sc = new Scanner(System.in);
        boolean salir = false;
        do {
            System.out.println("Elije el numero de ejercicio del 1 al 17, los enunciados son:\n"
                    + "1. Dar Alta. \n"
                    + "2. Baja Alumno \n"
                    + "3. Matricular Alumno \n"
                    + "4. Recibo Alumno \n"
                    + "5 Salir \n");
            int opcion = sc.nextInt();
            sc.nextLine();
            switch (opcion) {
                case 1:
                    polideportivo.darAltaAlumno(sc);
                    break;
                case 2:
                    polideportivo.darBajaAlumno(sc);
                    break;
                case 3:
                    polideportivo.matricularAlumno(sc);
                    break;
                case 4:
                    polideportivo.matricularAlumno(sc);
                    break;
                case 6:
                    salir = true;
                    break;
                default:
                    System.out.println("opcion no valida");
            }
        } while (!salir);

    }
}
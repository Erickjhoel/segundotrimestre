/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import funcionalidad.Funcionalidad;
import java.util.Scanner;

/**
 *
 * @author daw
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Funcionalidad funcionalidad = new Funcionalidad();
        boolean salir = false;
        do {
            Scanner sc = new Scanner(System.in);
            System.out.println("Elije el numero de ejercicio del 1 al 17, los enunciados son:\n"
                    + "1. Dar Alta libros. \n"
                    + "2. Dar de alta usuarios \n"
                    + "3. Dar de baja usuarios \n"
                    + "4. Prestar un libro/revista \n"
                    + "5. Devolver un libro \n"
                    + "6. Listado de libros \n"
                    + "7. Listado de usuarios \n"
                    + "8. Salir \n");
            int opcion = sc.nextInt();
            sc.nextLine();
            switch (opcion) {
                case 1: funcionalidad.darAltaLibro(sc);
                    break;
                case 2: funcionalidad.darAltaUsuario(sc);
                    break;
                case 3: funcionalidad.darBajaUsuario(sc);
                    break;
                case 4: funcionalidad.prestarLibro(sc);
                    break;
                case 5: funcionalidad.devolverLibro(sc);
                    break;
                case 6:funcionalidad.listadolibros();
                    break;
                case 7:funcionalidad.listadousuarios();
                    break;
                case 8:
                    salir = true;
                    break;
                default:
                    System.out.println("Opcion no valida");
            }
        } while (!salir);

    }
}

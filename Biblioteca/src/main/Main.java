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
                    + "7. Listado de revistas \n"
                    + "8. Listado de usuarios \n"
                    + "9. Salir \n");
            int opcion = sc.nextInt();
            sc.nextLine();
            switch (opcion) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    break;
                case 9:
                    salir = true;
                    break;
                default:
                    System.out.println("Opcion no valida");
            }
        } while (!salir);

    }
}

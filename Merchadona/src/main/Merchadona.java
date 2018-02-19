/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.Scanner;

/**
 *
 * @author daw
 */
public class Merchadona {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    boolean salir = false;
        do {
            Scanner sc = new Scanner(System.in);
            System.out.println("Seleccione:\n"
                    + "1. Comprobar vehiculo \n"
                    + "2. Dar de alta usuarios \n"
                    + "3. Dar de baja usuarios \n"
                    + "4. Prestar un libro/revista \n"
                    + "5. Devolver un libro \n");
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
                    salir = true;
                    break;
                default:
                    System.out.println("Opcion no valida");
            }
        } while (!salir);

    }
}

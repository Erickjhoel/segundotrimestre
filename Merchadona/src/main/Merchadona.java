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
                    + "1. Introducir usuario \n"
                    + "2. Salir \n");
            int opcion = sc.nextInt();
            sc.nextLine();
            switch (opcion) {
                case 1:
                    System.out.println("Seleccione:\n"
                            + "1. Cajero \n"
                            + "2. Reponedor \n");
                    int opcion2 = sc.nextInt();
                    sc.nextLine();
                    switch (opcion) {
                        case 1:
                            break;
                        case 2:
                            salir = true;
                            break;
                        default:
                            System.out.println("Opcion no valida");
                    }
                    break;
                case 2:
                    salir = true;
                    break;
                default:
                    System.out.println("Opcion no valida");
            }
        } while (!salir);

    }
}

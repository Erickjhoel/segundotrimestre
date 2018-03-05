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
 * @author A
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    Funcionalidad funcionalidad = new Funcionalidad();
        boolean salir = false;
        do {
            Scanner sc = new Scanner(System.in);
            System.out.println("Seleccione:\n"
                    + "1. Realizar mision \n"
                    + "2. Descanzo de recursos \n"
                    + "3.Salir");
            int opcion = sc.nextInt();
            sc.nextLine();
            switch (opcion) {
                case 1:
                    
                    break;
                case 2:
                    
                    break;
                case 3:
                    salir = true;
                    break;
                default:
                    System.out.println("Opcion no valida");
            }
        } while (!salir);

    }
}

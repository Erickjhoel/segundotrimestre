/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.Scanner;
import funcionalidad.Funcionalidad;

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
            System.out.println("Seleccione:\n"
                    + "1. Añadir un campeonato \n"
                    + "2. Ranking \n"
                    + "3. Listado de campeonatos con jugadores y sus posiciones \n"
                    + "4.Salir");
            int opcion = sc.nextInt();
            sc.nextLine();
            switch (opcion) {
                case 1:
                    System.out.println("Seleccione de que es el campeonato:\n"
                            + "1. CSGO  \n"
                            + "2. ClasRoyal \n"
                            + "4. LOL");
                    int opcion2 = sc.nextInt();
                    sc.nextLine();
                    switch (opcion) {
                        case 1:funcionalidad.campeonatoCSGO();
                            break;
                        case 2:funcionalidad.campeonatoLOL();
                            break;
                        case 3:funcionalidad.campeonatoCR();
                            break;
                            default:System.out.println("");
                    }
                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:
                    salir = true;
                    break;
                default:
                    System.out.println("Opcion no valida");
            }
        } while (!salir);

        // TODO code application logic here
    }

}

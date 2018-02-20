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
public class main {

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
                    + "1. Comprobar vehiculo \n"
                    + "2. Vender Vehiculo \n"
                    + "3. Facturacion de la empresa \n"
                    + "4. Probar vehiculo \n"
                    + "5.Salir");
            int opcion = sc.nextInt();
            sc.nextLine();
            switch (opcion) {
                case 1:
                    funcionalidad.comprar();
                    break;
                case 2:
                    funcionalidad.vender();
                    break;
                case 3:
                    funcionalidad.facturacion();
                    break;
                case 4:funcionalidad.probar();
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

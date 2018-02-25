/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import clases.Constante;
import clases.Reponedor;
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
        // TODO code application logic here
        Funcionalidad funcionalidad = new Funcionalidad();
        boolean salir = false;
        do {
            Scanner sc = new Scanner(System.in);
            System.out.println("Introduzca una ID");
            int ID = sc.nextInt();
            sc.nextLine();

            if (ID == Constante.ADMIN_ID) {
                System.out.println("ADMINISTRADOR");
                System.out.println("Seleccione:\n"
                        + "1. Dar alta empleado\n"
                        + "2. Dar alta productos\n"
                        + "3. Dar baja empleado\n"
                        + "4. Dar baja productos\n");
                int opcionAdmin = sc.nextInt();
                sc.nextLine();
                switch (opcionAdmin) {
                    case 1:
                        funcionalidad.daraltaempleado();
                        break;
                    case 2:
                        funcionalidad.daraltaproducto();
                        break;
                    case 3:
                        funcionalidad.darbajaempleado();
                        break;
                    case 4:
                        funcionalidad.darbajaproducto();
                        break;
                    default:
                        System.out.println("Opcion no valida");
                }

            } else {
                funcionalidad.reponedorocajero(ID);
            }
        } while (!salir);

    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funcionalidad;

import clases.Cajero;
import clases.Empleado;
import clases.Producto;
import clases.Reponedor;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author daw
 */
public class Funcionalidad {

    Scanner sc = new Scanner(System.in);
    Map<Integer, Empleado> empleados = new LinkedHashMap<>();//integer es igual al INT
    private ArrayList<Producto> productos = new ArrayList<>();//los productos tienen una cantidad en stock,que se va restando,(no hace falta array stock)

    public Funcionalidad() {
        Cajero cajero1 = new Cajero("Pepe", 2);
        empleados.put(cajero1.getID(), cajero1);
        Reponedor reponedor1 = new Reponedor("Juan", 3);
        empleados.put(reponedor1.getID(), reponedor1);
    }

    public void daraltaempleado() {
        System.out.println("Introduzca que tipo de empleado va a dar de alta:\n"
                + "1. Cajero\n"
                + "2. Reponedor\n");
        int puesto = sc.nextInt();
        sc.nextLine();
        switch (puesto) {
            case 1:
                String nombre;
                System.out.println("Introduce el nombre del nuevo empleado");
                nombre = sc.nextLine();
                sc.nextInt();
                Integer ID;
                System.out.println("Introduce el ID del nuevo empleado");
                ID = sc.nextInt();
                Cajero nuevocajero = new Cajero(nombre, ID);
                empleados.put(nuevocajero.getID(), nuevocajero);
                break;
            case 2:
                String nombre2;
                System.out.println("Introduce el nombre del nuevo empleado");
                nombre2 = sc.nextLine();
                sc.nextInt();
                Integer ID2;
                System.out.println("Introduce el ID del nuevo empleado");
                ID2 = sc.nextInt();
                Reponedor nuevoreponedor = new Reponedor(nombre2, ID2);
                empleados.put(nuevoreponedor.getID(), nuevoreponedor);
                break;
            default:
                System.out.println("Opcion no valida");
        }
    }

    public void daraltaproducto() {/////////Falta la verga esa de la fecha
        String nombre;
        System.out.println("Introduzca el nombre del producto");
        nombre = sc.nextLine();
        sc.nextInt();
        double precio;
        System.out.println("introduzca el precio del producto");
        precio = sc.nextInt();
        int cantidad;
        System.out.println("Introduzca la cantidad de productos");
        cantidad = sc.nextInt();
        int seleccion;
        System.out.println("Selecciona si el producto es:\n"
                + "1. Perecedero\n"
                + "2. No Perecedero");
        seleccion = sc.nextInt();
        if (seleccion == 1) {
            LocalTime fechareposicion;
            System.out.println("Fecha de reposicion?:");
        } else {
            Producto nuevoproducto= new Producto(nombre, precio, cantidad);
            productos.add(nuevoproducto);
        }
    }

    public void reponedorocajero(int ID) {
        Empleado a = empleados.get(ID);
        if (a instanceof Cajero) {
            cajero();
        } else {
            reponedor();
        }

    }

    public void reponedor() {
        System.out.println("Seleccione:\n"
                    + "1. Reponer productos\n"
                    + "3. Ver lista de los que quedan en stock\n");
            int opcionAdmin = sc.nextInt();
            sc.nextLine();
            switch (opcionAdmin) {
                case 1:
                    break;
                case 2:
                    break;
                default:
                    System.out.println("Opcion no valida");
            }
    }

    public void cajero() {

    }

}

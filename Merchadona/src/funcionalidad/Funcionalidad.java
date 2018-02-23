/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funcionalidad;

import clases.Cajero;
import clases.Empleado;
import clases.Perecedero;
import clases.Producto;
import clases.Reponedor;
import java.time.Duration;
import java.time.LocalDateTime;
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
    private Map<Integer, Empleado> empleados = new LinkedHashMap<>();//integer es igual al INT
    private ArrayList<Producto> productos = new ArrayList<>();//los productos tienen una cantidad en stock,que se va restando,(no hace falta array stock)

    public Funcionalidad() {
        Cajero cajero1 = new Cajero("Pepe", 2);
        empleados.put(cajero1.getID(), cajero1);
        Reponedor reponedor1 = new Reponedor("Juan", 3);
        empleados.put(reponedor1.getID(), reponedor1);
        Producto producto1 = new Producto("Platano", 10, 8);
        productos.add(producto1);
        Perecedero perecedero1 = new Perecedero(LocalTime.now(), "Yogurt", 10, 8);
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

    public void darbajaempleado() {
        Integer ID;
        System.out.println("Introduce el ID delempleado");
        ID = sc.nextInt();
        //Aunque no lo parezca esta pendejada funciona
        empleados.remove(ID);
    }

    public void daraltaproducto() {
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
            Perecedero nuevoproducto = new Perecedero(LocalTime.now(), nombre, precio, cantidad);
            productos.add(nuevoproducto);
        } else {
            Producto nuevoproducto = new Producto(nombre, precio, cantidad);
            productos.add(nuevoproducto);
        }
    }

    public void darbajaproducto() {

        for (Producto vender : productos) {
            System.out.println(productos.toString() + "--" + productos.indexOf(vender));
        }
        int posicion;
        System.out.println("elija el vehiculo que quiere vender");
        posicion = sc.nextInt();
        sc.nextLine();
        productos.remove(productos.get(posicion));

    }

    public void reponedorocajero(int ID) {
        Empleado a = empleados.get(ID);
        if (a instanceof Cajero) {
            System.out.println("El ID del usuario corresponde a un cajero");
            for (Producto vender : productos) {
                System.out.println(productos.indexOf(vender));
            }
            double precioproducto;
            int elegir;
            System.out.println("Elija el producto que quiere vender");
            elegir = sc.nextInt();
            precioproducto = productos.get(elegir).getPrecioBase();//sacar el precio de el producto
            int cantidad;
            System.out.println("cuantas cantidades del producto quierer vender");
            cantidad = sc.nextInt();

            for (Producto vender : productos) {
                if (productos.get(elegir)instanceof Perecedero) {
                    LocalDateTime cajero = LocalDateTime.now();
                    Duration d = Duration.between(reponedor, cajero);
                    
                    if (cantidad < productos.get(elegir).getCantidadStock()) {//si la cantidad es menor que el la cantidad en stock del producto
                        precioproducto = precioproducto * cantidad;
                        Cajero c = (Cajero) a;
                        c.setPreciototal(c.getPreciototal() + precioproducto);//el precio total del cajero + el precio  del producto
                        //conel set se mete directamente en la clase
                    }

                }else if  
                        
                (cantidad < productos.get(elegir).getCantidadStock()) {//si la cantidad es menor que el la cantidad en stock del producto
                precioproducto = precioproducto * cantidad;
                Cajero c = (Cajero) a;
                c.setPreciototal(c.getPreciototal() + precioproducto);//el precio total del cajero + el precio  del producto
                //conel set se mete directamente en la clase

            }
            }
            
        } else {
            reponedor();
        }

    }
    
    public void reponedor() {
        System.out.println("El ID del usuario corresponde a un reponedor");
        System.out.println("Seleccione:\n"
                + "1. Reponer productos\n"
                + "3. Ver lista de los que quedan en stock\n");
        int opcionAdmin = sc.nextInt();
        sc.nextLine();
        switch (opcionAdmin) {

            case 1:
                for (Producto vender : productos) {
                    System.out.println(productos.indexOf(vender));
                }
                int cantidadStock;
                int elegir;
                System.out.println("Elija cuantos quiere añadir");
                cantidadStock = sc.nextInt();
                System.out.println("Elija el producto que quiere reponer");
                elegir = sc.nextInt();
                Producto a = productos.get(elegir);//se elige el producto
                for (Producto comprobar : productos) { //rrecorre el array de productos
                    if (a instanceof Perecedero) {// comprueba si el producto elegido es perecedero
                        Perecedero c = (Perecedero) a;// para poder llegar a los campos de perecedero
                        c.setFechareposicion(LocalTime.now());
                        c.setCantidadStock(cantidadStock + c.getCantidadStock());
                        LocalDateTime reponedorperecedero = LocalDateTime.now();
                    } else {
                        Producto c = (Producto) a;
                        c.setCantidadStock(cantidadStock + c.getCantidadStock());
                        LocalDateTime reponedor = LocalDateTime.now();
                    }
                }
                break;
            case 2:
                break;
            default:
                System.out.println("Opcion no valida");
        }
    }

}

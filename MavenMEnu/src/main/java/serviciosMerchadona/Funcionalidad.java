/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serviciosMerchadona;

import constantesMerchadona.Constante;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import modeloMerchadona.Cajero;
import modeloMerchadona.Empleado;
import modeloMerchadona.Perecedero;
import modeloMerchadona.Producto;
import modeloMerchadona.Reponedor;

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
        Perecedero perecedero1 = new Perecedero(LocalDateTime.now(), "Yogurt", 10, 8);
    }

    public boolean daraltaempleado(int puesto, String nombre, Integer ID) {
        boolean altaOK = false;
        if (empleados.get(ID) == null) {
            switch (puesto) {
                case 1:
                    Cajero nuevocajero = new Cajero(nombre, ID);
                    empleados.put(nuevocajero.getID(), nuevocajero);
                    break;
                case 2:

                    Reponedor nuevoreponedor = new Reponedor(nombre, ID);
                    empleados.put(nuevoreponedor.getID(), nuevoreponedor);
                    break;
            }
            altaOK=true;
        }
        return altaOK;
    }

    public boolean darbajaempleado(Integer ID) {
        boolean darbaja=false;
        if (empleados.get(ID)!= null){
        empleados.remove(ID);
        darbaja=true;
        }
        
        return darbaja;
    }

    public boolean daraltaproducto(String nombre, double precio,int cantidad,int seleccion) {//que verga devuelve
        boolean daraltaprod=false;
        if (seleccion == 1) {//si el producto es perecedero
            Perecedero nuevoproducto = new Perecedero(LocalDateTime.now(), nombre, precio, cantidad);
            productos.add(nuevoproducto);
            daraltaprod=true;
        } else {
            Producto nuevoproducto = new Producto(nombre, precio, cantidad);
            productos.add(nuevoproducto);
            daraltaprod=true;
        }
        return daraltaprod;
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
                System.out.println(vender + "---" + productos.indexOf(vender));
            }
            double precioproducto;
            int elegir;
            System.out.println("Elija el producto que quiere vender");
            elegir = sc.nextInt();
            sc.nextLine();
            precioproducto = productos.get(elegir).getPrecioBase();//sacar el precio de el producto
            int cantidad;
            System.out.println("cuantas cantidades del producto quierer vender");
            cantidad = sc.nextInt();
            sc.nextLine();

            for (Producto vender : productos) {
                if (productos.get(elegir) instanceof Perecedero) {
                    LocalDateTime cajero = LocalDateTime.now();
                    System.out.println("Pulse enter para ver el descuento y el precio del producto");
                    sc.nextLine();
                    LocalDateTime reponedor = LocalDateTime.now();

                    Duration duracion = Duration.between(reponedor, cajero);
                    long segundos = duracion.getSeconds();
                    System.out.println("Seg pasados son " + segundos);
                    double descuento = segundos / Constante.NUM_SEGUNDOS_BAJA_PRECIO * Constante.FACTOR_BAJA_PRECIO * precioproducto;

                    if (cantidad < productos.get(elegir).getCantidadStock() && segundos < Constante.NUM_SEGUNDOS_CADUCA) {//si la cantidad
                        //es menor que el la cantidad en stock del producto
                        precioproducto = precioproducto * cantidad - descuento;
                        Cajero c = (Cajero) a;
                        c.setPreciototal(c.getPreciototal() + precioproducto);//el precio total del cajero + el precio  del producto
                        //conel set se mete directamente en la clase
                        System.out.println("El precio del produccto es" + precioproducto);

                    } else if (segundos > Constante.NUM_SEGUNDOS_CADUCA) {
                        System.out.println("El producto a caducado wee");

                    } else if (cantidad > productos.get(elegir).getCantidadStock()) {
                        System.out.println("No hay tantos productos");
                    }

                } else if (cantidad < productos.get(elegir).getCantidadStock()) {//si la cantidad es menor que el la cantidad en stock del producto
                    precioproducto = precioproducto * cantidad;
                    Cajero c = (Cajero) a;
                    c.setPreciototal(c.getPreciototal() + precioproducto);//el precio total del cajero + el precio  del producto
                    //conel set se mete directamente en la clase
                    System.out.println("El precio del produccto es" + precioproducto);
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
                + "2. Ver lista de los que quedan en stock\n");
        int opcionAdmin = sc.nextInt();
        sc.nextLine();
        switch (opcionAdmin) {

            case 1:
                for (Producto vender : productos) {
                    System.out.println(productos + "---" + productos.indexOf(vender));
                }
                int cantidadStock;
                int elegir;
                System.out.println("Elija cuantos quiere añadir");
                cantidadStock = sc.nextInt();
                sc.nextLine();
                System.out.println("Elija el producto que quiere reponer");
                elegir = sc.nextInt();
                sc.nextLine();
                Producto a = productos.get(elegir);//se elige el producto
                for (Producto comprobar : productos) { //rrecorre el array de productos
                    if (a instanceof Perecedero) {// comprueba si el producto elegido es perecedero
                        Perecedero c = (Perecedero) a;// para poder llegar a los campos de perecedero
                        c.setFechareposicion(LocalDateTime.now());
                        c.setCantidadStock(cantidadStock + c.getCantidadStock());
                    } else {
                        Producto c = (Producto) a;
                        c.setCantidadStock(cantidadStock + c.getCantidadStock());
                    }
                }
                break;
            case 2:
                for (Producto cantidades : productos) {
                    System.out.println(cantidades.getNombre() + "---" + cantidades.getCantidadStock());
                }

                break;
            default:
                System.out.println("Opcion no valida");
        }
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serviciosMerchadona;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import constantesMerchadona.Constante;
import modeloMerchadona.Cajera;
import modeloMerchadona.Cajera;
import modeloMerchadona.Empleado;
import modeloMerchadona.Perecedero;
import modeloMerchadona.Producto;
import modeloMerchadona.Reponedor;

/**
 *
 * @author daw
 */
public class Merchadona {

    Scanner sc = new Scanner(System.in);
    Map<Integer, Empleado> empleados = new LinkedHashMap<>();
    ArrayList<Producto> productos = new ArrayList<>();

    public Merchadona() {

        Empleado victor = new Reponedor("Victor", 1235);
        Empleado alvaro = new Cajera("Alvaro", 1234);
        Producto chocolate = new Producto("Chocolate", 2.34);
        Producto carne = new Producto("carne", 0);
        Producto leche = new Perecedero(LocalDateTime.now(), "Leche", 5.2);
        Producto latas = new Producto("Latas", 3.4);

        empleados.put(victor.getId_empleado(), victor);
        empleados.put(alvaro.getId_empleado(), alvaro);
        productos.add(leche);
        productos.add(chocolate);
        productos.add(carne);
        productos.add(latas);

    }

    public List<Perecedero> listaProductosPerecederos() {
        ArrayList<Perecedero> perecederos = new ArrayList<>();
        for (Producto perecedero : productos) {
            if (perecedero instanceof Perecedero) {
                perecederos.add((Perecedero) perecedero);
            }
        }
        return perecederos;
    }

    public List<Producto> listaProductos() {
        ArrayList<Producto> productoslist = new ArrayList<>();
        for (Producto producto : productos) {
            if (producto instanceof Perecedero) {
                //si es perecedero no hace nah
            } else {
                productoslist.add((Producto) producto);
            }
        }
        return productoslist;
    }

    public List<Producto> listaProductos2() {

        return productos;
    }

    public int tipoEmpleado(int id) {
        int tipo = 0;

        if (id == Constante.ADMIN_ID) {
            tipo = 1;
        } else if (empleados.get(id) instanceof Cajera) {
            tipo = 2;
        } else if (empleados.get(id) instanceof Reponedor) {
            tipo = 3;
        }
        return tipo;
    }

    public boolean darAltaEmpleado(String nombre, int id, int opcion) {
        boolean altaOK = false;
        if (empleados.get(id) == null) {
            switch (opcion) {
                case 1:
                    empleados.put(id, new Cajera(nombre, id));
                    break;
                case 2:
                    empleados.put(id, new Reponedor(nombre, id));
                    break;

            }
            altaOK = true;
        }
        return altaOK;
    }

    public boolean darAltaProducto(String nombre, double precio, int opcion) {

        boolean comprobar = false;

        switch (opcion) {
            case 1:
                productos.add(new Producto(nombre, precio));
                comprobar = true;
                break;
            case 2:
                productos.add(new Perecedero(LocalDateTime.MIN, nombre, precio));
                comprobar = true;
                break;
        }
        return comprobar;
    }

    public boolean darBajaEmpleado(int id) {
        boolean ok;

        empleados.remove(id);
        ok = true;
        return ok;
    }

    public boolean darBajaProducto(String nombre) {///esto hay q cambiarlo
        boolean ok=false;
        
        for (int i = 0; i < productos.size(); i++) {
            if (productos.get(i).getNombre().equalsIgnoreCase(nombre)) {
                productos.remove(i);
               ok = true; 
            }

            
        }return ok;
    }

    

    public List<Cajera> listaCajeras() {
        ArrayList<Cajera> cajeras = new ArrayList<>();
        for (Empleado empleado1 : empleados.values()) {
            if (empleado1 instanceof Cajera) {
                cajeras.add((Cajera) empleado1);
            }
        }
        return cajeras;
    }

    public List<Reponedor> listaReponedor() {
        ArrayList<Reponedor> reponedor = new ArrayList<>();
        for (Empleado empleado2 : empleados.values()) {
            if (empleado2 instanceof Reponedor) {
                reponedor.add((Reponedor) empleado2);
            }
        }
        return reponedor;
    }

    public void imprimirProductos() {
        int contador = 0;
        for (Producto producto1 : productos) {
            System.out.println("-" + contador + ". " + producto1);
            contador++;
        }
    }

    public void reponerProducto(int id, int cantidad, Producto producto) {
        int totalRepos = ((Reponedor) empleados.get(id)).getNum_reposiciones();
        producto.setStock(producto.getStock() + cantidad);
        totalRepos = totalRepos + cantidad;
        ((Reponedor) empleados.get(id)).setNum_reposiciones(totalRepos);
        if (producto instanceof Perecedero) {
            Producto a = producto;
            Perecedero perecedero = (Perecedero) a;
            perecedero.setFecha_reposicion(LocalDateTime.now());
        }
    }

    private double caducacion(Producto producto) {
        LocalDateTime reposicion = ((Perecedero) producto).getFecha_reposicion();
        LocalDateTime actual = LocalDateTime.now();
        Duration d = Duration.between(reposicion, actual);
        long segundos = d.getSeconds();
        double precioBase = producto.getPrecio_base();
        //System.out.println("Han pasado " + segundos + " segundos");
        double descuento = segundos / Constante.NUM_SEGUNDOS_BAJA_PRECIO * Constante.FACTOR_BAJA_PRECIO * precioBase;
        double precioFinal;
        if (segundos > Constante.NUM_SEGUNDOS_CADUCA) {
            //System.out.println("El producto esta caducado no es posible su venta");
            precioFinal = -1;
        } else {
            precioFinal = precioBase - descuento;
            // System.out.println("El precio a pagar por unidad es : " + precioFinal);
        }
        return precioFinal;
    }

    public int venderProducto(int id, int cantidad, Producto producto) {
        int error = 0;
        double total = 0;

        double precioProducto = producto.getPrecio_base();
        if (producto instanceof Perecedero) {
            precioProducto = caducacion(producto);
        }
        if (precioProducto != 0) {

            if (producto.getStock() > cantidad) {
                producto.setStock(producto.getStock() - cantidad);
                total = total + precioProducto * cantidad;
                
            } else {
                error = 1;
            }
        } else {

            error = 2;
        }
        ((Cajera) empleados.get(id)).setPrecio_total_vendidos(total);

        return error;

    }

    public Map<Integer, Empleado> getEmpleados() {
        return empleados;
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }

}

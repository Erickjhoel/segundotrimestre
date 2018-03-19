/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloMerchadona;

/**
 *
 * @author daw
 */
public class Producto {
    private String nombre;
    private double precioBase;
    private int cantidadStock;

    public Producto(String nombre, double precioBase, int cantidadStock) {
        this.nombre = nombre;
        this.precioBase = precioBase;
        this.cantidadStock = cantidadStock;
    }

    
    
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(double precioBase) {
        this.precioBase = precioBase;
    }

    public int getCantidadStock() {
        return cantidadStock;
    }

    public void setCantidadStock(int cantidadStock) {
        this.cantidadStock = cantidadStock;
    }

    @Override
    public String toString() {
        return "Producto{" + "nombre=" + nombre + ", precioBase=" + precioBase + ", cantidadStock=" + cantidadStock + '}';
    }
    
    
    
    
    
    
}

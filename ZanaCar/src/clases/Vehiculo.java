/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

/**
 *
 * @author daw
 */
public class Vehiculo {
    protected String color;
    protected String marca;
    protected double preciocompra;
    protected double precioventa;

    public Vehiculo(String color, String marca, double preciocompra) {
        this.color = color;
        this.marca = marca;
        this.preciocompra = preciocompra;
        this.precioventa = (preciocompra*1.25);
    }

    


    @Override
    public String toString() {
        return "Vehiculo{" + "color=" + color + ", marca=" + marca + ", preciocompra=" + preciocompra + ", precioventa=" + precioventa + '}';
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getPreciocompra() {
        return preciocompra;
    }

    public void setPreciocompra(double preciocompra) {
        this.preciocompra = preciocompra;
    }

    public double getPrecioventa() {
        return precioventa;
    }

    public void setPrecioventa(double precioventa) {
        this.precioventa = precioventa;
    }
    
    
    
    
    
    
    
    
}

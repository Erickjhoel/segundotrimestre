/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.time.LocalTime;

/**
 *
 * @author daw
 */
public class Perecedero extends Producto{
    private LocalTime fechareposicion;

    public Perecedero(LocalTime fechareposicion, String nombre, double precioBase, int cantidadStock) {
        super(nombre, precioBase, cantidadStock);
        this.fechareposicion = fechareposicion;
    }

    @Override
    public String toString() {
        return "Perecedero{" + "fechareposicion=" + fechareposicion +super.toString()+ '}';
    }

    public LocalTime getFechareposicion() {
        return fechareposicion;
    }

    public void setFechareposicion(LocalTime fechareposicion) {
        this.fechareposicion = fechareposicion;
    }
    
    
}

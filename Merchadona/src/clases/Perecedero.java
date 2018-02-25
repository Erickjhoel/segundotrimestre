/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 *
 * @author daw
 */
public class Perecedero extends Producto{
    private LocalDateTime fechareposicion;

    public Perecedero(LocalDateTime fechareposicion, String nombre, double precioBase, int cantidadStock) {
        super(nombre, precioBase, cantidadStock);
        this.fechareposicion = fechareposicion;
    }

    @Override
    public String toString() {
        return "Perecedero{" + "fechareposicion=" + fechareposicion +super.toString()+ '}';
    }

    public LocalDateTime getFechareposicion() {
        return fechareposicion;
    }

    public void setFechareposicion(LocalDateTime fechareposicion) {
        this.fechareposicion = fechareposicion;
    }

    
    
}

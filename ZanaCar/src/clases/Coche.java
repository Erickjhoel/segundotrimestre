/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.util.ArrayList;

/**
 *
 * @author daw
 */
public class Coche extends VehiculoMotor implements interfaz{

    public Coche(String matricula, int kilometros, String color, String marca, double preciocompra) {
        super(matricula, kilometros, color, marca, preciocompra);
    }

    @Override
    public String toString() {
        return "Coche{" +super.toString()+ '}';
    }
    
   
    @Override
    public void añadirkilometros(int maskilometros) {
        kilometros=maskilometros+kilometros;
    }

   
    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public int getKilometros() {
        return kilometros;
    }

    public void setKilometros(int kilometros) {
        this.kilometros = kilometros;
    }

    public String getColor() {
        return color;
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

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
public class VehiculoMotor extends Vehiculo{
    protected String matricula;
    protected int kilometros;

    @Override
    public String toString() {
       super.toString();
        return "VehiculoMotor{" + "matricula=" + matricula + ", kilometros=" + kilometros + '}';
    }

    public VehiculoMotor(String matricula, int kilometros, String color, String marca, double preciocompra) {
        super(color, marca, preciocompra);
    this.matricula=matricula;
    this.kilometros=kilometros;
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

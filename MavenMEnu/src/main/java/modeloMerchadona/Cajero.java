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
public class Cajero extends Empleado {

    private double preciototal;

    public Cajero(String nombre, Integer ID) {
        super(nombre, ID);
    }

    

    public double getPreciototal() {
        return preciototal;
    }

    public void setPreciototal(double preciototal) {
        this.preciototal = preciototal;
    }

}

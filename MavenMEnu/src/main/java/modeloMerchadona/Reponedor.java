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
public class Reponedor extends Empleado{
    private int totalrepuestos;

    public Reponedor(String nombre, Integer ID) {
        super(nombre, ID);
    }

    public int getTotalrepuestos() {
        return totalrepuestos;
    }

    public void setTotalrepuestos(int totalrepuestos) {
        this.totalrepuestos = totalrepuestos;
    }
    
    
}

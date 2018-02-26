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
public class PosicionRatas extends Ratas{
    private ArrayList<String> ratas;
    private int posicion;

    public PosicionRatas(int posicion, int ranking, String nombre, int numTorneoParticipado, String trofeos) {
        super(ranking, nombre, numTorneoParticipado, trofeos);
        this.posicion = posicion;
    }

    

    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }
    
    
    
    
}

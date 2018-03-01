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
public class PosicionRatas{
    private ArrayList<Ratas> ratas;
    private int posicion;

    public PosicionRatas(Ratas a, int posicion) {
        ratas = new ArrayList<>();
        this.posicion = posicion;
        this.ratas.add(a);
    }

   

    

    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }
    
    
    
    
}

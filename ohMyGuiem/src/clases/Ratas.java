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
public abstract class Ratas {
    private int ranking;
    private String nombre;
    private int numTorneoParticipado;
    private ArrayList<String> trofeos;

    public Ratas(int ranking, String nombre, int numTorneoParticipado,String trofeos) {
        this.ranking = ranking;
        this.nombre = nombre;
        this.numTorneoParticipado = numTorneoParticipado;
        this.trofeos = new ArrayList<>();
    }

    

    
    public int getRanking() {
        return ranking;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumTorneoParticipado() {
        return numTorneoParticipado;
    }

    public void setNumTorneoParticipado(int numTorneoParticipado) {
        this.numTorneoParticipado = numTorneoParticipado;
    }

    

    
    
}

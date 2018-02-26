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
public class CSGO extends Ratas{
    private String equipo;
    private int numKills;
    private String mapafavorito;

    public CSGO(String equipo, int numKills, String mapafavorito, int ranking, String nombre, int numTorneoParticipado, String trofeos) {
        super(ranking, nombre, numTorneoParticipado, trofeos);
        this.equipo = equipo;
        this.numKills = numKills;
        this.mapafavorito = mapafavorito;
    }

    

    public String getEquipo() {
        return equipo;
    }

    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }

    public int getNumKills() {
        return numKills;
    }

    public void setNumKills(int numKills) {
        this.numKills = numKills;
    }

    public String getMapafavorito() {
        return mapafavorito;
    }

    public void setMapafavorito(String mapafavorito) {
        this.mapafavorito = mapafavorito;
    }

    

    
    
    
    
    
}

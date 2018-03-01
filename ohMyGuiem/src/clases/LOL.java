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
public class LOL extends Ratas{
    private String linea;
    private String especialidad;

    public LOL(String linea, String especialidad, int ranking, String nombre, int numTorneoParticipado, String trofeos) {
        super(ranking, nombre, numTorneoParticipado, trofeos);
        this.linea = linea;
        this.especialidad = especialidad;
    }

    

    @Override
    public String toString() {
        return "LOL{" + "linea=" + linea + ", especialidad=" + especialidad + super.toString()+'}';
    }
    
}

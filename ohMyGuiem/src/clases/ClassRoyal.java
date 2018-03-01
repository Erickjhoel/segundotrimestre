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
public class ClassRoyal extends Ratas{
//    private ArrayList<ClassRoyal> cartasMazo = new ArrayList<>();
    private String nombreCR;
    private int nivel;

    public ClassRoyal(String nombreCR, int nivel, int ranking, String nombre, int numTorneoParticipado, String trofeos) {
        super(ranking, nombre, numTorneoParticipado, trofeos);
        this.nombreCR = nombreCR;
        this.nivel = nivel;
    }

    
    
}

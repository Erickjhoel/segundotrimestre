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
public abstract class RecursosMilitares {
    private int potenciaMuerte;
    private String nombre;
    private ArrayList<Mision> misionparticipada;

    public RecursosMilitares(int potenciaMuerte, String nombre) {
        this.potenciaMuerte = potenciaMuerte;
        this.nombre = nombre;
        this.misionparticipada = new ArrayList<>();
    }
    
    
    
}

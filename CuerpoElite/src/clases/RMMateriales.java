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
public abstract class RMMateriales extends RecursosMilitares{
    private int nivelHabilidadMinimo;
    private int rangoDeDaño;

    public RMMateriales(int nivelHabilidadMinimo, int rangoDeDaño, int potenciaMuerte, String nombre) {
        super(potenciaMuerte, nombre);
        this.nivelHabilidadMinimo = nivelHabilidadMinimo;
        this.rangoDeDaño = rangoDeDaño;
    }

    
}

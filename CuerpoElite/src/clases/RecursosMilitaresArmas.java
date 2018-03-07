/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.util.ArrayList;

/**
 *
 * @author A
 */
public class RecursosMilitaresArmas extends RMMateriales{
    private int rangoAccion;

    public RecursosMilitaresArmas(int rangoAccion, int nivelHabilidadMinimo, int rangoDeDaño, int potenciaMuerte, String nombre) {
        super(nivelHabilidadMinimo, rangoDeDaño, potenciaMuerte, nombre);
        this.rangoAccion = rangoAccion;
    }

    
}

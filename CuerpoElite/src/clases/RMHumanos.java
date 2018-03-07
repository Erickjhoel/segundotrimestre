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
public class RMHumanos extends RecursosMilitares{
    private int nivelEstres;
    private int numMuertesCuchillo;
    private int nivelHabilidadManejoMaquinas;
    private int nivelExperiencia;

    public RMHumanos(int nivelEstres, int numMuertesCuchillo, int nivelHabilidadManejoMaquinas, int nivelExperiencia, int potenciaMuerte, String nombre) {
        super(potenciaMuerte, nombre);
        this.nivelEstres = nivelEstres;
        this.numMuertesCuchillo = numMuertesCuchillo;
        this.nivelHabilidadManejoMaquinas = nivelHabilidadManejoMaquinas;
        this.nivelExperiencia = nivelExperiencia;
    }

    public int getNivelEstres() {
        return nivelEstres;
    }

    public void setNivelEstres(int nivelEstres) {
        this.nivelEstres = nivelEstres;
    }

    public int getNumMuertesCuchillo() {
        return numMuertesCuchillo;
    }

    public void setNumMuertesCuchillo(int numMuertesCuchillo) {
        this.numMuertesCuchillo = numMuertesCuchillo;
    }

    public int getNivelHabilidadManejoMaquinas() {
        return nivelHabilidadManejoMaquinas;
    }

    public void setNivelHabilidadManejoMaquinas(int nivelHabilidadManejoMaquinas) {
        this.nivelHabilidadManejoMaquinas = nivelHabilidadManejoMaquinas;
    }

    public int getNivelExperiencia() {
        return nivelExperiencia;
    }

    public void setNivelExperiencia(int nivelExperiencia) {
        this.nivelExperiencia = nivelExperiencia;
    }

    
}

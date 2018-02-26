/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author daw
 */
public abstract class Campeonato {
     private LocalDate fecha;
     private String juego;
     private String premio;
     //hacer un haspmap de esta verga

    public Campeonato(LocalDate fecha, String juego, String premio) {
        this.fecha = fecha;
        this.juego = juego;
        this.premio = premio;
    }

    
     
}

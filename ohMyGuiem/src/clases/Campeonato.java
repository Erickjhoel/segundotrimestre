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
public class Campeonato {

    private LocalDate fecha;
    private String juego;
    private String premio;
    private ArrayList<PosicionRatas> posicion;
    //hacer un haspmap de esta verga

    public Campeonato(LocalDate fecha, String juego, String premio) {
        this.fecha = fecha;
        this.juego = juego;
        this.premio = premio;
    }

    public boolean addrata(PosicionRatas a) {
        posicion= new ArrayList<>();
        boolean repetido= false;
        for (PosicionRatas posicionrepetido : posicion) {
            if (posicionrepetido.equals(a)) {
                repetido=true;
                System.out.println("El jugador ya esta dentro del campeonato");
            }
        }
        this.posicion.add(a);
        return repetido;
    }

}

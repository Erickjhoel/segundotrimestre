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
public class Mision {
    private LocalDate fecha;
    private String lugar;
    private int nivelExperienciaGanada;
    private boolean exito;
    private ArrayList<RecursosMilitares> recursos;
    private String tipo;

    public Mision(LocalDate fecha, String lugar, int nivelExperienciaGanada, boolean exito, ArrayList<RecursosMilitares> recursos, String tipo) {
        this.fecha = fecha;
        this.lugar = lugar;
        this.nivelExperienciaGanada = nivelExperienciaGanada;
        this.exito = exito;
        this.recursos = new ArrayList<>();
        this.tipo = tipo;
    }
    
}

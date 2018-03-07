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
 * @author A
 */
public class MisionCombate  extends Mision{
    private int nivelMinimoPotenciaMuerte;

    public MisionCombate(LocalDate fecha, String lugar, int nivelExperienciaGanada, boolean exito, ArrayList<RecursosMilitares> recursos, String tipo) {
        super(fecha, lugar, nivelExperienciaGanada, exito, recursos, tipo);
    }
}

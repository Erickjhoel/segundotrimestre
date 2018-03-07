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
public class Vehiculo extends RMMateriales{
    private int numeropersonasquellevan;

    public Vehiculo(int numeropersonasquellevan, int nivelHabilidadMinimo, int rangoDeDaño, int potenciaMuerte, String nombre) {
        super(nivelHabilidadMinimo, rangoDeDaño, potenciaMuerte, nombre);
        this.numeropersonasquellevan = numeropersonasquellevan;
    }

    public int getNumeropersonasquellevan() {
        return numeropersonasquellevan;
    }

    public void setNumeropersonasquellevan(int numeropersonasquellevan) {
        this.numeropersonasquellevan = numeropersonasquellevan;
    }

   

}

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
public class Horario {
 private String dias;
 private int horainicio;
 private int horafin;

    public Horario(String dias, int horainicio, int horafin) {
        this.dias = dias;
        this.horainicio = horainicio;
        this.horafin = horafin;
    }

    public String getDias() {
        return dias;
    }

    public void setDias(String dias) {
        this.dias = dias;
    }

    public int getMañana() {
        return horainicio;
    }

    public void setMañana(int mañana) {
        this.horainicio = mañana;
    }

    public int getTarde() {
        return horafin;
    }

    public void setTarde(int tarde) {
        this.horafin = tarde;
    }
 
  
 
 
}

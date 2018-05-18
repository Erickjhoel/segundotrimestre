/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author daw
 */
public class Notas {
    private int id_alumnos;
    private int id_asignaturas;
    private int nota;

    public int getId_Alumn() {
        return id_alumnos;
    }

    public void setId_Alumn(int id_Alumn) {
        this.id_alumnos = id_Alumn;
    }

    public int getId_Asign() {
        return id_asignaturas;
    }

    public void setId_Asign(int id_Asign) {
        this.id_asignaturas = id_Asign;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }
    
}

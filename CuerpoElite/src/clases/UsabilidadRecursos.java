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
public class UsabilidadRecursos {

    private String uso;
    private ArrayList<RecursosMilitares> recursos;

    public UsabilidadRecursos(String uso) {
        this.uso = uso;
        this.recursos = new ArrayList<>();
    }

    public void addUso(RecursosMilitares a) {
        this.recursos.add(a);

    }

    public String getUso() {
        return uso;
    }

    public void setUso(String uso) {
        this.uso = uso;
    }

}

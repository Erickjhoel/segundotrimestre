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
public class Actividades {

    private String tipo;
    private int plazas;
    private int plazasdispo;
    private float precio;
    private Horario horario;
    private Alumno[] alumnos;

    public Actividades(String tipo, int plazas, float precio, Horario horario) {
        this.tipo = tipo;
        this.plazas = plazas;
        this.plazasdispo = this.plazas;//se iguala a plaza xque se inicia con el mismo valor
        this.precio = precio;
        this.horario = horario;
        alumnos = new Alumno[this.plazas];

    }

    public boolean addAlumno(Alumno a) {
        boolean ok = false;
        if (plazasdispo > 0) {
            this.alumnos[this.plazas - this.plazasdispo] = a;
            this.plazasdispo--;
            ok = true;
        }
        return ok;
    }

    public float addprecio() {
        float precioact=0;

        precioact = this.precio + precioact;

        return precioact;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getPlazas() {
        return plazas;
    }

    public void setPlazas(int plazas) {
        this.plazas = plazas;
    }

    public int getPlazasdispo() {
        return plazasdispo;
    }

    public void setPlazasdispo(int plazasdispo) {
        this.plazasdispo = plazasdispo;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }

}

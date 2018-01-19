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
public class Alumno {
    private String nombre;
    private String apellido;
    private float pagames;

    
    //no hace falta poner el string de pagames dentro xque
//    es un valor constante que siemprese inicia a 0,todos 
//    los alunmnnos pgames=0 al inicio
    public Alumno(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.pagames=0;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public float getPagames() {
        return pagames;
    }

    public void setPagames(float pagames) {
        this.pagames = pagames;
    }
    
    
    
    
}

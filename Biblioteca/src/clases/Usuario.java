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
public class Usuario {
    private String nombre;
    private Libro[] librpres;

    public Usuario(String nombre) {
        this.nombre = nombre;
    }
    
    public void addlibro(Libro elegirlibro) {
        
    }

    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Usuario{" + "nombre=" + nombre + '}';
    }

    
}

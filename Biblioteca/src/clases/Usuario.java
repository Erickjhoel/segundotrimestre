/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.util.Objects;

/**
 *
 * @author daw
 */
public class Usuario {
    private String nombre;
    private Libro[] librpres;
    private int numerolibrosprestados;

    public Usuario(String nombre) {
        this.nombre = nombre;
         librpres=new Libro[3];
    }
    
    public boolean addlibro(Libro a) {
        boolean ok = false;
        if (numerolibrosprestados< 3){
            this.librpres[this.numerolibrosprestados] = a;
            ok=true;
            numerolibrosprestados++;
        }else
            System.out.println("ya tiene 3 libros prestados");
        return ok;
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
    
    public String librosprestados() {
        for (int i = 0; i < 3; i++) {
            librpres=""
        }
        return "Usuario{" + "nombre=" + nombre + '}';
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.nombre);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Usuario other = (Usuario) obj;
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        return true;
    }

   
    
}

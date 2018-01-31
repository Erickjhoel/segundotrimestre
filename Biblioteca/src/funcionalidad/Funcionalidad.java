/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funcionalidad;

import clases.Biblioteca;
import clases.Libro;
import clases.Usuario;
import java.util.Scanner;

/**
 *
 * @author daw
 */
public class Funcionalidad {

    private Biblioteca[] biblioteca;
    private Libro[] libro = new Libro[10];
    private Usuario[] usuario = new Usuario[10];
    private int numerodelibros=0;
    private int numerodeusuarios=0;
    public Funcionalidad() {
        libro[0] = new Libro("0ete", "El libron0", "Erick0", 300);
        libro[1] = new Libro("1ete", "El libron1", "Erick1", 300);
        libro[2] = new Libro("2ete", "El libron2", "Erick2", 300);
        libro[3] = new Libro("3ete", "El libron3", "Erick3", 300);
        libro[4] = new Libro("4ete", "El libron4", "Erick4", 300);
        libro[5] = new Libro("5ete", "El libron5", "Erick5", 300);
        libro[6] = new Libro("6ete", "El libron6", "Erick6", 300);
        libro[7] = new Libro("7ete", "El libron7", "Erick7", 300);
        libro[8] = new Libro("8ete", "El libron8", "Erick8", 300);
        libro[9] = new Libro("9ete", "El libron9", "Erick9", 300);
    }

    public void darAltaLibro(Scanner sc) {
        String isbn;
        String titulo;
        String autor;
        int numpag;
        // pedir nombre y apellidos por teclado
        System.out.println("Introduzca el Isbn");
        isbn = sc.nextLine();
        System.out.println("Introduzca el Titulo");
        titulo = sc.nextLine();
        System.out.println("Introduzca el autor");
        autor = sc.nextLine();
        System.out.println("Introduzca las paguinas");
        numpag = sc.nextInt();
        sc.nextLine();
        //crear el alumno
        Libro daraltalibro = new Libro(isbn, titulo, autor, numpag);
        System.out.println("El alumno introducido es " + daraltalibro.getIsbn()+ " - " + daraltalibro.getTitulo()
        + " - " + daraltalibro.getAutor()+ " - " + daraltalibro.getNumPaginas());
        //devolver alumno
        libro[numerodelibros]=daraltalibro;
        numerodelibros++;
    }
    public void darAltaUsuario(Scanner sc) {
        String nombre;
        // pedir nombre y apellidos por teclado
        System.out.println("Introduzca el nombre del usuario");
        nombre = sc.nextLine();
        //crear el alumno
        Usuario daraltausuario = new Usuario(nombre);
        System.out.println("El alumno introducido es " + daraltausuario.getNombre());
        //devolver alumno
        usuario[numerodeusuarios]=daraltausuario;
        numerodeusuarios++;
    }
    
}

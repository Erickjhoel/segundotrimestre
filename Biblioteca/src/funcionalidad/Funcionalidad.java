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
    private Libro[] libros = new Libro[10];
    private Usuario[] usuarios = new Usuario[10];
    private int numerodelibros = 0;
    private int numerodeusuarios = 0;

    public Funcionalidad() {
        libros[0] = new Libro("0ete", "El libron0", "Erick0", 300);
        libros[1] = new Libro("1ete", "El libron1", "Erick1", 300);
        libros[2] = new Libro("2ete", "El libron2", "Erick2", 300);
        libros[3] = new Libro("3ete", "El libron3", "Erick3", 300);
        libros[4] = new Libro("4ete", "El libron4", "Erick4", 300);
        libros[5] = new Libro("5ete", "El libron5", "Erick5", 300);
        libros[6] = new Libro("6ete", "El libron6", "Erick6", 300);
        libros[7] = new Libro("7ete", "El libron7", "Erick7", 300);
        libros[8] = new Libro("8ete", "El libron8", "Erick8", 300);
        libros[9] = new Libro("9ete", "El libron9", "Erick9", 300);
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
        System.out.println("El libro introducido es " + daraltalibro.getIsbn() + " - " + daraltalibro.getTitulo()
                + " - " + daraltalibro.getAutor() + " - " + daraltalibro.getNumPaginas());
        //devolver alumno
        libros[numerodelibros] = daraltalibro;
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
        usuarios[numerodeusuarios] = daraltausuario;
        numerodeusuarios++;
    }

    private int encontrarUsuario(Usuario[] usuario, String nombre) {
        int posicion = -1;
        Usuario temp = new Usuario(nombre);
        //recorrer array de alumno buscando nombre y apellidos
        for (int i = 0; i < numerodeusuarios || posicion == -1; i++) {
            if (usuario[i].equals(temp)) {
                posicion = i;
            } else {
                System.out.println("No existe el usuario");
            }
        }
        return posicion;
    }

    public void darBajaUsuario(Scanner sc) {
        String nombre;
        int posicionuser;
        System.out.println("Introduzca el nombre del alumno");
        nombre = sc.nextLine();
        //reordenar array para no dejar huecos
        posicionuser = encontrarUsuario(usuarios, nombre);
        //alumnos[darbaja] = null;//ya no hace falta ponerlo a null xque se machaca con usuario[numerodeusuarios-1]

        usuarios[posicionuser] = null;
        usuarios[posicionuser] = usuarios[numerodeusuarios - 1];
        usuarios[numerodeusuarios - 1] = null;//se iguala a null para que no haya dos con el mismo dato
        numerodeusuarios--;
        //FALTA DEVOLVER LOS LIBROA, HACE FALTA ENCONTRAR EL LIBRO, COMPROBAR SI TIENE LIBROS,PRESTAR LIBROS
    }
    
    public void prestarLibro(Scanner sc) {
        String nombre;
        int posicionuser;
        System.out.println("Introduzca el nombre del alumno");
        nombre = sc.nextLine();
        posicionuser = encontrarUsuario(usuarios, nombre);
        
        int elegirlibro;//se eligue la posicion
        System.out.println("seleccione el libro");
        listadolibros();
        elegirlibro=sc.nextInt();
                    sc.nextLine();
        usuarios[posicionuser].addlibro(libros[elegirlibro]);//se pasa el array xque si paso solo eleguir libro se pasa la poscion
    }
    
    
    public void listadousuarios() {
        System.out.println("Los usuarios son");
        //se coloca numerodewusuarios para que recorra el array el numero de usuarios que haya
        for (int i = 0; i < numerodeusuarios; i++) {
            System.out.print(i + " " + usuarios[i].toString());
            System.out.println("");
        }
    }

    public void listadolibros() {
        System.out.println("Los libros son");
        for (int i = 0; i < numerodelibros; i++) {
            System.out.print(i + " " +libros[i].toString());
            System.out.println("");
        }
    }

}

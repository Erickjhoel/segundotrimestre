/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tresenraya;

import java.util.Scanner;

/**
 *
 * @author user
 */
public class TresEnRaya {

    public static void main(String[] args) {
        char[][] tresenraya = new char[3][3];

        for (int i = 0; i < tresenraya.length; i++) {
            for (int j = 0; j < tresenraya[i].length; j++) {
                tresenraya[j][i] = '-';
            }

        }
        // poner una coordenada
        Scanner sc = new Scanner(System.in);
        boolean ocupado = false;
        int x;
        int y;
        boolean tresEnRaya = false;
        do {
            do {
                System.out.println("Jugador numero 1 introduzca la posicion de la x");
                x = sc.nextInt();
                y = sc.nextInt();
                comprobarOcupado(tresenraya, x, y);
                if (!ocupado) {
                    tresenraya[x][y] = 'X';
                }
                imprimirTablero(tresenraya);
            } while (ocupado == true);

            do {
                System.out.println("Jugador numero 2 introduzca la posicion del 0");
                x = sc.nextInt();
                y = sc.nextInt();
                comprobarOcupado(tresenraya, x, y);
                if (!ocupado) {
                    tresenraya[x][y] = '0';
                }
                imprimirTablero(tresenraya);
            } while (ocupado == true);
        } while (tresEnRaya == false);
        // for de 9 veces, se sale si hay 3 en raya
        // se pide celda a poner, comprobar que no estaba ocupada
        //si esta ocupada pedir otra.
        // comprobar 3 en raya en funcion
        // dentro de la funcion llamar a funcion comprobarfila, comprobarcolumna
        // y comprobar diagonales.
        // misma fila
        char turno = 'X';
        boolean ganar = true;

        imprimirTablero(tresenraya);

    }

    public static boolean comprobarFila(char[][] tablero, char turno, int x) {
        boolean tresEnRaya = true;
        for (int i = 0; i < 3 && tresEnRaya; i++) {
            if (tablero[x][i] != turno) {
                tresEnRaya = false;
            }
        }

        return tresEnRaya;
    }

    public static boolean comprobarColumna(char[][] tablero, char turno, int y) {
        boolean tresEnRaya = true;
        for (int i = 0; i < 3; i++) {
            if (tablero[y][i] != turno) {
                tresEnRaya = false;

            }
        }
        return tresEnRaya;
    }

    public static boolean comprobarTresEnRaya(char[][] tablero, char turno,
            int x, int y) {
        boolean tresEnRaya = false;

        tresEnRaya = comprobarFila(tablero, turno, x);
        if (tresEnRaya == false) {
            tresEnRaya = comprobarFila(tablero, turno, x);
            if (!tresEnRaya) {
                tresEnRaya = comprobarFila(tablero, turno, x);
            }
        }

        return tresEnRaya;
    }

    public static void imprimirTablero(char[][] tablero) {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                System.out.print(tablero[j][i]);
            }
            System.out.println("");
        }
    }

    public static boolean comprobarOcupado(char[][] tablero, int x, int y) {
        boolean ocupado = false;
        if (tablero[x][y] != '-') {
            System.out.println("La posicion esta ocupada");
            ocupado = true;
        }
        return ocupado;
    }
}

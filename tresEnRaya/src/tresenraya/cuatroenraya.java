/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tresenraya;

import java.util.Scanner;

/**
 *
 * @author flotante
 */
public class cuatroenraya {

    public static void main(String[] args) {
        char[][] cuatroenraya = new char[6][7];

        for (int i = 0; i < cuatroenraya.length; i++) {
            for (int j = 0; j < cuatroenraya[i].length; j++) {
                cuatroenraya[i][j] = '-';
            }

        }
        imprimirTablerocuatro(cuatroenraya);
        //colocar Pieza
        Scanner sc = new Scanner(System.in);
        boolean ganar = false;
        int y;
        int x;
        char turno1= 'X';
        char turno2= '0';
        do {
            System.out.println("Jugador 1 introduzca la posicion donde colocar la ficha");
            y = sc.nextInt();

            x = meterficha(cuatroenraya, y);
            cuatroenraya[x][y] = 'X';
            imprimirTablerocuatro(cuatroenraya);
            
            
            System.out.println("Jugador 2 introduzca la posicion donde colocar la ficha");
            y = sc.nextInt();

            x = meterficha(cuatroenraya, y);
            cuatroenraya[x][y] = '0';
            imprimirTablerocuatro(cuatroenraya);
            
        } while (ganar == false);

        imprimirTablerocuatro(cuatroenraya);

    }
    public static void imprimirTablerocuatro(char[][] tablero) {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                System.out.print(tablero[i][j]);
            }
            System.out.println("");
        }
    }
    public static int meterficha(char[][] tablero, int y) {
        int x = 0;
        for (int i = 5; i >= 0; i--) {
            if (tablero[i][y] == '-') {
                x = i;
                i = 0;
            }
        }
        return x;
    }
    //public static boolean  comprobarfila(char[][] tablero,int x, int y, int turno){
        //boolean comprobarfila=false;
        //for
    //}return comprobarfila;
}

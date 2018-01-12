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

        for (char[] cuatroenraya1 : cuatroenraya) {
            for (int j = 0; j < cuatroenraya1.length; j++) {
                cuatroenraya1[j] = '-';
            }
        }
        imprimirTablerocuatro(cuatroenraya);
        //colocar Pieza
        Scanner sc = new Scanner(System.in);
        boolean ganar = false;
        int y;
        int x;
        char turno1 = 'X';

        do {
            System.out.println("Jugador 1 introduzca la posicion donde colocar la ficha");
            y = sc.nextInt();

            x = meterficha(cuatroenraya, y);
            cuatroenraya[x][y] = turno1;
            imprimirTablerocuatro(cuatroenraya);
            if (!ganar) {
                char turno2 = '0';
                System.out.println("Jugador 2 introduzca la posicion donde colocar la ficha");
                y = sc.nextInt();

                x = meterficha(cuatroenraya, y);
                cuatroenraya[x][y] = turno2;
                imprimirTablerocuatro(cuatroenraya);
            }
        } while (!ganar);

        imprimirTablerocuatro(cuatroenraya);

    }

    public static void imprimirTablerocuatro(char[][] tablero) {
        //for (int i = 0; i < tablero.length; i++) {
        for (char[] tablero1 : tablero) {//foreach(que lo veremos mas adelante)
            for (int j = 0; j < tablero1.length; j++) {
                System.out.print(tablero1[j]);
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

    public static int comprobarfilad(char[][] tablero, int x, int y, int turno, int contadorfd) {
        contadorfd = 0;
        //si da un error comprobar el i<=5 xque puede ser6 .-.
        //si da un error comprobar el i<=5 xque puede ser6 .-.
        for (int i = 0; i < 4; i++) {
            if (y + 1 <= 5) {
                if (tablero[x][y + i] == turno) {
                    contadorfd++;
                } else if (tablero[x][y + i] != turno) {
                    i = 4;
                }
            }
        }
        return contadorfd;
    }

    public static int comprobarfilai(char[][] tablero, int x, int y, int turno, int contadorfi) {
        contadorfi = 0;
        //si da un error comprobar el i<=5 xque puede ser6 .-.
        //si da un error comprobar el i<=5 xque puede ser6 .-.
        //si da un error comprobar el i<=5 xque puede ser6 .-.
        for (int i = 4; i < 0; i--) {
            if (y - 1 >= 0) {
                if (tablero[x][y - i] == turno) {
                    contadorfi++;
                } else if (tablero[x][y - i] != turno) {
                    i = 4;
                }
            }
        }
        return contadorfi;
    }

    public static boolean comprobarfilaf(char[][] tablero, int x, int y, int turno, int contadora, int contadorb, int contadorf) {

        boolean comprobarfila = false;
        contadorf = comprobarfilad(tablero, x, y, turno, contadora) + comprobarfilai(tablero, x, y, turno, contadorb);
        if (contadorf >= 3) {
            System.out.println("Cuatro EN RAYA");
            comprobarfila = true;
        }
        return comprobarfila;
    }

    public static int comprobarcolumnaa(char[][] tablero, int x, int y, int turno, int contadorca) {
        contadorca = 0;
        for (int i = 0; i < 4; i++) {
            if (x + 1 <= 5) {
                if (tablero[x + i][y] == turno) {
                    contadorca++;
                } else if (tablero[x + i][y] != turno) {
                    i = 4;
                }
            }
        }
        return contadorca;
    }

    public static int comprobarcolumnab(char[][] tablero, int x, int y, int turno, int contadorcb) {
        contadorcb = 0;
        for (int i = 4; i < 0; i--) {
            if (x - 1 >= 0) {
                if (tablero[x - i][y] == turno) {
                    contadorcb++;
                } else if (tablero[x - i][y] != turno) {
                    i = 4;
                }
            }
        }
        return contadorcb;
    }

    public static boolean comprobarcolumnaf(char[][] tablero, int x, int y, int turno, int contadorca, int contadorcb, int contadorcf) {
        boolean comprobarcolumna = false;
        contadorcf = comprobarcolumnaa(tablero, x, y, turno, contadorca) + comprobarcolumnab(tablero, x, y, turno, contadorcb);
        if (contadorcf >= 3) {
            System.out.println("Cuatro EN RAYA ");
        }

        return comprobarcolumna;
    }

}

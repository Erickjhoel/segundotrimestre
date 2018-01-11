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
        //for (int i = 0; i < tablero.length; i++) {
        for (char[] tablero1 : tablero) {
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
    public static int  comprobarfilaa(char[][] tablero,int x, int y, int turno, int contadora){
        contadora=0;
        boolean comprobarfilaa=true;
        for(int i=0; i<tablero.length && comprobarfilaa;i++){
            if(tablero[i][x]!=turno){
                comprobarfilaa=false;
            }else if(tablero[i][x]==turno){
                contadora++;
            }
        }return contadora;
    }
    public static int  comprobarfilab(char[][] tablero,int x, int y, int turno, int contadorb){
        contadorb=0;
        boolean comprobarfilab=true;
        for(int i=tablero.length; i<0 && comprobarfilab;i--){
            if(tablero[i][x]!=turno){
                comprobarfilab=false;
            }else if(tablero[i][x]==turno){
                contadorb++;
            }
        }return contadorb;
    }
    public static boolean comprobarfilaf(char[][] tablero,int x, int y, int turno, int contadora, int contadorb, int contadorf){
        
        boolean comprobarfila=false;
        contadorf=comprobarfilaa(tablero,x,y,turno,contadora)+comprobarfilab(tablero,x,y,turno,contadorb);
            if(contadorf>=3){
                
                System.out.println("TRES EN RAYA");
                comprobarfila=true;
            }return comprobarfila;
        }
    }
    


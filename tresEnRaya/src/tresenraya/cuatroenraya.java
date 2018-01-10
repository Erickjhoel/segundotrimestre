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
        char[][] cuatroenraya = new char[7][8];

        for (int i = 0; i < cuatroenraya.length-1; i++) {
            for (int j = 0; j < cuatroenraya[i].length-1; j++) {
                cuatroenraya[j][i]= '-';
            }
            
        }imprimirTablerocuatro(cuatroenraya);
        //colocar Pieza
        Scanner sc = new Scanner(System.in);
        boolean ocupado=false;
        int x;
        int y = 0;
        do{
            System.out.println("Introduzca la posicion donde colocar la ficha");
            x=sc.nextInt();
            
            y=comprobarOcupado(cuatroenraya,y);
            cuatroenraya[y][x]='X';
        }while(ocupado==true);
        
        
        imprimirTablerocuatro(cuatroenraya);
        
}
     
     public static void imprimirTablerocuatro(char[][] tablero) {
        for (int i = 0; i < tablero.length-1; i++) {
            for (int j = 0; j < tablero[i].length-1; j++) {
                System.out.print(tablero[j][i]);
            }
            System.out.println("");
        }
    }
     public static int comprobarOcupado(char[][] tablero, int x) {
       int y=0;
        for(int i=0;i<tablero.length;i++){
        if (tablero[i][x] == '-') {
            i=x;
            y=x;
        }
        }
        return y;
    }
}

    


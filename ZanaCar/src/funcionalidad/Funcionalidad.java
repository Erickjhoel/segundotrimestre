/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funcionalidad;

import clases.Bici;
import clases.Coche;
import clases.Moto;
import clases.Quad;
import java.util.ArrayList;
import clases.Vehiculo;
import java.util.Scanner;

/**
 *
 * @author daw
 */
public class Funcionalidad {

    Scanner sc = new Scanner(System.in);
    private ArrayList<Vehiculo> vendidos = new ArrayList<>();
    private ArrayList<Vehiculo> stock = new ArrayList<>();

    public Funcionalidad() {
        Coche cochazo = new Coche("jajio", 1000, "rojo", "ferrari", 1000);
        Bici bicicleta = new Bici(23, 23, 23, "rojo", "ferrari", 500);
        Moto motocicleta = new Moto("jajio2", 500, "negra", "ferrari", 5000);
        Quad quadpre = new Quad("Jajio3", 0, "azul", "ferrari", 500);
        stock.add(cochazo);
        stock.add(quadpre);
        stock.add(bicicleta);
        stock.add(motocicleta);

    }

    public void comprar() {

        System.out.println("Seleccione:\n"
                + "1. Vehiculo a motor \n"
                + "2. Bicicleta \n");
        int opcion = sc.nextInt();
        sc.nextLine();
        switch (opcion) {
            case 1:
                compravehiculomotor();
                System.out.println("Vehiculo comprado");
                break;
            case 2:
                comprabicicleta();
                System.out.println("Bicicleta comprada");
                break;
            default:
                System.out.println("Opcion no valida");
        }
    }

    public void compravehiculomotor() {
        String matricula;
        int kilometros;
        String color;
        String marca;
        double preciocompra;
        System.out.println("matricula");
        matricula = sc.nextLine();
        sc.nextInt();
        System.out.println("kilometros");
        kilometros = sc.nextInt();

        System.out.println("color");
        color = sc.nextLine();

        System.out.println("marca");
        marca = sc.nextLine();

        System.out.println("precio de compra");
        preciocompra = sc.nextInt();
        sc.nextLine();

        System.out.println("Seleccione:\n"
                + "1. Coche \n"
                + "2. Quad \n"
                + "3. Moto \n");
        int opcion = sc.nextInt();
        sc.nextLine();
        switch (opcion) {
            case 1:
                Coche compracoche = new Coche(matricula, kilometros, color, marca, preciocompra);
                stock.add(compracoche);
                break;
            case 2:
                Quad compraquad = new Quad(matricula, kilometros, color, marca, preciocompra);
                stock.add(compraquad);
                break;
            case 3:
                Moto compramoto = new Moto(matricula, kilometros, color, marca, preciocompra);
                stock.add(compramoto);
                break;
            default:
                System.out.println("Opcion no valida");
        }
    }

    public void comprabicicleta() {
        int tamañorueda;
        int nummarchas;
        int tipodecambio;
        String color;
        String marca;
        double preciocompra;
        System.out.println("tamaño de rueda");
        tamañorueda = sc.nextInt();
        sc.nextLine();

        System.out.println("numero de marchas");
        nummarchas = sc.nextInt();
        sc.nextLine();

        System.out.println("tipo de cambio");
        tipodecambio = sc.nextInt();
        sc.nextLine();

        System.out.println("color de bici");
        color = sc.nextLine();

        System.out.println("marca bici");
        marca = sc.nextLine();

        System.out.println("precio de compra bici");
        preciocompra = sc.nextInt();
        sc.nextLine();
        Bici comprabici = new Bici(tamañorueda, nummarchas, tipodecambio, color, marca, preciocompra);
        stock.add(comprabici);
    }

    public void vender() {
        System.out.println("Seleccione que vehiculo quiere comprar:\n"
                + "1. Coche \n"
                + "2. Moto \n"
                + "3. Quad \n"
                + "4. Bicicleta \n");
        int opcion = sc.nextInt();
        sc.nextLine();
        switch (opcion) {
            case 1:
                vendercoche();
                System.out.println("Vehiculo vendido");
                break;
            case 2:
                comprabicicleta();
                System.out.println("Bicicleta comprada");
                break;
            default:
                System.out.println("Opcion no valida");
        }

    }

    public void vendercoche() {

        for (Vehiculo vehiculo : stock) {
            if (vehiculo instanceof Coche) {
                System.out.println();
            }
        }
        System.out.println("Seleccion por que quiere comprar:\n"
                + "1. Matricula \n"
                + "2. Kilometros  \n"
                + "3. Color \n"
                + "4. Marca \n");
        int opcion = sc.nextInt();
        sc.nextLine();
        switch (opcion) {
            case 1:
                for (Vehiculo vehiculo : stock) {
                    if (vehiculo instanceof Coche) {
                        System.out.println(((Coche) vehiculo).getMatricula());
                    }
                }
                break;
            case 2:
                for (Vehiculo vehiculo : stock) {
                    if (vehiculo instanceof Coche) {
                        System.out.println(((Coche) vehiculo).getKilometros());
                    }
                }

                break;
            case 3:
                for (Vehiculo vehiculo : stock) {
                    if (vehiculo instanceof Coche) {
                        System.out.println(((Coche) vehiculo).getColor());
                    }
                }
                break;

            case 4:
                for (Vehiculo vehiculo : stock) {
                    if (vehiculo instanceof Coche) {
                        System.out.println(vehiculo.getMarca());
                    }
                }
                break;
            default:
                System.out.println("Opcion no valida");
        }

    }

}

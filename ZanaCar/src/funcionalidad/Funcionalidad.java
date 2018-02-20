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
    private int vehiculosvendidos = 0;

    public Funcionalidad() {
        Coche cochazo = new Coche("matricula1", 1000, "rojo", "ferrari", 2000);
        Coche cochazo2 = new Coche("matricula2", 2000, "negro", "ford-fiesta", 1000);
        Bici bicicleta = new Bici(23, 23, 23, "rojo", "ferrari", 500);
        Moto motocicleta = new Moto("jajio1", 500, "negra", "ferrari", 5000);
        Quad quadpre = new Quad("Jajio2", 0, "azul", "ferrari", 500);
        stock.add(cochazo);
        stock.add(cochazo2);
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
        System.out.println("Seleccione que vehiculo quiere VENDER:\n"
                + "1. Coche \n"
                + "2. Bicicleta \n"
                + "3. Quad \n"
                + "4. Moto \n");
        int opcion = sc.nextInt();
        sc.nextLine();
        switch (opcion) {
            case 1:
                vendercoche();
                System.out.println("Vehiculo vedido");
                break;
            case 2:
                venderbici();
                System.out.println("Bicicleta vendida");
                break;
            case 3:
                venderquad();
                System.out.println("Vehiculo vedido");
                break;
            case 4:
                vendermoto();
                System.out.println("Vehiculo vedido");
                break;
            default:
                System.out.println("Opcion no valida");
        }

    }

    public void vendercoche() {

        for (Vehiculo vehiculo : stock) {
            if (vehiculo instanceof Coche) {
                System.out.println(vehiculo.toString());
            }
        }
        System.out.println("Seleccion por que quiere vender:\n"
                + "1. Matricula \n"
                + "2. Marca  \n"
                + "3. Color \n"
                + "4. Precio menor a una cantidad \n");
        int opcion = sc.nextInt();
        sc.nextLine();
        switch (opcion) {
            case 1:
                String matricula;
                System.out.println("matricula del coche");
                matricula = sc.nextLine();
                for (Vehiculo vehiculo : stock) {
                    if (vehiculo instanceof Coche) {
                        if (((Coche) vehiculo).getMatricula().equals(matricula)) {
                            System.out.println(vehiculo.toString() + " indice: " + stock.indexOf(vehiculo));
                        }
                    }
                }
                vendido();
                break;

            case 2:
                String marca;
                System.out.println(
                        "Introduzca la marca del coche");
                marca = sc.nextLine();
                for (Vehiculo vehiculo : stock) {
                    if (vehiculo instanceof Coche) {
                        if (((Coche) vehiculo).getMarca().equals(marca)) {
                            System.out.println(vehiculo.toString() + " indice: " + stock.indexOf(vehiculo));
                        }
                    }
                }
                vendido();
                break;
            case 3:
                String color;
                System.out.println("Introduzca el color del coche");
                color = sc.nextLine();
                for (Vehiculo vehiculo : stock) {
                    if (vehiculo instanceof Coche) {
                        if (((Coche) vehiculo).getColor().equals(color)) {
                            System.out.println(vehiculo.toString() + " indice: " + stock.indexOf(vehiculo));

                        }
                    }
                }
                vendido();
                break;
            case 4:
                double preciomax;
                System.out.println("Introduzca el precio maximo para el coche");
                preciomax = sc.nextInt();
                sc.nextLine();
                for (Vehiculo vehiculo : stock) {
                    if (vehiculo instanceof Coche) {
                        if (((Coche) vehiculo).getPrecioventa() < preciomax) {
                            System.out.println(vehiculo.toString() + " indice: " + stock.indexOf(vehiculo));

                        }
                    }
                }
                vendido();
                break;
            default:
                System.out.println("Opcion no valida");
        }
    }

    public void venderbici() {
        for (Vehiculo vehiculo : stock) {
            if (vehiculo instanceof Bici) {
                System.out.println(vehiculo.toString());
            }
        }
        System.out.println("Seleccion por que quiere vender:\n"
                + "1. Marca \n"
                + "2. Color  \n");
        int opcion = sc.nextInt();
        sc.nextLine();
        switch (opcion) {
            case 1:
                String marca;
                System.out.println(
                        "Introduzca la marca de la bici");
                marca = sc.nextLine();
                for (Vehiculo vehiculo : stock) {
                    if (vehiculo instanceof Bici) {
                        if (((Bici) vehiculo).getMarca().equals(marca)) {
                            System.out.println(vehiculo.toString() + " indice: " + stock.indexOf(vehiculo));
                        }
                    }
                }
                vendido();
                break;
            case 2:
                String color;
                System.out.println("Introduzca el color de la bici");
                color = sc.nextLine();
                for (Vehiculo vehiculo : stock) {
                    if (vehiculo instanceof Bici) {
                        if (((Bici) vehiculo).getColor().equals(color)) {
                            System.out.println(vehiculo.toString() + " indice: " + stock.indexOf(vehiculo));

                        }
                    }
                }
                vendido();
                break;
            default:
                System.out.println("Opcion no valida");
        }

    }

    public void venderquad() {

        for (Vehiculo vehiculo : stock) {
            if (vehiculo instanceof Quad) {
                System.out.println(vehiculo.toString());
            }
        }
        System.out.println("Seleccion por que quiere vender:\n"
                + "1. Matricula \n"
                + "2. Marca  \n"
                + "3. Color \n"
                + "4. Precio menor a una cantidad \n");
        int opcion = sc.nextInt();
        sc.nextLine();
        switch (opcion) {
            case 1:
                String matricula;
                System.out.println("matricula del quad");
                matricula = sc.nextLine();
                for (Vehiculo vehiculo : stock) {
                    if (vehiculo instanceof Quad) {
                        if (((Quad) vehiculo).getMatricula().equals(matricula)) {
                            System.out.println(vehiculo.toString() + " indice: " + stock.indexOf(vehiculo));
                        }
                    }
                }
                vendido();
                break;

            case 2:
                String marca;
                System.out.println(
                        "Introduzca la marca del quad");
                marca = sc.nextLine();
                for (Vehiculo vehiculo : stock) {
                    if (vehiculo instanceof Quad) {
                        if (((Quad) vehiculo).getMarca().equals(marca)) {
                            System.out.println(vehiculo.toString() + " indice: " + stock.indexOf(vehiculo));
                        }
                    }
                }
                vendido();
                break;
            case 3:
                String color;
                System.out.println("Introduzca el color del quad");
                color = sc.nextLine();
                for (Vehiculo vehiculo : stock) {
                    if (vehiculo instanceof Quad) {
                        if (((Quad) vehiculo).getColor().equals(color)) {
                            System.out.println(vehiculo.toString() + " indice: " + stock.indexOf(vehiculo));

                        }
                    }
                }
                vendido();
                break;
            case 4:
                double preciomax;
                System.out.println("Introduzca el precio maximo para el quad");
                preciomax = sc.nextInt();
                sc.nextLine();
                for (Vehiculo vehiculo : stock) {
                    if (vehiculo instanceof Quad) {
                        if (((Quad) vehiculo).getPrecioventa() < preciomax) {
                            System.out.println(vehiculo.toString() + " indice: " + stock.indexOf(vehiculo));

                        }
                    }
                }
                vendido();
                break;
            default:
                System.out.println("Opcion no valida");
        }
    }

    public void vendermoto() {

        for (Vehiculo vehiculo : stock) {
            if (vehiculo instanceof Moto) {
                System.out.println(vehiculo.toString());
            }
        }
        System.out.println("Seleccion por que quiere vender:\n"
                + "1. Matricula \n"
                + "2. Marca  \n"
                + "3. Color \n"
                + "4. Precio menor a una cantidad \n");
        int opcion = sc.nextInt();
        sc.nextLine();
        switch (opcion) {
            case 1:
                String matricula;
                System.out.println("matricula de la moto");
                matricula = sc.nextLine();
                for (Vehiculo vehiculo : stock) {
                    if (vehiculo instanceof Moto) {
                        if (((Moto) vehiculo).getMatricula().equals(matricula)) {
                            System.out.println(vehiculo.toString() + " indice: " + stock.indexOf(vehiculo));
                        }
                    }
                }
                vendido();
                break;

            case 2:
                String marca;
                System.out.println(
                        "Introduzca la marca de la moto");
                marca = sc.nextLine();
                for (Vehiculo vehiculo : stock) {
                    if (vehiculo instanceof Moto) {
                        if (((Moto) vehiculo).getMarca().equals(marca)) {
                            System.out.println(vehiculo.toString() + " indice: " + stock.indexOf(vehiculo));
                        }
                    }
                }
                vendido();
                break;
            case 3:
                String color;
                System.out.println("Introduzca el color de la moto");
                color = sc.nextLine();
                for (Vehiculo vehiculo : stock) {
                    if (vehiculo instanceof Moto) {
                        if (((Moto) vehiculo).getColor().equals(color)) {
                            System.out.println(vehiculo.toString() + " indice: " + stock.indexOf(vehiculo));

                        }
                    }
                }
                vendido();
                break;
            case 4:
                double preciomax;
                System.out.println("Introduzca el precio maximo para la moto");
                preciomax = sc.nextInt();
                sc.nextLine();
                for (Vehiculo vehiculo : stock) {
                    if (vehiculo instanceof Moto) {
                        if (((Moto) vehiculo).getPrecioventa() < preciomax) {
                            System.out.println(vehiculo.toString() + " indice: " + stock.indexOf(vehiculo));

                        }
                    }
                }
                vendido();
                break;
            default:
                System.out.println("Opcion no valida");
        }
    }

    public void vendido() {
        int posicion;
        double precio;
        System.out.println("elija el vehiculo que quiere vender");
        posicion = sc.nextInt();
        sc.nextLine();
        System.out.println("por cuanto dinero lo piensa vender");
        precio = sc.nextInt();
        sc.nextLine();
        if (stock.get(posicion).getPrecioventa() < precio) {
            stock.get(posicion).setPrecioventa(precio);
            vendidos.add(stock.get(posicion));
            stock.remove(stock.get(posicion));
        }
        vehiculosvendidos++;
    }

    public void facturacion() {
        System.out.println("Seleccione que desea hacer:\n"
                + "1. saber la ganancia de cada vehiculo \n"
                + "2. saber la ganancia total de la empresa \n"
                + "3. limpiar la lista de vehiculos vendidos \n");
        int opcion = sc.nextInt();
        sc.nextLine();
        switch (opcion) {
            case 1:
                System.out.println("Los vehiculos vendidos son: " + vehiculosvendidos);
                for (Vehiculo vendido : vendidos) {
                    System.out.println(vendido.toString());
                    System.out.print("- ganancia:" + vendido.getPrecioventa());
                }
                break;
            case 2:
                for (Vehiculo vendido : vendidos) {
                    System.out.println("Ganancia total de la empresa");
                    System.out.println(vendido.gananciatotal());
                }
                break;
            case 3:
                for (Vehiculo vendido : vendidos) {
                    vendidos.remove(vendido);/////comprobar si esta verga borra
                }
                break;
            default:
                System.out.println("Opcion no valida");
        }
    }

public void probar() {
        System.out.println("Seleccione que vehiculo quiere probar:\n"
                + "1. Coche \n"
                + "2. Quad \n");
        int opcion = sc.nextInt();
        sc.nextLine();
        switch (opcion) {
            case 1:
                for (Vehiculo vehiculo : stock) {
                    if (vehiculo instanceof Coche) {
                        System.out.println(vehiculo.toString());
                    }
                }
                String matricula;
                int probado;
                System.out.println("elija la matricula del coche que quiere probar");
                matricula = sc.nextLine();
                System.out.println("cuantos kilometros va a probar el coche");
                probado = sc.nextInt();
                sc.nextLine();
                for (Vehiculo vehiculo : stock) {
                    if (vehiculo instanceof Coche) {
                        if (((Coche) vehiculo).getMatricula().equals(matricula)) {
                            ((Coche) vehiculo).añadirkilometros(probado);
                            System.out.println(vehiculo.toString());
                        }
                    }
                }
                System.out.println("Vehiculo probado");
                break;
            case 2:
                for (Vehiculo vehiculo : stock) {
                    if (vehiculo instanceof Quad) {
                        System.out.println(vehiculo.toString());
                    }
                }
                String matricula2;
                int probado2;
                System.out.println("elija la matricula del quad que quiere probar");
                matricula2 = sc.nextLine();
                
                System.out.println("cuantos kilometros va a probar el coche");
                probado2 = sc.nextInt();
                sc.nextLine();
                for (Vehiculo vehiculo : stock) {
                    if (vehiculo instanceof Quad) {
                        if (((Quad) vehiculo).getMatricula().equals(matricula2)) {
                            ((Quad) vehiculo).añadirkilometros(probado2);
                            System.out.println(vehiculo.toString());
                        }
                    }
                }
                System.out.println("Vehiculo probado");
                break;
            default:
                System.out.println("Opcion no valida");
        }
    }

}

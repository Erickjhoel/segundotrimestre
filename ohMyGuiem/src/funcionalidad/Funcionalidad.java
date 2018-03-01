/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funcionalidad;

import clases.CSGO;
import clases.Campeonato;
import clases.ClassRoyal;
import clases.Ratas;
import clases.LOL;
import clases.PosicionRatas;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author daw
 */
public class Funcionalidad {

    Scanner sc = new Scanner(System.in);

    private ArrayList<CSGO> jugadoresCSGO;
    private ArrayList<ClassRoyal> jugadoresCR;
    private ArrayList<LOL> jugadoresLOL;
    private ArrayList<Ratas> jugadoresbar;
    private ArrayList<ClassRoyal> cartasMazoCR = new ArrayList<>();
    private Map<LocalDate, Campeonato> fechas = new LinkedHashMap<>();

    public Funcionalidad() {
        this.jugadoresCR = new ArrayList<>();
        this.jugadoresCSGO = new ArrayList<>();
        this.jugadoresLOL = new ArrayList<>();
        this.jugadoresbar = new ArrayList<>();

        CSGO rata1 = new CSGO("vergantes", 99, "este", 1, "pepe", 2, "verga");
        CSGO rata2 = new CSGO("vergantes", 1, "este", 2, "ramom", 2, "verga");
        LOL rata3 = new LOL("Linea", "SerFrikis", 0, "Juan", 0, "Verga");
        LOL rata4 = new LOL("Linea", "SerFrikis", 0, "Carmelo", 0, "Verga");
        ClassRoyal rata5 = new ClassRoyal("Nose", 80, 0, "Jacinto", 0, "Verga");
        ClassRoyal rata6 = new ClassRoyal("Wenosice", 80, 0, "Aurelio", 0, "Verga");
        jugadoresCSGO.add(rata1);
        jugadoresCSGO.add(rata2);
        jugadoresLOL.add(rata3);
        jugadoresLOL.add(rata4);
        jugadoresCR.add(rata5);
        jugadoresCR.add(rata6);
        //----------------------------------------
        jugadoresbar.add(rata2);
        jugadoresbar.add(rata1);
        jugadoresbar.add(rata3);
        jugadoresbar.add(rata4);
        jugadoresbar.add(rata5);
        jugadoresbar.add(rata6);

        Campeonato campeonatoCSGO = new Campeonato(LocalDate.MIN, "CSGO", "Este");

    }

    public void campeonatoCSGO() {
        LocalDate fecha;
        int dia;
        int mes;
        int año;
        System.out.println("Indica el dia del campeonato");
        dia = sc.nextInt();
        sc.nextLine();
        System.out.println("Indica el mes del campeonato");
        mes = sc.nextInt();
        sc.nextLine();
        System.out.println("Indica el año del campeonato");
        año = sc.nextInt();
        sc.nextLine();
        fecha = LocalDate.of(año, mes, dia);
        String nombre;
        String premio;
        System.out.println("Introduzca como se va a llamar el campeonato");
        nombre = sc.nextLine();
        System.out.println("Introduzca cual va a ser el premio");
        premio = sc.nextLine();
        Campeonato camp = new Campeonato(fecha, nombre, premio);
        fechas.put(fecha, camp);

        boolean salir = false;
        do {
            int repetido;
            int seleccion;
            for (Ratas jugadores : jugadoresCSGO) {
                System.out.println(jugadores.toString() + "---" + jugadoresCSGO.indexOf(jugadores));
            }

            System.out.println("Seleccione el jugador que va a participar");
            seleccion = sc.nextInt();
            Ratas jugador = jugadoresCSGO.get(seleccion);
            PosicionRatas nuevo = new PosicionRatas(jugadoresCSGO.get(seleccion), 0);//metes a la rata en el ranking
            camp.addrata(nuevo);//añades a la rata a el campeonato
            int masratas;
            System.out.println("Meter otra rata"
                    + "1. Si"
                    + "2. No");
            masratas = sc.nextInt();
            sc.nextLine();
            if (masratas == 1) {
                salir = true;
            }
        } while (!salir);

    }

    public void campeonatoLOL() {
        LocalDate fecha;
        int dia;
        int mes;
        int año;
        System.out.println("Indica el dia del campeonato");
        dia = sc.nextInt();
        sc.nextLine();
        System.out.println("Indica el mes del campeonato");
        mes = sc.nextInt();
        sc.nextLine();
        System.out.println("Indica el año del campeonato");
        año = sc.nextInt();
        sc.nextLine();
        fecha = LocalDate.of(año, mes, dia);
        String nombre;
        String premio;
        System.out.println("Introduzca como se va a llamar el campeonato");
        nombre = sc.nextLine();
        System.out.println("Introduzca cual va a ser el premio");
        premio = sc.nextLine();
        Campeonato camp = new Campeonato(fecha, nombre, premio);
        fechas.put(fecha, camp);
        boolean salir = false;
        do {
            int repetido;
            int seleccion;
            for (Ratas jugadores : jugadoresLOL) {
                System.out.println(jugadores.toString() + "---" + jugadoresLOL.indexOf(jugadores));
            }

            System.out.println("Seleccione el jugador que va a participar");
            seleccion = sc.nextInt();
            Ratas jugador = jugadoresLOL.get(seleccion);
            PosicionRatas nuevo = new PosicionRatas(jugadoresLOL.get(seleccion), 0);//metes a la rata en el ranking
            camp.addrata(nuevo);//añades a la rata a el campeonato
            int masratas;
            System.out.println("Meter otra rata"
                    + "1. Si"
                    + "2. No");
            masratas = sc.nextInt();
            sc.nextLine();
            if (masratas == 1) {
                salir = true;
            }
        } while (!salir);
    }

    public void campeonatoCR() {
        LocalDate fecha;
        int dia;
        int mes;
        int año;
        System.out.println("Indica el dia del campeonato");
        dia = sc.nextInt();
        sc.nextLine();
        System.out.println("Indica el mes del campeonato");
        mes = sc.nextInt();
        sc.nextLine();
        System.out.println("Indica el año del campeonato");
        año = sc.nextInt();
        sc.nextLine();
        fecha = LocalDate.of(año, mes, dia);
        String nombre;
        String premio;
        System.out.println("Introduzca como se va a llamar el campeonato");
        nombre = sc.nextLine();
        System.out.println("Introduzca cual va a ser el premio");
        premio = sc.nextLine();
        Campeonato camp = new Campeonato(fecha, nombre, premio);
        fechas.put(fecha, camp);
        boolean salir = false;
        do {
            int repetido;
            int seleccion;
            for (Ratas jugadores : jugadoresCR) {
                System.out.println(jugadores.toString() + "---" + jugadoresCR.indexOf(jugadores));
            }

            System.out.println("Seleccione el jugador que va a participar");
            seleccion = sc.nextInt();
            Ratas jugador = jugadoresCR.get(seleccion);
            PosicionRatas nuevo = new PosicionRatas(jugadoresCR.get(seleccion), 0);//metes a la rata en el ranking
            camp.addrata(nuevo);//añades a la rata a el campeonato
            int masratas;
            System.out.println("Meter otra rata"
                    + "1. Si"
                    + "2. No");
            masratas = sc.nextInt();
            sc.nextLine();
            if (masratas == 1) {
                salir = true;
            }
        } while (!salir);
    }

    public void ponerPocicion() {
//        System.out.println("Elije el campeonato");
//        for (Campeonato elegir : fechas) {
//            
//        }
//        
//        
//        
//        int posicion;
//        int indicegamer;
//        System.out.println("Posicion del jugador");
//        posicion = sc.nextInt();
//        sc.nextLine();
//        System.out.println("Elige al jugador");
//        for (Ratas listado : jugadoresbar) {
//            System.out.println(barClientes.indexOf(listado));
//            System.out.println(listado);
//        }
//        indicegamer = sc.nextInt();
//        sc.nextLine();
//        Cliente a = barClientes.get(indicegamer);
//        //no tiene q repetirse

    }

}

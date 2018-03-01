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
        CSGO rata2 = new CSGO("vergantes", 1, "este", 2, "pepe", 2, "verga");
        jugadoresCSGO.add(rata1);
        jugadoresCSGO.add(rata2);

        //----------------------------------------
        jugadoresbar.add(rata2);
        jugadoresbar.add(rata1);

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
        fecha = LocalDate.of(dia, mes, año);
        String nombre;
        String premio;
        System.out.println("Introduzca como se va a llamar el campeonato");
        nombre = sc.nextLine();
        System.out.println("Introduzca cual va a ser el premio");
        premio = sc.nextLine();
        Campeonato camp = new Campeonato(fecha, nombre, premio);
        fechas.put(fecha, camp);
        boolean repetido;
        do {
            for (Ratas jugadores : jugadoresCSGO) {
                System.out.println(jugadores + "---" + jugadoresCSGO.indexOf(jugadores));
            }

            int seleccion;
            System.out.println("Seleccione el jugador que va a participar");
            seleccion = sc.nextInt();
            Ratas jugador = jugadoresCSGO.get(seleccion);
             PosicionRatas este = new PosicionRatas(jugadoresCSGO.get(seleccion), 0);
             camp.addrata(este);
           
        } while (!false);

        
    }
}

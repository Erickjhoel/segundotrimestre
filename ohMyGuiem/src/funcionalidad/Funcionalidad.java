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
        
        CSGO rata1= new CSGO("vergantes", 99, "este", 1, "pepe", 2, "verga");
        CSGO rata2= new CSGO("vergantes", 1, "este", 2, "pepe", 2, "verga");
        jugadoresCSGO.add(rata1);
        jugadoresCSGO.add(rata2);
        
        //----------------------------------------
        jugadoresbar.add(rata2);
        jugadoresbar.add(rata1);
    }
    public void campeonatoCSGO(){
        System.out.println("Elige el dia del campeonato");
        
    
    }
    
}

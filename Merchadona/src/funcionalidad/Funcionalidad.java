/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funcionalidad;

import clases.Cajero;
import clases.Empleado;
import clases.Reponedor;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author daw
 */
public class Funcionalidad {

    Scanner sc = new Scanner(System.in);
    Map<Integer, Empleado> empleados = new LinkedHashMap<>();//integer es igual al INT
    
    public Funcionalidad() {
        Cajero cajero1 = new Cajero("Pepe", 2);
        empleados.put(cajero1.getID(), cajero1);
        Reponedor reponedor1 = new Reponedor("Juan",3);
        empleados.put(reponedor1.getID(), reponedor1);
    }

    public void reponedorocajero(int ID) {
        Empleado a = empleados.get(ID);
        if (a instanceof Cajero) {
            cajero();
        } else {
            reponedor();
        }

    }

    public void reponedor() {

    }

    public void cajero() {

    }

}

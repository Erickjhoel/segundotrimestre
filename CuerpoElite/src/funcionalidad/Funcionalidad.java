/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funcionalidad;

import clases.RMHumanos;
import clases.RecursosMilitares;
import clases.UsabilidadRecursos;
import clases.Vehiculo;
import java.util.ArrayList;
import java.time.LocalDate;
import java.time.Month;
import java.util.Scanner;

/**
 *
 * @author daw
 */
public class Funcionalidad {

    private ArrayList<RecursosMilitares> recursos;

    Scanner sc = new Scanner(System.in);

    public Funcionalidad() {
        recursos = new ArrayList<>();
        RMHumanos soldadito = new RMHumanos(1, 2, 20, 2, 20, "Jacinto");
        RMHumanos soldadito2 = new RMHumanos(1, 2, 20, 2, 20, "Jacinto2");
        recursos.add(soldadito);
        recursos.add(soldadito2);
        Vehiculo helicoptero = new Vehiculo(4, 5, 10, 50, "helicoptero");
        recursos.add(helicoptero);

    }

    public void crearmision() {
        String lugar;
        System.out.println("Elige el lugar de la mision");
        lugar = sc.nextLine();
        int dia;
        System.out.println("Eliga el dia de la mision");
        dia = sc.nextInt();
        sc.nextLine();
        int mes;
        System.out.println("Eliga el mes de la mision");
        mes = sc.nextInt();
        sc.nextLine();
        int año;
        System.out.println("eliga el año de la mision");
        año = sc.nextInt();
        sc.nextLine();
        LocalDate fecha;
        fecha = LocalDate.of(año, mes, dia);
        System.out.println("Eliga de que va a ser la mision");
        System.out.println(
                "1. Mision de combate \n"
                + "2. Mision de reconocimiento \n");
        int opcion = sc.nextInt();
        sc.nextLine();
        switch (opcion) {
            case 1:
                misionreconocimiento();
                break;
            case 2:

                break;
            default:
                System.out.println("Opcion no valida");
        }
    }

    public void misionreconocimiento() {
        int numeroSoldados=0;
        
        System.out.println("Seleccione un soldado para la mision");
        int seleccion;
        for (RecursosMilitares soldados : recursos) {
            if (soldados instanceof RMHumanos) {
                System.out.println(recursos.indexOf(soldados) + "--" + soldados);
            }
        }
        seleccion = sc.nextInt();
        sc.nextLine();
        RecursosMilitares a = recursos.get(seleccion);
        RMHumanos humano = (RMHumanos) a;//Esta verga es el polimorfismo para que b se pueda ver como RMhumano y Recursos militares
       
        int nivelEstres;

        int nivelExpe;
        System.out.println("Nivel de experiencia que se gana con la mision");
        nivelExpe = sc.nextInt();
        sc.nextLine();
        humano.setNivelExperiencia(nivelExpe);
        boolean exito;
        int elegirExito;
        System.out.println("la mision tendra exito"
                + "1. si \n"
                + "2. no \n");
        elegirExito = sc.nextInt();
        sc.nextLine();
        if (elegirExito == 1) {
            exito = true;
        } else if (elegirExito == 2) {
            exito = false;
        }
        System.out.println("Seleccione el nivel de estres que conlleba la mision");
        nivelEstres = sc.nextInt();
        sc.nextLine();
        humano.setNivelEstres(nivelEstres + humano.getNivelEstres());
        humano.getNivelEstres();
        if (nivelEstres > 20) {
            System.out.println("No se puede realizar la mision el soldado esta estresado");
        } else {
            numeroSoldados++;
            System.out.println("añadir vehiculo");
            int seleccionvehiculo;
            System.out.println("elige un vehiculo");
            for (RecursosMilitares vehiculo : recursos) {
                if (vehiculo instanceof Vehiculo) {
                    System.out.println(vehiculo + "" + recursos.indexOf(vehiculo));
                }
            }
            seleccionvehiculo = sc.nextInt();
            sc.nextLine();
            RecursosMilitares b= recursos.get(seleccionvehiculo);
            Vehiculo vehiculito=(Vehiculo)b;
            int numPlazas;
            System.out.println("Cuantas plazas tendra el vehiculo");
            numPlazas=sc.nextInt();
            sc.nextLine();
            vehiculito.setNumeropersonasquellevan(numPlazas+vehiculito.getNumeropersonasquellevan());
            vehiculito.getNumeropersonasquellevan();
            if(numPlazas>numeroSoldados){
                String uso;
                System.out.println("Para que lo va a usar");
                uso=sc.nextLine();
                UsabilidadRecursos usarpara= new UsabilidadRecursos(uso);
               usarpara.addUso(recursos.get(seleccionvehiculo));
                
            }
        }
        

        
    }

}

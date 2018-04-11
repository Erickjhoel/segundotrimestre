
package fuerzasEspeciales.modelo;

public class Equipo extends Material{
    
    public Equipo(int potenciaMuerte, String nombre, int nvlHabilidadMinimo, int rangoAccion) {
        super(potenciaMuerte, nombre, nvlHabilidadMinimo, rangoAccion);
    }

    public Equipo() {
    }

    
    @Override
    public String toString() {
        return "Equipo{"+super.toString() + '}';
    }


    
    
}

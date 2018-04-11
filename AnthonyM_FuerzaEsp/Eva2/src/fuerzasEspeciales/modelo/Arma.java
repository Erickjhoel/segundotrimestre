
package fuerzasEspeciales.modelo;

public class Arma extends Material{
    
    public Arma(int potenciaMuerte, String nombre, int nvlHabilidadMinimo, int rangoAccion) {
        super(potenciaMuerte, nombre, nvlHabilidadMinimo, rangoAccion);
    }

    public Arma() {
    }

    @Override
    public String toString() {
        return "Arma{" +super.toString()+ '}';
    }


    
    
}

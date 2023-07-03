package EjercicioParcial;

import CLineales.Pila.StackLinkedListAbs;

/**
 *
 * @author mithrandir
 */
public class Caja extends StackLinkedListAbs{
    private final String nombre;

    public Caja(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
    
    
}

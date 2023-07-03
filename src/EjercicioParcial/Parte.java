package EjercicioParcial;
/**
 *
 * @author mithrandir
 */
public class Parte {
    private final String nombre;
    private final double tamaño;

    public Parte(String nombre, double tamaño) {
        this.nombre = nombre;
        this.tamaño = tamaño;
    }
    
    @Override
    public String toString(){
        return String.format("Nombre %s y tamaño %f",nombre,tamaño);
    }

    public String getNombre() {
        return nombre;
    }

    public double getTamaño() {
        return tamaño;
    }
}

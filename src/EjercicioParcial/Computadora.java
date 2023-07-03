package EjercicioParcial;
/**
 *
 * @author mithrandir
 */
public class Computadora {
    private boolean completa;
    private Parte pantalla,base,teclado;

    public Computadora() {
        completa = false;
        pantalla = base = teclado = null;
    }

    public boolean isCompleta() {
        if(pantalla != null && teclado != null && base != null){
            completa = true;
        }
        return completa;
    }

    public void setCompleta(boolean completa) {
        this.completa = completa;
    }

    public Parte getPantalla() {
        return pantalla;
    }

    public void setPantalla(Parte pantalla) {
        this.pantalla = pantalla;
    }

    public Parte getBase() {
        return base;
    }

    public void setBase(Parte base) {
        this.base = base;
    }

    public Parte getTeclado() {
        return teclado;
    }

    public void setTeclado(Parte teclado) {
        this.teclado = teclado;
    }
}

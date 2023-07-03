package EjercicioParcial;

import java.util.Random;
/**
 *
 * @author mithrandir
 */
public class Empaquetador {
    
    
    public Caja empaquetar(String nombre){
        Caja caja = new Caja(nombre);
        for(int i=0; i<50; i++){
            switch(new Random().nextInt(3)){
                case 0 ->{
                    caja.add(new Parte(nombre,11.0));
                }
                case 1 ->{
                    caja.add(new Parte(nombre,15.0));
                }
                case 2 ->{
                    caja.add(new Parte(nombre,18.2));
                }
            }
        }
        return caja;
    }
}

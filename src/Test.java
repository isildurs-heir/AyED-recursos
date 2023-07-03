
import EjercicioParcial.Caja;
import EjercicioParcial.Cinta;
import EjercicioParcial.Empaquetador;
import EjercicioParcial.Parte;

/**
 *
 * @author mithrandir
 */
public class Test {
    public static void main(String[] args){
        Empaquetador e1 = new Empaquetador();
        Caja c1 = e1.empaquetar("Pantalla");
        Caja c2 = e1.empaquetar("Teclado");
        Caja c3 = e1.empaquetar("Base");
        
        Cinta cinta1 = new Cinta(11.0);
        Cinta cinta2 = new Cinta(15.0);
        Cinta cinta3 = new Cinta(18.2);
        
        
        while(!c1.isEmpty()){
            Parte parte = (Parte)c1.pop();
            //System.out.println(parte.toString());
            if(parte.getTamaño() == 11.0){
                cinta1.add(parte);
            }else if(parte.getTamaño() == 15.0){
                cinta2.add(parte);
            }
            else{
                cinta3.add(parte);
            }
            parte = (Parte)c3.pop();
            //System.out.println(parte.toString());
            if(parte.getTamaño() == 11.0){
                cinta1.add(parte);
            }else if(parte.getTamaño() == 15.0){
                cinta2.add(parte);
            }
            else{
                cinta3.add(parte);
            }
            parte = (Parte)c2.pop();
            //System.out.println(parte.toString());
            if(parte.getTamaño() == 11.0){
                cinta1.add(parte);
            }else if(parte.getTamaño() == 15.0){
                cinta2.add(parte);
            }
            else{
                cinta3.add(parte);
            }
        }
        
        
        
        cinta1.correrCinta();
        cinta2.correrCinta();
        cinta3.correrCinta();
        
        System.out.println(cinta1.toString());
        System.out.println(cinta2.toString());
        System.out.println(cinta3.toString());
      
        
        
    }
    
}

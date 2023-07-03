package EjercicioParcial;

import CLineales.Cola.QueueDLinkedList;
import CLineales.Cola.QueueDLinkedListAbs;
import CLineales.Pila.StackLinkedList;

public class Cinta extends QueueDLinkedListAbs{
    private int cnt;
    private final double tamaño;
    private Computadora computadora;

    public Cinta(double tamaño) {
        this.tamaño = tamaño;
        cnt = 0;
        computadora = new Computadora();
    }
    
    @Override
    public String toString(){
        return String.format("Cinta de tamaño %.1f construyo %d computadoras",this.tamaño,this.cnt);
    }
    
    public void correrCinta() {
        while (!isEmpty() && verificar_si_puedo_seguir()) {
            Parte parte = (Parte)this.pop();
            switch (parte.getNombre()) {
                case "Pantalla" -> {
                    if (computadora.getPantalla() == null) {
                        computadora.setPantalla(parte);
                        parte = null;
                    }
                    
                }
                case "Teclado" -> {
                    if (computadora.getTeclado() == null) {
                        computadora.setTeclado(parte);
                        parte = null;
                    }
                    
                }
                case "Base" -> {
                    if (computadora.getBase() == null) {
                        computadora.setBase(parte);
                        parte = null;
                    }
                    
                }
            }
            if (parte != null) {
                this.add(parte);
            }
            else{
                verificar_computadora();
            }
        }
    }
    
    private void verificar_computadora(){
        if(computadora.isCompleta()){
            //System.out.println("Computadora hecha");
            cnt++;
            computadora = new Computadora();
        }
    }
    
    private boolean verificar_si_puedo_seguir(){
        boolean response = false;
        QueueDLinkedList stack = new QueueDLinkedList(); //cola auxiliar
        int p1,p2,p3,c;
        p1 = p2 = p3 = c = 0;
        while(!isEmpty()){
            c++;
            stack.add(this.pop()); //saco de cinta y coloco en la cola auxiliar
        }
        if(c >= 3){
            while(!stack.isEmpty()){
                Parte parte = (Parte)stack.pop();
                switch(parte.getNombre()){
                    case "Pantalla" -> {
                        p1++;
                    }
                    case "Teclado" -> {
                        p2++;
                    }
                    case "Base" -> {
                        p3++;
                    }
                }
                add(parte); //vuelvo a cargar en la cinta
            }
            if(p1 > 0 && p2 > 0 && p3 > 0){// si hay por lo menos 1 elemento de cada uno
                response = true;
            }
        }
        
        return response;
    }
}

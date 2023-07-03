package CLineales.Cola;

import CLineales.operaciones.OperacionesCL1;

public abstract class QueueArrAbs implements OperacionesCL1 {
    protected Object[] queue;
    protected int last,first;  //first posicion anterior al primero; last posicion del ultimo
    protected int tam;
    
    public QueueArrAbs(int tam){
        this.tam = tam;
        queue = new Object[this.tam];
    }
    
    @Override
    public boolean isEmpty(){
        return (first == last);
    }
    
    public int size(){
        return this.tam;
    }
    
    @Override
    public boolean isFull(){
        int p; // posicion valida para insertar
        if(last == tam -1){
            p = 0;
        }
        else{
            p = last+1;
        }
        return p == first;
    }
    
    private void incrLast(){
        last++;
    }
    
    private void incrFirst(){
        first++;
    }
    
    @Override
    public void add(Object element){
        if(!this.isFull()){
            if(last == tam - 1){
                last = 0;
            }
            else{
                incrLast();
            }
            queue[last] = element;
        }
        else{
            System.out.println("Error. Cola llena");
        }
    }
    
    @Override
    public Object pop(){
        Object element = null;
        if(!isEmpty()){
            if(first == tam-1){
                first = 0;
            }
            else{
                incrFirst();
            }
            element = queue[first];
        }
        else{
            System.out.println("Error. Cola vacia");
        }
        return element;
    }

    @Override
    public void clean() {
        this.first = this.last = 0;
    }
    
}

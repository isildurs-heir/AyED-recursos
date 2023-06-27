package CLineales.Pila;

import CLineales.operaciones.OperacionesCL1;

public abstract class StackArrAbs implements OperacionesCL1 {
    private Object[] stack;
    private int head; //posicion - indica que pila esta vacia
    private int size; // head = size -> llena
    
    public StackArrAbs(int size){
        this.size = size;
        stack = new Object[this.size];
    }
    
    @Override
    public void add(Object element) {
        if(!isFull()){
            incrHead();
            stack[head] = element;
        }
        else{
            System.out.println("Error.Pila llena");
        }
    }

    @Override
    public Object pop() {
        Object element = null;
        if(!isEmpty()){
            element = stack[head];
            incrHead();
        }
        else{
            System.out.println("Error. Pila Vacia");
        }
        return element;
    }

    @Override
    public boolean isEmpty() {
        return (head == -1);
    }

    @Override
    public void clean() {
        head = -1;
    }

    @Override
    public boolean isFull() {
        return (head == size-1);
    }
    
    private void incrHead(){
        head++;
    }
    
    private void decrHead(){
        head--;
    }
    
}

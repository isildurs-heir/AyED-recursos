package CLineales.Pila;

import CLineales.operaciones.OperacionesCL1;
import CLineales.recursos.Node;

public class  StackLinkedListAbs implements OperacionesCL1{
    private Node stack;
    
    public StackLinkedListAbs(){
        stack = null;
    }
    
    @Override
    public void add(Object element) {
        stack = new Node(element,stack);
    }

    @Override
    public Object pop() {
        Object element = null;
        if(!isEmpty()){
            element = stack.getInfo();
            stack = stack.getNext();
        }
        else{
            System.out.println("Error. Pila Vacia");
        }
        return element;
    }

    @Override
    public boolean isEmpty() {
        return (stack == null);
    }

    @Override
    public void clean() {
        stack = null;
    }

    @Override
    public boolean isFull() {
        return false;
    }
    
}


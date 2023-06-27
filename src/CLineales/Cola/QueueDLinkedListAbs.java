package CLineales.Cola;

import CLineales.operaciones.OperacionesCL1;
import CLineales.recursos.DNode;

public abstract class QueueDLinkedListAbs implements OperacionesCL1 {
    private DNode first,last;
    
    public QueueDLinkedListAbs(){
        first = null;
        last = null;
    }

    @Override
    public void add(Object element) {
        if(!isEmpty()){
            last.setNext(new DNode(element,last,null));
            last = last.getNext();
        }
        else{
            first = new DNode(element);
            last = first;
        }
    }

    @Override
    public Object pop() {
        Object element = null;
        if(!isEmpty()){
            element = first.getInfo();
            first = first.getNext();
            if(isEmpty()){
                last = null;
            }
        }
        else{
            System.out.println("Error. Cola vacia.");
        }
        return element;
    }

    @Override
    public boolean isEmpty() {
        return first == null;
    }

    @Override
    public void clean() {
        first = last = null;
    }

    @Override
    public boolean isFull() {
        return false;
    }
    
    
}

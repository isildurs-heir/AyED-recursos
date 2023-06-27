package CLineales.Cola;

import CLineales.operaciones.OperacionesCL1;
import CLineales.recursos.Node;

public abstract class PriorityQueue implements OperacionesCL1 {

    protected Node first,last;
    
    public PriorityQueue(){
        first = last = null;
    }
    
    public abstract boolean minor(Object element1, Object element2);
    public abstract boolean major(Object element1, Object element2);
    public abstract boolean equals(Object element1, Object element2);

    
    @Override
    public void add(Object element) {
        Node temp;
        if(!isEmpty()){
            if(major(first.getInfo(),element)){
                first = new Node(element,first);
            }
            else{
                temp = first;
                while(temp.getNext() != null && minor(temp.getNext().getInfo(),element)){
                    temp = temp.getNext();
                }
                if(temp.getNext() != null){
                    temp.setNext(new Node(element,temp.getNext()));
                }
                else{
                    last.setNext(new Node(element));
                }
            }
        }
        else{
            first = last = new Node(element);
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
            System.out.println("Error. Cola vacia");
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

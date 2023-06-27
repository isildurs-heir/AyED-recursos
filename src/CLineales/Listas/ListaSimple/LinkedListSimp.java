package CLineales.Listas.ListaSimple;

import CLineales.recursos.Node;

public abstract class LinkedListSimp extends LinkedListAbs {
@Override
    public void add(Object element) {
        if(!this.isEmpty()){
            Node temp;
            temp = this.node;
            while(temp.getNext() != null){
                temp = temp.getNext();
            }
            temp.setNext(new Node(element));
        }
        else{
            this.node = new Node(element);
        }
    }

    @Override
    public int search(Object element) {
        Node temp = this.node;
        int index = 0;
        while(!this.equals(temp.getInfo(),element) && index<(this.size()-1)){
            index++;
            temp = temp.getNext();
        }
        if(index < this.size()){
            return index;
        }
        else{
            return -1;
        }
    }
}


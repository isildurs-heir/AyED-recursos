package CLineales.Listas.ListaDoble;

import CLineales.recursos.DNode;


public abstract class DLinkedListSimp extends DLinkedListAbs {

    @Override
    public void add(Object element) {
        if(this.isEmpty()){
            this.first = new DNode(element);
            this.last = this.first;
        }
        else{
            DNode temp;
            temp = new DNode(element,this.last,null);
            this.last.setNext(temp);
            this.last = temp;
        }
        this.size++;
    }

    @Override
    public int search(Object element) {
        if(!this.isEmpty()){
            DNode temp = this.first;
            int index = 0;
            while(!this.equals(temp.getInfo(),element) && temp != null){
                index++;
                temp = temp.getNext();
            }
            if(temp != null){
                return index;
            }
            else{
                return -1;
            }
        }
        else{
            System.out.println("Lista vacia.Error");
            return -1;
        }
    }

    @Override
    public void replace(int index, Object element) {
        if(!this.isEmpty()){
            if(index < this.size() && index >= 0){
                if(index == 0){
                    this.first.setInfo(element);
                }
                else if(index == size()-1){
                    this.last.setInfo(element);
                }
                else{
                    DNode temp;
                    temp = this.first;
                    for(int i=0;i<index;i++){
                        temp = temp.getNext();
                    }
                    temp.setInfo(element);
                }
            }
            else{
                System.out.println("Error. Posicion invalida");
            }
        }
        else{
            System.out.println("Error. Lista vacia");
        }
    }
    
}

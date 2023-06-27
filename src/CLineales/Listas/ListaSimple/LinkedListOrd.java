package CLineales.Listas.ListaSimple;

import CLineales.operaciones.OperacionesCLO;
import CLineales.recursos.Node;

public abstract class LinkedListOrd extends LinkedListAbs implements OperacionesCLO {
    
    @Override
    public void add(Object element) {
        Node next, nvo, prev;
        if(!this.isEmpty()){
            if(this.major(this.node.getInfo(),element)){
                nvo = new Node(element,this.node);
                this.node = nvo;
            }
            else{
                prev = null;
                next = this.node;
                while(next != null && (!this.major(next.getInfo(),element))){
                    prev = next;
                    next = next.getNext();
                }
                if(next != null){
                    nvo = new Node(element);
                    prev.setNext(nvo);
                    nvo.setNext(next);
                }
                else{
                    nvo = new Node(element);
                    prev.setNext(nvo);
                }
            }
        }
        else{
            this.node = new Node(element);
        }
        this.incSize();
    }

    @Override
    public abstract boolean minor(Object element1, Object element2);
    
    public abstract boolean major(Object element1, Object element2);

    

    @Override
    public int search(Object element) {  // faltan condiciones de index
        Node temp = this.node;
        int index = 0;
        while(temp != null && !this.equals(temp.getInfo(),element)){
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

    @Override
    public void replace(int index, Object element) {
        if(!this.isEmpty()){
            if(index < this.size() && index >= 0){
                int newIndex = pos(this.node,element,index);
                if(newIndex == index){
                    Node temp = this.node;
                    for(int i = 1; i<=index; i++){
                        temp = temp.getNext();
                    }
                    temp.setInfo(element);
                }
                else{
                    Node prev,next;
                    prev = null;
                    next = this.node;
                    if(index < newIndex){
                        for(int i=0;i<newIndex;i++){
                            if(index == i){
                                if(i == 0){
                                   this.node = next.getNext(); 
                                }
                                else if(i == this.size()-1){
                                    prev.setNext(null);
                                }
                                else{
                                    prev.setNext(next.getNext());
                                }
                                next = next.getNext();
                            }
                            else{
                                prev = next;
                                next = next.getNext();
                            }
                        }
                        if(newIndex == this.size()-1){
                            prev.setNext(new Node(element));
                        }
                        else{
                            prev.setNext(new Node(element,next));
                        }
                    }
                    else{
                        for(int i=0;i<index;i++){
                            if(newIndex == i){
                                if(i == 0){
                                   this.node = new Node(element,this.node);
                                }
                                else if(i == this.size()-1){
                                    prev.setNext(new Node(element));
                                }
                                else{
                                    prev.setNext(new Node(element,next));
                                }
                            }
                            else{
                                prev = next;
                                next = next.getNext();
                            }
                        }
                        if(index == this.size()-1){
                            prev.setNext(null);
                        }
                        else{
                            prev.setNext(next.getNext());
                        }
                    }
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
    
    public int pos(Node node,Object element,int pos){
        int index = 0;
        while(node != null && (this.minor(node.getInfo(),element))){
            node = node.getNext();
            index++;
        }
        System.out.println("INDICE DE INSERCION! " + index);
        return index;
    
    }

}


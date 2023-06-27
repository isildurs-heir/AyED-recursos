
package CLineales.Listas.ListaDoble;

import CLineales.operaciones.OperacionesCLO;
import CLineales.recursos.DNode;

public abstract class DLinkedListOrd extends DLinkedListAbs implements OperacionesCLO{

    public void muestra(){
        DNode temp;
        if(!this.isEmpty()){
            temp = this.first;
            while(temp != null){
                System.out.println(temp.getInfo().toString());
                temp = temp.getNext();
            }
            System.out.println("------");
        }
    }

    @Override
    public int search(Object element){
        System.out.println(this.size());
        if(!this.isEmpty()){
            DNode temp = this.first;
            int index = 0;
            while(temp != null && !this.equals(temp.getInfo(),element)){ // llevo control de tamaño, la catedra lleva control de posicion
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
            System.out.println("Error. Lista vacia");
            return -1;
        }
    }

    @Override
    public void add(Object element){
        DNode nvo,prev,next;
        if(!this.isEmpty()){
            if(this.major(this.first.getInfo(),element) || this.equals(this.first.getInfo(),element)){
                nvo = new DNode(element,null,this.first);
                this.first.setPrev(nvo);
                this.first = nvo;
            }
            else if(this.minor(this.last.getInfo(),element) || this.equals(this.last.getInfo(),element)){
                nvo = new DNode(element,this.last,null);
                this.last.setNext(nvo);
                this.last = nvo;
            }
            else{
                prev = this.first;
                next = prev.getNext();
                while(this.minor(next.getInfo(),element)){
                    prev = next;
                    next = next.getNext();
                }
                nvo = new DNode(element,prev,next);
                prev.setNext(nvo);
                next.setPrev(nvo);
            }
        }
        else{
            this.first= this.last = new DNode(element);
        }
        this.size++;
    }

    @Override
    public void replace(int index, Object element) {
        if(!this.isEmpty()){
            if(index < this.size() && index >= 0){
                int newIndex = pos(this.first,element,index);
                if(newIndex == index){
                    DNode temp = this.first;
                    for(int i = 1; i<=index; i++){
                        temp = temp.getNext();
                    }
                    temp.setInfo(element);
                }
                else{
                    DNode prev,next;
                    prev = null;
                    next = this.first;
                    if(index < newIndex){
                        for(int i=0;i<newIndex;i++){
                            if(index == i){
                                if(i == 0){
                                   this.first = next.getNext(); 
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
                            prev.setNext(new DNode(element));
                        }
                        else{
                            prev.setNext(new DNode(element,null,next));
                        }
                    }
                    else{
                        for(int i=0;i<index;i++){
                            if(newIndex == i){
                                if(i == 0){
                                   /*this.node = next.getNext();*/
                                   this.first = new DNode(element,null,this.first);
                                }
                                else if(i == this.size()-1){
                                    /*prev.setNext(null);*/
                                    prev.setNext(new DNode(element,prev,null));
                                }
                                else{
                                    /*prev.setNext(next.getNext());*/
                                    prev.setNext(new DNode(element,prev,next));
                                }
                            }
                            else{
                                prev = next;
                                next = next.getNext();
                            }
                        }
                        if(index == this.size()-1){
                            /*prev.setNext(new Node(element));*/
                            prev.setNext(null);
                        }
                        else{
                            /*prev.setNext(new Node(element,next));*/
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

    public int pos(DNode node,Object element,int pos){
        int index = 0;
        while(node != null && (this.minor(node.getInfo(),element))){
            node = node.getNext();
            index++;
        }
        return index;
    
    }
}

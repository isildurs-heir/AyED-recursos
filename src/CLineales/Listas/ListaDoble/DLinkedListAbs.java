package CLineales.Listas.ListaDoble;

import CLineales.operaciones.OperacionesCL2P;
import CLineales.recursos.DNode;

public abstract class DLinkedListAbs implements OperacionesCL2P {
    protected DNode first,last;
    protected int size;

    public DLinkedListAbs(){
        this.size = 0;
    }

    @Override
    public Object get(int index) {
        Object element = null;
        if(!this.isEmpty()){
            if(index <= this.size()-1 && index >= 0){
                if(index == 0){
                    element = this.first.getInfo();
                }
                else if(index == this.size()-1){
                    element = this.last.getInfo();
                }
                else{
                    DNode temp = this.first;
                    for(int i=0;i<index;i++){
                        temp = temp.getNext();
                    }
                    element = temp.getInfo();
                }
            }
            else{
                System.err.println("Posicion invalida.");
            }
        }
        else{
            System.err.println("Lista vacia.");
        }

        return element;
    }

    @Override
    public void delete(int index) {
        if(!this.isEmpty()){
            if(index < this.size() || index > 0){
                if(index == 0){
                    this.first = this.first.getNext();
                    if(this.first != null){
                        this.first.setPrev(null);
                    }
                    else{
                        this.first = this.last = null;
                    }
                }
                else if(index == (this.size()-1)){
                    this.last = this.last.getPrev();
                    this.last.setNext(null);
                }
                else{
                    DNode temp,prev,next;
                    temp = this.first.getNext();
                    while(index-1 > 0){
                        temp = temp.getNext();
                        index--;
                    }
                    prev = temp.getPrev();
                    next = temp.getNext();
                    prev.setNext(next);
                    next.setPrev(prev);
                }
                this.size--;
            }
            else{
                System.out.println("Error. Posicion invalida");
            }

        }
        else{
            System.out.println("Error. Lista vacia");
        }
    }

    @Override
    public void clean() {
        this.first = this.last = null;    
    }

    @Override
    public boolean isEmpty() {
        return this.first == null;    
    }

    @Override
    public int size() {
        return this.size;    
    }

    @Override
    public void insert(int index, Object element) { //aqui contemplo si quiero insertar un dato al final de la lista
        DNode temp;
        if(index <= this.size() && index >= 0){  
            if(index == 0){
                if(this.isEmpty()){
                    this.first = new DNode(element);
                    this.last = this.first;
                }
                else{
                    temp = new DNode(element,null,this.first);
                    this.first = temp;
                }
            }
            else{
                if(index == this.size()){
                    temp = new DNode(element,this.last,null);
                    this.last.setNext(temp);
                    this.last = temp;
                }
                else{
                    DNode prev,next;
                    prev = null;
                    next = this.first;
                    for(int i=0; i<index; i++){
                        prev = next;
                        next = next.getNext();
                    }
                    temp = new DNode(element,prev,next);
                    prev.setNext(temp);
                    next.setPrev(temp);
                }
            }
            this.size++;
        }
        else{
            System.out.println("Error. Posicion invalida");
        }
    }

}

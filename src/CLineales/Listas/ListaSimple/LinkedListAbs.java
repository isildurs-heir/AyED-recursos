package CLineales.Listas.ListaSimple;

import CLineales.operaciones.OperacionesCL2P;
import CLineales.recursos.Node;


public abstract class LinkedListAbs implements OperacionesCL2P{

    protected Node node;
    protected int size;

    public LinkedListAbs(){
        this.node = null;
        this.size = 0;
    }

    @Override
    public boolean isEmpty() {
        return (this.node == null);
    }

    @Override
    public abstract void add(Object element);

    @Override
    public void delete(int index) {
        if(!this.isEmpty()){
            if(index <= this.size && index >= 0){
                if(index == 0){
                    this.node = this.node.getNext();
                }
                else{
                    Node prev, next;
                    next = this.node;
                    prev = null;
                    for(int i=0;i<index;i++){
                        prev = next;
                        next = prev.getNext();
                    }
                    if(next == null){
                        prev.setNext(null);
                    }    
                    else{
                        prev.setNext(next.getNext());
                    }              
                }
            }
            else{
                System.err.println("Posicion invalida.");
            }
        }
        else{
            System.err.println("Lista Vacia.");
        }
        this.decSize();
    }

    @Override
    public int size() {
        return this.size;
    }


    @Override
    public Object get(int index) {
        Object element = null;
        if(!this.isEmpty()){
            if(index <= this.size && index >= 0){        
                Node temp = this.node;
                for(int i=0;i<index;i++){
                    temp = temp.getNext();
                }
                element = temp.getInfo();
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
    public void insert(int index, Object element) {
        if(!this.isEmpty()){
            if(index <= this.size && index >=0){
                Node prev,next,nvo;
                next = this.node;
                prev = null;
                for(int i=0; i<index; i++){
                    prev = next;
                    next = next.getNext();
                }
                nvo = new Node(element);
                if(prev == null){
                    nvo.setNext(next);
                    this.node = nvo;
                }
                else if(next == null){
                    prev.setNext(nvo);
                }
                else{
                    prev.setNext(nvo);
                    nvo.setNext(next);
                }
            }
            else{
                System.err.println("Posicion Invalida");
            }
        }
        else{
            System.err.println("Lista vacia");
        }
    }

    
    @Override
    public void clean() {
        this.node = null;
    }

    @Override
    public void replace(int index, Object element) {
        if(!this.isEmpty()){
            if(index < this.size() && index >= 0){
                if(index == 0){
                    this.node.setInfo(element);
                }
                else{
                    Node temp = this.node.getNext();
                    while(index-1 > 0){
                        index--;
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

    protected void incSize(){
        this.size++;
    }

    protected void decSize(){
        this.size--;
    }


    /* consulta */
    public void muestra(){
        Node temp;
        if(!this.isEmpty()){
            temp = this.node;
            while(temp != null){
                System.out.println(temp.getInfo().toString());
                temp = temp.getNext();
            }
            System.out.println("------");
        }
    }
    
    public abstract boolean equals(Object element1, Object element2);
    
}

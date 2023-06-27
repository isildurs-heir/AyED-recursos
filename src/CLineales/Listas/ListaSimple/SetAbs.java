package CLineales.Listas.ListaSimple;

import CLineales.operaciones.OperacionesSet;
import CLineales.recursos.Node;

public abstract class SetAbs implements OperacionesSet {
    protected Node element;
    protected int cardinal;

    public SetAbs(){
        clean();
    }

    public abstract boolean equals(Object element1,Object element2);

    private Object getFirst(){
        Object element = null;
        if(!isEmpty()){
            element = this.element.getInfo();
            this.element = this.element.getNext();
            if(isEmpty()){
                clean();
            }
        }
        else{
            System.out.println("Error. COnjunto vacio");
        }
        return element;
    }

    @Override
    public boolean isEmpty() {
        return (this.element == null);    
    }

    @Override
    public void clean() {
        this.element = null;
        this.cardinal = 0;
    }

    @Override
    public int getCardinal() {
        return this.cardinal;
    }

    @Override
    public boolean contains(Object element) {
        Node temp;
        boolean response = false;
        if(!isEmpty()){
            temp = this.element;
            while(temp!=null && !equals(temp.getInfo(),element)){
                temp = temp.getNext();
            }
            if(temp != null){
                response = true;
            }
        }
        else{
            System.out.println("Error. Conjunto vacio");
        }
        return response;
    }

    @Override
    public void add(Object element) {
        if(!contains(element)){
            this.element = new Node(element,this.element);
            this.cardinal++;
        }
        else{
            System.out.println("Error. Elemento ya en el conjunto");
        }
    }

    @Override
    public void remove(Object element) {
        Node temp;
        if(!isEmpty()){
            if(contains(element)){
                temp = this.element;
                if(equals(temp.getInfo(),element)){
                    this.element = this.element.getNext();
                }
                else{
                    while(temp.getNext() != null && !equals(temp.getNext().getInfo(),element)){
                        temp = temp.getNext();
                    }
                    if(temp.getNext() != null){
                        temp.setNext(temp.getNext().getNext());
                    }
                }
                this.cardinal--;
                if(isEmpty()){
                    clean();
                }
            }
            else{
                System.out.println("Error. El elemento no esta en el conjunto");
            }
        }
        else{
            System.out.println("Error. Conjunto vacio.");
        }
    }

    @Override
    public void union(SetAbs set1, SetAbs set2) {
        Object temp;
        if(!set1.isEmpty() || !set2.isEmpty()){
            clean();
            while(!set1.isEmpty()){
                temp = set1.getFirst();
                add(temp);
            }
            while(!set2.isEmpty()){
                temp = set2.getFirst();
                if(!contains(temp)){
                    add(temp);
                }
            }
        }
        else{
            System.out.println("Error. Conjuntos vacios");
        }
        
    }

    @Override
    public void diff(SetAbs set1, SetAbs set2) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void intersection(SetAbs set1, SetAbs set2) {
        // TODO Auto-generated method stub
        
    }
}

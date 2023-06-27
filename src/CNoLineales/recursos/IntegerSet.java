package CNoLineales.recursos;

import CLineales.Listas.ListaSimple.SetAbs;
import CLineales.recursos.Node;

public class IntegerSet extends SetAbs {

    @Override
    public boolean equals(Object element1, Object element2) {
        int e1 = (int)element1;
        int e2 = (int)element2;
        return (e1 == e2);
    }
    
    public void muestra(){
        Node temp;
        temp = this.element;
        while(temp != null){
            System.out.println("Elemento "+temp.getInfo());
            temp = temp.getNext();
        }
    }
    
}

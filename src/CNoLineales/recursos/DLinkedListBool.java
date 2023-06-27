package CNoLineales.recursos;

import CLineales.Listas.ListaDoble.DLinkedListSimp;

public class DLinkedListBool extends DLinkedListSimp{

    @Override
    public boolean equals(Object element1, Object element2) {
        return (boolean)element1 == (boolean)element2;
    }
    
}

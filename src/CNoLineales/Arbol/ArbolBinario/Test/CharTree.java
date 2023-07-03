package CNoLineales.Arbol.ArbolBinario.Test;


import CNoLineales.Arbol.ArbolBinario.BinarySearchTree;



/**
 *
 * @author mithrandir
 */
public class CharTree extends BinarySearchTree{

    @Override
    public boolean major(Object element1, Object element2) {
        String e1 = (String)element1;
        String e2 = (String)element2;
        
        return e1.compareTo(e2) > 0;
    }

    @Override
    public boolean minor(Object element1, Object element2) {
        String e1 = (String)element1;
        String e2 = (String)element2;
        
        return e1.compareTo(e2) < 0;
    }

    @Override
    public boolean equals(Object element1, Object element2) {
        String e1 = (String)element1;
        String e2 = (String)element2;
        
        return e1.compareTo(e2) == 0;
    }

    public void print(Object element) {
        System.out.println(element.toString());
    }
    
}


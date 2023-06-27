package CNoLineales.Arbol.ArbolBinario;

public class IntegerTree extends BinarySearchTree{
    
    public IntegerTree(){
        super();
    }

    @Override
    public boolean equals(Object element1, Object element2) {
        int e1 = (int)element1;
        int e2 = (int)element2;
        
        return e1 == e2;
    }

    @Override
    public boolean major(Object element1, Object element2) {
        int e1 = (int)element1;
        int e2 = (int)element2;
        
        return e1 > e2;
    }

    @Override
    public boolean minor(Object element1, Object element2) {
        int e1 = (int)element1;
        int e2 = (int)element2;
        
        return e1 < e2;
    }
    
}

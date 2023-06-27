package CNoLineales.Arbol.ArbolBalanceado;

/**
 *
 * @author mithrandir
 */
public class IntegerAVLTree extends AVLTree {

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

    @Override
    public boolean equals(Object element1, Object element2) {
        int e1 = (int)element1;
        int e2 = (int)element2;
        return e1 == e2;
    }

    @Override
    public void print(Object element) {
        System.out.println("Nodo ->"+element.toString());
    }
    
}

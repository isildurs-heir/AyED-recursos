package CNoLineales.operaciones;

import CNoLineales.recursos.NodeBinaryTree;

public interface OperacionesAB {
    public void add(Object element);
    public boolean contains(Object element);
    public void delete(Object element);
    public boolean isEmpty();
    public void clean();
    public NodeBinaryTree get(Object element);
    public void muestraInOrder();
    public void muestraPreOrder();
    public void muestraPostOrder();
    public int leafCounter(NodeBinaryTree root);
    public int heightTree(NodeBinaryTree root);
    
}

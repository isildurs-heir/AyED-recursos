package CNoLineales.Arbol.ArbolBinario.Test.TP;

import CNoLineales.Arbol.ArbolBinario.BinarySearchTree;
import CNoLineales.recursos.NodeBinaryTree;

public class IntegerTree extends BinarySearchTree{
    
    public IntegerTree(){
        super();
    }
    
    public void complete(IntegerTree tree, int level){
        levelChecker(tree.getRoot(),level);
    }
    
    public void levelChecker(NodeBinaryTree node, int level){
        if(level > 0 && node != null){
            System.out.println("Analizo el nivel "+level);
            if(node.getLeftChild() == null){
                System.out.println("Nodo nullo, se agrega un 0 izquierdo");
                node.setLeftChild(new NodeBinaryTree(0));
            }
            if(node.getRigthChild() == null){
                System.out.println("Nodo nullo, se agrega un 0 derecho");
                node.setRigthChild(new NodeBinaryTree(0));
            }
            levelChecker(node.getLeftChild(),level-1);
            levelChecker(node.getRigthChild(),level-1);
        }
    }
    
    public int suma(NodeBinaryTree tree, int l1, int l2, int level){
        int aux = 0;
        if(tree != null){
            if(level == l1){
                aux = (int)tree.getInfo();
            }
            else if(level == l2){
                aux =-(int)tree.getInfo();
            }
            else{
                aux = 0;
            }
            if((level < l2) || (level < l1)){
                aux = aux + suma(tree.getLeftChild(),l1,l2,level+1) + suma(tree.getRigthChild(),l1,l2,level+1);
            }
        }
        return aux;
    }
    
    public boolean comprobarSumaDeNiveles(BinarySearchTree tree, int n1, int n2){
        boolean response = false;
        if(tree.getRoot() != null){
            response = (suma(tree.getRoot(),n1,n2,1) == 0);
        }
        return response;
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

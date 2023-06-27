package CNoLineales.Arbol.ArbolBinario;

import CNoLineales.operaciones.OperacionesAB;
import CNoLineales.recursos.NodeBinaryTree;


public abstract class BinaryTree implements OperacionesAB {
    protected NodeBinaryTree root;
    
    public BinaryTree(){
        this.root = null;
    }


    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public void clean() {
        root = null;
    }

    @Override
    public void muestraInOrder() {
        inOrder(this.root);
    }
    
    private void inOrder(NodeBinaryTree node){
        if(node != null){
            inOrder(node.getLeftChild());
            System.out.println(node.getInfo());
            inOrder(node.getRigthChild());
        }
    }

    @Override
    public void muestraPreOrder() {
        preOrder(this.root);
    }
    
    private void preOrder(NodeBinaryTree node){
        if(node != null){
            System.out.println(node.getInfo());
            preOrder(node.getLeftChild());
            preOrder(node.getRigthChild());
        }
    }

    @Override
    public void muestraPostOrder() {
        postOrder(this.root);
    }
    
    private void postOrder(NodeBinaryTree node){
        if(node != null){
            postOrder(node.getLeftChild());
            postOrder(node.getRigthChild());
            System.out.println(node.getInfo());
        }
    }

    @Override
    public int leafCounter(NodeBinaryTree root) {
        if(root != null){
            if(root.getLeftChild() == null && root.getRigthChild() == null){
                return 1;
            }
            else{
                return leafCounter(root.getLeftChild()) + leafCounter(root.getRigthChild());
            }
        }
        else{
            return 0;
        }
    }
    
    public int leafs(){
        return leafCounter(root);
    }

    @Override
    public int heightTree(NodeBinaryTree root) {
        int lHeight,rHeight;
        if(root != null){
            lHeight = heightTree(root.getLeftChild());
            rHeight = heightTree(root.getRigthChild());
            
            if(lHeight > rHeight){
                return lHeight + 1;
            }
            else{
                return rHeight + 1;
            }
        }
        else{
            return -1;
        }
    }
    
    public int height(){
        return heightTree(this.root);
    }
    
}

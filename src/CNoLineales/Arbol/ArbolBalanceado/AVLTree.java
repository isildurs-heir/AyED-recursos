package CNoLineales.Arbol.ArbolBalanceado;

import CNoLineales.recursos.NodeAVLTree;

/**
 *
 * @author mithrandir
 */
public abstract class AVLTree {
    protected NodeAVLTree root;
    
    public abstract boolean major(Object element1, Object element2);
    public abstract boolean minor(Object element1, Object element2);
    public abstract boolean equals(Object element1, Object element2);

    public abstract void print(Object element);
    
    public void add(Object element){
        this.root = insert(this.root,element);
    }
    
    public boolean isEmpty(){
        return this.root == null;
    }
    
    public void muestraInOrder(){
        if(!isEmpty()){
            inOrder(this.root);
        }
        else{
            System.out.println("Arbol vacio");
        }
    }
    
    public void inOrder(NodeAVLTree node){
        if(node != null){
            inOrder(node.getLeftChild());
            print(node.getInfo());
            inOrder(node.getRightChild());
        }
    }
    
    public void muestraPreOrder(){
        if(!isEmpty()){
            preOrder(this.root);
        }
        else{
            System.out.println("Arbol vacio");
        }
    }
    
    public void preOrder(NodeAVLTree node){
        if(node != null){
            print(node.getInfo());
            preOrder(node.getLeftChild());
            preOrder(node.getRightChild());
        }
    }
    
    public void muestraPostOrder(){
        if(!isEmpty()){
            postOrder(this.root);
        }
        else{
            System.out.println("Arbol vacio");
        }
    }
    
    public void postOrder(NodeAVLTree node){
        if( node != null){
            postOrder(node.getLeftChild());
            postOrder(node.getRightChild());
            print(node.getInfo());
        }
    }
    
    private static int height(NodeAVLTree node){
        if(node != null){
            return node.getHeight();
        }
        else{
            return -1;
        }
    }
    
    private static int max(int a, int b){
        if(a > b){
            return a;
        }
        else{
            return b;
        }
    }
    
    private NodeAVLTree insert(NodeAVLTree node, Object element){
        int b, left, right;
        if(node != null){
            if(major(node.getInfo(),element)){
                node.setLeftChild(insert(node.getLeftChild(),element));
                node = balance(node);
            }
            else{
                node.setRightChild(insert(node.getRightChild(),element));
                node = balance(node);
            }
        }
        else{
            node = new NodeAVLTree(element);
        }
        left = height(node.getLeftChild());
        right = height(node.getRightChild());
            
        b = max(left,right) + 1;
        node.setHeight(b);
        return node;
    }
    
    public NodeAVLTree balance(NodeAVLTree node){
        if(height(node.getLeftChild()) - height(node.getRightChild()) == 2){
            System.out.println("Hay desequilibrio a izquierda");
            if(height(node.getLeftChild().getLeftChild()) >= height(node.getLeftChild().getRightChild())){
                System.out.println("->RotSimple a derecha");
                return rotSimple(node,false);
            }
            else{
                System.out.println("->RotDoble a derecha");
                return rotDoble(node,false);
            }
        }   
        else if(height(node.getRightChild()) - height(node.getLeftChild()) == 2){
            System.out.println("Hay desequilibrio a derecha");
            if(height(node.getRightChild().getRightChild()) >= height(node.getRightChild().getLeftChild())){
                System.out.println("-> RotSimple a izquierda");
                return rotSimple(node,true);
            }
            else{
                System.out.println("->RotDoble a izquierda");
                return rotDoble(node,true);
            }
        }
        else{
            return node;
        }
    }
    
    public NodeAVLTree rotSimple(NodeAVLTree node, boolean selector){
        NodeAVLTree temp;
        if(selector){ //izquierda -> true 
            temp = node.getRightChild();
            node.setRightChild(temp.getLeftChild());
            temp.setLeftChild(node);
            
            node.setHeight(max(height(node.getLeftChild()),height(node.getRightChild()))+1);
            temp.setHeight(max(height(temp.getRightChild()),node.getHeight()) + 1);
        }
        else{
            temp = node.getLeftChild();
            node.setLeftChild(temp.getRightChild());
            temp.setRightChild(node);
            
            node.setHeight(max(height(node.getLeftChild()),height(node.getRightChild()))+1);
            temp.setHeight(max(height(temp.getLeftChild()),node.getHeight()) + 1);
        }
        return temp;
    }
    
    public NodeAVLTree rotDoble(NodeAVLTree node, boolean selector){
        if(selector){ //true -> izquierda
            System.out.println("Rotacion simple a derecha sobre el hijo derecho del nodo desequilibrado");
            System.out.println("Y rotacion simple a izquierda sobre el nodo desequilibrado");
            node.setRightChild(rotSimple(node.getRightChild(),false));
            return rotSimple(node,true);
        }
        else{
            System.out.println("Rotacion simple a izquierda sobre el hijo izquierdo del nodo desequilibrado");
            System.out.println("Y rotacion simple a derecho sobre el nodo desequilibrado");
            node.setLeftChild(rotSimple(node.getLeftChild(),true));
            return rotSimple(node,false);
            
        }
    }

}

package CNoLineales.Arbol.ArbolBinario;

import CNoLineales.recursos.NodeBinaryTree;

public abstract class BinarySearchTree extends BinaryTree {
    
    public BinarySearchTree(){
        super();
    }
    
    public abstract boolean equals(Object element1,Object element2);
    public abstract boolean major(Object element1,Object element2);
    public abstract boolean minor(Object element1,Object element2);

    @Override
    public void add(Object element) {
        NodeBinaryTree temp, prev;
        NodeBinaryTree node = new NodeBinaryTree(element);
        if(!isEmpty()){
            prev = null;
            temp = this.root;
            while(temp != null){
                prev = temp;
                if(major(temp.getInfo(),element)){
                    temp = temp.getLeftChild();
                }
                else{
                    temp = temp.getRigthChild();
                }
            }
            if(minor(prev.getInfo(),element) || equals(prev.getInfo(),element)){
                prev.setRigthChild(node);
            }
            else{
                prev.setLeftChild(node);
            }
        }
        else{
            this.root = node;
        }
    }

    @Override
    public boolean contains(Object element) {
        boolean response = false;
        NodeBinaryTree node = null;
        
        if(!isEmpty()){
            node = get(element);
            if(node != null){
                response = true;
            }
            else{
                System.out.println("Error. Arbol vacio");
            }
        }
        return response;
    }

    @Override
    public void delete(Object element) {
        NodeBinaryTree temp,prev,aux;
        temp = prev = aux = null;
        boolean response = false;
        if(!isEmpty()){
            if(contains(element)){
                prev = null;
                temp = this.root;
                // busco el elemento a eliminar
                while(temp != null && !equals(temp.getInfo(),element)){
                    prev = temp;
                    if(major(temp.getInfo(),element)){
                        temp = temp.getLeftChild();
                    }
                    else{
                        temp = temp.getRigthChild();
                    }
                }
                if(temp.getLeftChild() == null && temp.getRigthChild() == null){
                    //nodo a eliminar es hoja
                    if(prev == null){ // es un arbol solo con root
                        clean();
                    }
                    else{
                        if(prev.getLeftChild() == temp){
                            prev.setLeftChild(null);
                        }
                        else{
                            prev.setRigthChild(null);
                        }
                    }
                }
                else if(temp.getLeftChild() != null && temp.getRigthChild() != null){
                    //nodo a eliminar tiene dos hojas
                    aux = temp;
                    aux = temp.getLeftChild();
                    //con el hijo izquierdo busco el mayor de los menores
                    while(aux.getRigthChild() != null){
                        prev = aux;
                        aux = aux.getRigthChild();
                    }
                    temp.setInfo(aux.getInfo());
                    //el nodo a eliminar toma el valor del mayor de los menores
                    if(prev == temp){
                        prev.setLeftChild(aux.getLeftChild());
                    }
                    else{
                        prev.setRigthChild(aux.getLeftChild());
                    }
                }
                else{
                    //el nodo a eliminar tiene un hijo derecho
                    if(temp.getRigthChild() != null){
                        if(prev == null){
                            //root con rigth child
                            this.root = temp.getRigthChild();
                        }
                        else{
                            if(prev.getRigthChild() == temp){
                                prev.setRigthChild(temp.getRigthChild());
                            }
                            else{ //posible error
                                prev.setLeftChild(temp.getRigthChild());
                            }
                        }
                    }
                    else{
                        if(prev == null){
                            //nodo raiz con hijo izq
                            this.root = temp.getLeftChild();
                        }
                        else{
                            if(prev.getRigthChild() == temp){
                                prev.setRigthChild(temp.getLeftChild());
                            }
                            else{
                                prev.setLeftChild(temp.getLeftChild());
                            }
                        }
                    }
                }
            }
            else{
                System.out.println("Error. Elemento no esta en la lista.");
            }
        }
        else{
            System.out.println("Error. Arbol vacio");
        }
    }

    @Override
    public NodeBinaryTree get(Object element) {
        NodeBinaryTree response = null;
        if(!isEmpty()){
            NodeBinaryTree temp = this.root;
            while(temp != null && !equals(temp.getInfo(),element)){
                if(major(temp.getInfo(),element)){
                    temp = temp.getLeftChild();
                }
                else{
                    temp = temp.getRigthChild();
                }
            }
            if(temp != null){
                response = temp;
            }
        }
        else{
            System.out.println("Error. Arbol Vacio");
        }
        return response;
    }
    
}

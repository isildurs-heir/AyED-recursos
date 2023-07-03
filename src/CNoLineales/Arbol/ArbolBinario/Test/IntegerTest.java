package CNoLineales.Arbol.ArbolBinario.Test;


public class IntegerTest {
    public static void main(String[] args){
        IntegerTree myTree = new IntegerTree();
        myTree.clean();
        myTree.add(8);
        myTree.add(4);
        myTree.add(5);
        myTree.add(7);
        myTree.add(10);
        myTree.add(14);
        myTree.add(9);
        myTree.add(12);
        
        
        myTree.muestraInOrder();
        System.out.println("***");
        myTree.muestraPostOrder();
        System.out.println("***");
        myTree.muestraPreOrder();
        
        
    }
}

package CNoLineales.Arbol.ArbolBinario;

public class Test {
    public static void main(String[] args){
        IntegerTree myTree = new IntegerTree();
        myTree.clean();
        myTree.add(10);
        myTree.add(20);
        myTree.add(15);
        myTree.add(30);
        myTree.add(10);
        myTree.muestraInOrder();
        System.out.println("***");
        myTree.muestraPostOrder();
        System.out.println("***");
        myTree.muestraPreOrder();
        
        
    }
}

package CNoLineales.Arbol.ArbolBinario.Test.TP;


public class IntegerTest {
    public static void main(String[] args){
        IntegerTree myTree = new IntegerTree();
        IntegerTree t2;
        myTree.clean();
        myTree.add(3);
        myTree.add(1);
        myTree.add(4);
        myTree.add(2);
        
        /*if(myTree.comprobarSumaDeNiveles(myTree, 1, 1)){
            System.out.println("CUmple");
        }
        else{
            System.out.println("No cumple");
        }*/
        
        
        //hacer ejercicio 5
        myTree.complete(myTree, 2);
        
        /*myTree.muestraInOrder();
        System.out.println("***");*/
        /*myTree.muestraPostOrder();
        System.out.println("***");*/
        myTree.muestraPreOrder();
        
        
    }
}

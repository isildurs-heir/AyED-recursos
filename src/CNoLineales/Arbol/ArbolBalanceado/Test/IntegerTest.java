package CNoLineales.Arbol.ArbolBalanceado.Test;


/**
 *
 * @author mithrandir
 */
public class IntegerTest {
   public static void main(String[] args){
       IntegerAVLTree t1 = new IntegerAVLTree();
       t1.add(4);
       t1.add(2);
       t1.add(5);
       t1.add(1);
       t1.add(3);
       t1.add(9);
       t1.add(11);
       t1.add(7);
       t1.add(8);
       t1.muestraInOrder();
       System.out.println("***");
       t1.muestraPostOrder();
       System.out.println("***");
       t1.muestraPreOrder();
   } 
}

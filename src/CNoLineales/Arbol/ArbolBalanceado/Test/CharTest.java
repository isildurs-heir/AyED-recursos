package CNoLineales.Arbol.ArbolBalanceado.Test;

/**
 *
 * @author mithrandir
 */
public class CharTest {
    public static void main(String[] args){
        CharAVLTree t1 = new CharAVLTree();
        t1.add("H");
        t1.add("D");
        t1.add("F");
        t1.add("M");
        t1.add("B");
        t1.add("X");
        t1.add("G");
        t1.add("T");
        t1.add("C");
        t1.add("L");
        t1.add("E");
        t1.muestraPreOrder();
    }
    
    
}

package CLineales.Cola.Test;

/**
 *
 * @author mithrandir
 */
public class Test {
    public static void main(String[] args){
        IntegerQueue q = new IntegerQueue(4);
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        
        for(int i=0; i<q.size(); i++){
            System.out.println(q.pop());
        }
    }
}

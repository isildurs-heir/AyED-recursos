package CLineales.recursos;

public class Node {
    private Object info;
    private Node next;

    public Node(Object info){
        this.info = info;
        this.next = null;
    }

    public Node(Object info, Node next){
        this.info = info;
        this.next = next;
    }

    public void setInfo(Object info){
        this.info = info;
    }

    public void setNext(Node next){
        this.next = next;
    }

    public Object getInfo(){
        return this.info;
    }

    public Node getNext(){
        return this.next;
    }
}

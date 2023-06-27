package CLineales.recursos;

public class DNode {
    private Object info;
    private DNode prev,next;

    public DNode(Object info){
        this.info = info;
        this.prev = this.next = null;
    }

    public DNode(Object info, DNode prev, DNode next){
        this.info = info;
        this.prev = prev;
        this.next = next;
    }

    public void setPrev(DNode prev){
        this.prev = prev;
    }

    public void setNext(DNode next){
        this.next = next;
    }

    public DNode getPrev(){
        return this.prev;
    }

    public DNode getNext(){
        return this.next;
    }

    public void setInfo(Object info){
        this.info = info;
    }

    public Object getInfo(){
        return this.info;
    }
}

package CNoLineales.recursos;

public class NodeBinaryTree {
    private Object info;
    private NodeBinaryTree leftChild,rigthChild;
    
    public NodeBinaryTree(){
        info = null;
        leftChild = rigthChild = null;
    }
    
    public NodeBinaryTree(Object info){
        this.info = info;
        leftChild = rigthChild = null;
    }
    
    public NodeBinaryTree(Object info, NodeBinaryTree leftChild, NodeBinaryTree rightChild){
        this.info = info;
        this.leftChild = leftChild;
        this.rigthChild = rightChild;
    }

    public Object getInfo() {
        return info;
    }

    public void setInfo(Object info) {
        this.info = info;
    }

    public NodeBinaryTree getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(NodeBinaryTree leftChild) {
        this.leftChild = leftChild;
    }

    public NodeBinaryTree getRigthChild() {
        return rigthChild;
    }

    public void setRigthChild(NodeBinaryTree rigthChild) {
        this.rigthChild = rigthChild;
    }
    
    
}

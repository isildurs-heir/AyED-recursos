package CNoLineales.recursos;

/**
 *
 * @author mithrandir
 */
public class NodeAVLTree {
    private Object info;
    private NodeAVLTree leftChild,rightChild;
    public int height;

    public NodeAVLTree(Object info) {
        this.info = info;
    }

    public NodeAVLTree(Object info, NodeAVLTree leftChild, NodeAVLTree rightChild) {
        this.info = info;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    public Object getInfo() {
        return info;
    }

    public void setInfo(Object info) {
        this.info = info;
    }

    public NodeAVLTree getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(NodeAVLTree leftChild) {
        this.leftChild = leftChild;
    }

    public NodeAVLTree getRightChild() {
        return rightChild;
    }

    public void setRightChild(NodeAVLTree rightChild) {
        this.rightChild = rightChild;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    
    
}

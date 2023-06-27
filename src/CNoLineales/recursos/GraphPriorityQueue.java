package CNoLineales.recursos;

import CLineales.Cola.PriorityQueue;
import CLineales.recursos.Node;

public class GraphPriorityQueue extends PriorityQueue {

    @Override
    public boolean minor(Object element1, Object element2) {
        Connection c1 = (Connection)element1;
        Connection c2 = (Connection)element2;
        return (c1.getConnectionCost() < c2.getConnectionCost());
    }

    @Override
    public boolean major(Object element1, Object element2) {
        Connection c1 = (Connection)element1;
        Connection c2 = (Connection)element2;
        return (c1.getConnectionCost() > c2.getConnectionCost());
    }

    @Override
    public boolean equals(Object element1, Object element2) {
        Connection c1 = (Connection)element1;
        Connection c2 = (Connection)element2;
        return (c1.getConnectionCost() == c2.getConnectionCost());
    }

    void muestra(){
        Node temp;
        Connection connection;
        if(!isEmpty()){
            temp = this.first;
            while(temp != null){
                connection = (Connection)temp.getInfo();
                System.out.println("Conexion : "+connection.getVertexI()+" - "+connection.getVertexJ()+": "+connection.getConnectionCost());
                temp = temp.getNext();
            }
        }
        else{
            System.out.println("Error muestra. Cola vacia.");
        }
    }
    
}

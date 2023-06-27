package CNoLineales.recursos;

import CNoLineales.operaciones.OperacionesG;
import java.util.ArrayList;

public abstract class GraphAbs implements OperacionesG {
protected MatrixGraph matrixCost;
    protected int order;
    protected static double infinite = 1000000;

    public GraphAbs(int order){
        this.order = order;
        this.matrixCost = new MatrixGraph(order);
    }

    public int getOrder(){
        return this.order;
    }

    public abstract void cargaGraph(ArrayList<String[]> data);
    public abstract void muestraGraph();

    public void bpf(DLinkedListBool markedList, int v){
        boolean marked;
        double currentCost;

        markedList.replace(v,true);
        System.out.println();
        System.out.println("Vertice: "+v);
        for(int w=0; w<getOrder(); w++){
            marked = (boolean)markedList.get(w);
            currentCost = (double)this.matrixCost.get(v,w);
            /*if(marked){
                System.out.println(w+" ya esta visitado\n.");
            }*/
            if(currentCost != infinite && !marked){
                System.out.println("arista visitada " + v + "->"+ w);
                bpf(markedList,w);
            } 
        }
    }

    @Override
    public void muestraBPF() {
        DLinkedListBool markedList;
        boolean marked;

        markedList = new DLinkedListBool();
        for(int v=0; v<getOrder(); v++){
            markedList.insert(v,false);
        }
        for(int v=0; v<getOrder(); v++){
            marked = (boolean)markedList.get(v);
            if(!marked){
                bpf(markedList,v);
            }
        }

    }

    private void bea(DLinkedListBool markedList,int v){
        boolean marked;
        double currentCost;
        Queue queue;
        int w;

        markedList.replace(v,true);
        System.out.println();
        System.out.println("Vertice: "+v);
        queue = new Queue();
        queue.add(v);
        while(!queue.isEmpty()){
            w = (int)queue.pop();
            for(int z=0; z<getOrder(); z++){
                marked = (boolean)markedList.get(z);
                currentCost = (double)this.matrixCost.get(w,z); //aqui
                if(currentCost != infinite && !marked){
                    System.out.println("arista visitada " + w + "->"+ z);
                    markedList.replace(z,true);
                    queue.add(z);
                }
            }
        }

    }

    @Override
    public void muestraBEA() {
        DLinkedListBool markedList;
        boolean marked;
        
        markedList = new DLinkedListBool();
        for(int v=0; v<getOrder(); v++){
            markedList.insert(v, false);
        }
        for(int v=0; v<getOrder(); v++){
            marked = (boolean)markedList.get(v);
            if(!marked){
                bea(markedList,v);
            }
        }
        
    }
    
}

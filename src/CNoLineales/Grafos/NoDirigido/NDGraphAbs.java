
package CNoLineales.Grafos.NoDirigido;

import CNoLineales.recursos.GraphAbs;

import CNoLineales.operaciones.OperacionesGND;
import CNoLineales.recursos.Connection;
import CNoLineales.recursos.DLinkedListBool;
import CNoLineales.recursos.GraphPriorityQueue;
import CNoLineales.recursos.IntegerSet;


public abstract class NDGraphAbs extends GraphAbs implements OperacionesGND {

    public NDGraphAbs(int order) {
        super(order);
    }

    @Override
    public void muestraGraph() {
        double currentCost;
        for(int i=0; i<getOrder(); i++){
            for(int j=0; j<getOrder(); j++){
                currentCost = (double)this.matrixCost.get(i,j);
                if(currentCost != infinite){
                    System.out.println("Costo " +i+ " a " +j+ "->"+currentCost);
                }
            }
        }
    }

    @Override
    public void muestraPrim(int vertex) {
        if(vertex >= 0 && vertex <getOrder()){
            Prim(vertex);
        }
    }

    private void Prim(int vertex){
        DLinkedListBool minCostList, nearbyList;
        minCostList = new DLinkedListBool();
        nearbyList = new DLinkedListBool();
        double minCost,currentCost,newCost;
        int minVertex,w;
        
        for(int i=0; i<getOrder(); i++){
            minCostList.insert(i,this.matrixCost.get(vertex,i));
            nearbyList.insert(i,vertex);
        }

        nearbyList.replace(vertex,-1);

        //primera etapa
        for(int i=1; i<getOrder(); i++){
            minCost = infinite;
            minVertex = -1;
            
            for (int j=0; j<getOrder(); j++){
                if((int)nearbyList.get(j) != -1 && (double)minCostList.get(j) != infinite){
                    currentCost = (double)minCostList.get(j);
                    if(currentCost<minCost){
                        minCost = currentCost;
                        minVertex = j;
                    }
                }
            }

            System.out.println("La arista "+nearbyList.get(minVertex)+" "+minVertex);
            minCostList.replace(minVertex,infinite); // marco como visitado (?)
            nearbyList.replace(minVertex,-1); //quito la posible conexion

            for(int j=0; j<getOrder(); j++){
                if(j != minVertex){
                    currentCost = (double)minCostList.get(j);
                    newCost = (double)this.matrixCost.get(minVertex,j);
                    w = (int)nearbyList.get(j);
                    if(newCost < currentCost && w > -1){
                        minCostList.replace(j,newCost);
                        nearbyList.replace(j,minVertex);
                    }
                }
            }
        }
    }

    @Override
    public void muestraKurskal() {
        Kruskal();
    }

    private void Kruskal(){
        double currentCost;
        int cnt,n,k,posI,posJ;
        boolean flag;
        Connection connection;
        
        GraphPriorityQueue queue = new GraphPriorityQueue();
        IntegerSet setE;
        IntegerSet setU;
        DLinkedListBool treeList = new DLinkedListBool();

        for(int i=0; i<getOrder(); i++){
            setE = new IntegerSet();
            setE.add(i);
            treeList.insert(i,setE);
        }

        for(int i=0; i< getOrder(); i++){
            for(int j=i+1; j<getOrder(); j++){
                currentCost = (double)this.matrixCost.get(i,j);
                if(currentCost != infinite){
                    queue.add(new Connection(i,j,currentCost));
                    System.out.println("Connexion de "+i+"a "+j+"con costo "+currentCost+" agregada a la cola");
                }
            }
        }
        
        System.out.println();
        System.out.println();

        cnt = getOrder();
        while(cnt>0){
            connection = (Connection)queue.pop();
            System.out.println("Arista "+connection.getVertexI()+" - "+connection.getVertexJ()+": "+connection.getConnectionCost());
            
            n = treeList.size()-1;
            k=0;
            flag = false;
            posI = posJ = -1;
            while(k<=n && !flag){
                setE = (IntegerSet)treeList.get(k);
                System.out.println("Mostrando conjunto parcial de vertices k="+k);
                setE.muestra();
                if(setE.contains(connection.getVertexI())){
                    posI = k;
                }
                if(setE.contains(connection.getVertexJ())){
                    posJ = k;
                }
                if(posI > 0 && posJ > 0 && posI == posJ){
                    flag = true;
                }
                else{
                    k++;
                }
            }
            if(!flag){
                System.out.println("Arbol minimo, Arista "+connection.getVertexI()+" "+connection.getVertexJ());
                setU = new IntegerSet();
                setU.union((IntegerSet)treeList.get(posI),(IntegerSet)treeList.get(posJ));
                treeList.replace(posI,setU);
                treeList.delete(posJ);
                cnt--;
            }
        }
    }
}

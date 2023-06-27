
package CNoLineales.Grafos.Dirigido;

import CNoLineales.recursos.GraphAbs;

import CNoLineales.operaciones.OperacionesGD;
import CNoLineales.recursos.DLinkedListBool;
import CNoLineales.recursos.MatrixGraph;

public abstract class DiGraphAbs extends GraphAbs implements OperacionesGD{

    protected MatrixGraph matrixCostF, matrixPathF;
    protected DLinkedListBool distList, pathList, solList;


    public DiGraphAbs(int order){
        super(order);
        matrixCostF = new MatrixGraph(order);
        matrixPathF = new MatrixGraph(order);
    }

    @Override
    public void muestraGraph() {
        double currentCost;
        for(int i=0; i<getOrder(); i++){
            for(int j=0; j<getOrder(); j++){
                if(i != j){
                    currentCost = (double)this.matrixCost.get(i,j);
                    if(currentCost != infinite){
                        System.out.println("Costo "+i+" a "+j+"->"+currentCost);
                    }
                }
            }
        }
    }

    private void Dijkstra(int startVertex){
        double minCost, currentCost, arcCost;
        int minVertex, vertex;

        this.distList = new DLinkedListBool();
        this.pathList = new DLinkedListBool();
        this.solList = new DLinkedListBool();

        for(int i=0; i<getOrder(); i++){
            this.solList.insert(i,-1);
            this.pathList.insert(i,-1);
            this.distList.insert(i,infinite);
        }
        this.solList.replace(startVertex,startVertex);

        for(int i=0; i<getOrder(); i++){
            if(i!=startVertex){
                this.distList.replace(i,this.matrixCost.get(startVertex,i));
                this.pathList.replace(i,startVertex);
            }
        }
        //etapa greedy (?)

        for(int i=0; i<getOrder(); i++){
            minCost = infinite;
            minVertex = -1;
            for(int w=0; w<getOrder(); w++){
                if(w != startVertex){
                    currentCost = (double)this.distList.get(w);
                    vertex = (int)this.solList.get(w);
                    if(currentCost < minCost && vertex == -1){
                        minCost = currentCost;
                        minVertex = w;
                    }
                }
            }
            //busca desde donde no fuimos, costos menores
            if(minVertex != -1){
                System.out.println("Nodo actual : "+minVertex);
                System.out.println("it "+startVertex+" minVertex " + minVertex + " minCost " + minCost);
                this.solList.replace(minVertex,minVertex);
                this.distList.replace(minVertex,minCost);
                for(int v=0; v<getOrder(); v++){
                    vertex = (int)this.solList.get(v);
                    if(vertex == -1){
                        arcCost = (double)this.matrixCost.get(minVertex,v);
                        currentCost = (double)this.distList.get(v);
                        if(minCost+arcCost < currentCost){
                            this.distList.replace(v,minCost+arcCost);
                            System.out.println("Actualizando distancia a vector "+v+" desde "+minVertex+" de "+currentCost+" a "+(minCost+arcCost));
                            this.pathList.replace(v,minVertex);
                        }
                    }
                }
            }
        }
    }

    @Override
    public void muestraDijkstra(int startVertex) {
        double currentCost;
        int w;
        Dijkstra(startVertex);
        for(int v=0; v<getOrder(); v++){
            if(v != startVertex){
                currentCost = (double)this.distList.get(v);
                System.out.println("\n-----Costo desde " + startVertex + " a " + v + "->" + currentCost+"-----");
                System.out.println("mostrando un camino desde " + v + " a " + startVertex);
                w = (int)this.pathList.get(v);
                do{
                    System.out.println("camino" + w);
                    w = (int)this.pathList.get(w);
                }while(w != -1);
            }
        }
        
    }

    @Override
    public void muestraFloyd() {
        this.matrixPathF = new MatrixGraph(order);
        this.matrixCostF = new MatrixGraph(order);
        double costF;
        for(int i=0; i<getOrder(); i++){
            matrixCostF.set(i,i,(double)0); // aqui
        }
        for(int  i=0; i<getOrder(); i++){
            for(int j=0; j<getOrder(); j++){
                if(i != j){
                    costF = (double)matrixCost.get(i,j);
                    matrixCostF.set(i,j,costF);
                }
            }
        }

        Object cost; //probar con double
        for(int k=0; k<getOrder(); k++){
            for(int i=0; i<getOrder(); i++){
                for(int j=0; j<getOrder(); j++){
                    if((double)matrixCostF.get(i,k) + (double)matrixCostF.get(k,j) < (double)matrixCostF.get(i,j)){ //aqui
                        cost = (double)matrixCostF.get(i,k) + (double)matrixCostF.get(k,j); //aqui
                        matrixCostF.set(i,j,cost);
                        matrixPathF.set(i,j,k); //aqui
                    }
                }
            }
        }

        System.out.println("Floyd: ");
        for(int i=0; i<getOrder(); i++){
            for(int j=0; j<getOrder(); j++){
                if(i != j){
                    costF = (double)matrixCostF.get(i,j);
                    if(costF != infinite){
                        System.out.println("Costo minimo de "+i+" hasta "+j+" es "+costF);
                    }
                }
            }
        }
    }

    public void muestraCaminoFloyd(int origin, int destiny){
        double possiblePath = (double)matrixCostF.get(origin,destiny);
        if(possiblePath != infinite){
            System.out.println("Camino entre"+origin+" y "+destiny +":");
            System.out.println(origin);
            buscarCaminoFloyd(origin,destiny);
            System.out.println(" "+destiny);
        }
        else{
            System.out.println("No hay camino entre "+origin+" y "+destiny);
        }
    }

    private void buscarCaminoFloyd(int i, int j){
        Integer value = (Integer)matrixPathF.get(i,j);
        if(value != null){
            int k = value;
            buscarCaminoFloyd(i, k);
            System.out.println(" "+k);
            buscarCaminoFloyd(k, j);
        }
        else{
            System.out.println(" | ");
        }
    }

    
}

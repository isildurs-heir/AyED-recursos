package CNoLineales.Grafos.Dirigido;


import CNoLineales.recursos.Reader;
import java.io.IOException;
import java.util.ArrayList; 

public class Test {
    public static void main(String[] args){
        DiGraph g1;
        ArrayList<String[]> data = new ArrayList<>();
        Reader r1 = new Reader();
        try{
            r1.leerArchivo(data);
            int orden = Integer.parseInt(data.get(0)[0]);
            data.remove(0);
            g1 = new DiGraph(orden);
            g1.cargaGraph(data);
            g1.muestraGraph();
            //g1.muestraBEA();  
            g1.muestraDijkstra(0);
            //g1.muestraFloyd();
            //g1.muestraCaminoFloyd(3,2);
        }
        catch(IOException | NumberFormatException e){
            e.printStackTrace();
        }
    }
}

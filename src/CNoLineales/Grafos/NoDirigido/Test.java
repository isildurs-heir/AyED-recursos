package CNoLineales.Grafos.NoDirigido;

import CNoLineales.recursos.Reader;
import java.util.ArrayList;

public class Test {
    public static void main(String[] args){
        NDGraph g1;
        ArrayList<String[]> data = new ArrayList<>();
        Reader r1 = new Reader();
        try{
            r1.leerArchivo(data);
            int orden = Integer.parseInt(data.get(0)[0]);
            data.remove(0);
            g1 = new NDGraph(orden);
            g1.cargaGraph(data);
            g1.muestraGraph();
            //g1.muestraBEA();
            //g1.muestraPrim(0);
            g1.muestraKurskal();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}

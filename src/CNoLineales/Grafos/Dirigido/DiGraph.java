package CNoLineales.Grafos.Dirigido;

import java.util.ArrayList;

public class DiGraph extends DiGraphAbs {

    public DiGraph(int order) {
        super(order);
    }

    @Override
    public void cargaGraph(ArrayList<String[]> data) {
        double currentCost;
        System.out.println(getOrder());
        for (int i = 0; i < getOrder(); i++) {
            String[] info = data.get(i);
            int k=0;
            for (int j = 0; j < getOrder(); j++) {
                if (i != j) {
                    currentCost = Double.parseDouble(info[k]);
                    if (currentCost != -1) {
                        this.matrixCost.set(i, j, currentCost);
                    } else {
                        this.matrixCost.set(i, j, infinite);
                    }
                    k++;
                } else {
                    this.matrixCost.set(i, j, infinite);
                }
            }
        }
    }
    
}

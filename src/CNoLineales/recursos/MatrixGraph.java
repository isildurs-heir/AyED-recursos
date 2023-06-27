package CNoLineales.recursos;


public class MatrixGraph extends MatrixArr {

    public MatrixGraph(int order) {
        super(order, order);
    }

    public boolean areConnected(int i, int j){
        boolean response = false;
        if(i>=0 && i<getRows() && j>=0 && j<getCols()){
            if(this.matrix[i][j] != null){
                response = true;
            }
        }
        return response;
    }

    
}

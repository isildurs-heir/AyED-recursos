package CNoLineales.recursos;

public class MatrixArr {
    protected Object[][] matrix;
    protected int rows,cols;
    
    public MatrixArr(int rows, int cols){
        this.rows = rows;
        this.cols = cols;
        matrix = new Object[this.rows][this.cols];
    }

    public int getRows(){
        return this.rows;
    }

    public int getCols(){
        return this.cols;
    }

    public void clean(){
        for(int i=0; i<getRows(); i++){
            for(int j=0;j<getCols(); j++){
                this.matrix[i][j] = null;
            }
        }
    }
    
    public void set(int row, int col, Object element){
        if(row >= getRows() || row < 0){

        }else if(col >= getCols() || col < 0){
            
        }else{
            this.matrix[row][col] = element;
        }
    }

    public Object get(int row, int col){
        Object element = null;
        if(row >= getRows() || row < 0){

        }else if(col >= getCols() || col < 0){
            
        }else{
            element = this.matrix[row][col];
        }
        return element;
    }
}

import java.util.ArrayList;
public class PrintMatrix {
    public static ArrayList<Integer> list = new ArrayList<Integer>();
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        list.clear();
       if(matrix.length<=0||matrix[0].length<=0)
           return null;
        int start = 0;
        while(matrix[0].length > start*2 && matrix.length>start*2){
            PrintMatrixInCircle(matrix, matrix[0].length, matrix.length, start);
            ++start;
        }
        return list;
    }
    public void PrintMatrixInCircle(int[][]matrix, int columns, int rows, int start){
        int endX = columns - 1- start;
        int endY = rows - 1-start;
        //从左到右打印一行
        for(int i=start; i<=endX; i++){
            int number = matrix[start][i];
            list.add(number);
        }
        //从上到下打印一列
        if(start<endY){
            for(int i=start+1; i<=endY; i++){
                int number = matrix[i][endX];
                list.add(number);
            }
        }
        //从右到左打印一行
        if(start<endX&& start<endY){
            for(int i=endX-1; i>=start; i--){
                int number = matrix[endY][i];
                list.add(number);
            }
        }
        //从下到上打印一列
        if(start<endX && start<endY-1){
            for(int i = endY-1; i>= start+1; i--){
                int number = matrix[i][start];
                list.add(number);
            }
        }
    }
}

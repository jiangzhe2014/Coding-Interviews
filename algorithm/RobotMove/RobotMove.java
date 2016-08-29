public class RobotMove {
    public int movingCount(int threshold, int rows, int cols)
    {
        boolean[] visited = new boolean[rows*cols];
        for(int i=0; i<rows*cols; i++){
            visited[i] = false;
        }
        int count = movingCountCore(threshold, rows, cols, 0, 0, visited);
        return count;
        
    }
    
    public int movingCountCore(int threshold, int rows, int cols, int row, int col, boolean[] visited){
        int count =0;
        if(check(threshold, rows, cols, row, col, visited)){
            visited[row*cols +col]=true;
            count = 1+movingCountCore(threshold, rows, cols, row-1, col, visited)
                + movingCountCore(threshold, rows, cols, row+1, col, visited)
                + movingCountCore(threshold, rows, cols, row, col-1, visited)
                + movingCountCore(threshold, rows, cols, row, col+1, visited);
        }
        return count;
    }
    //用来判断机器人能否进入坐标(row,col)的方格
    public boolean check(int threshold, int rows, int cols, int row, int col, boolean[] visited){
        if(row>=0 && row<rows && col>=0 && col<cols && getDigitSum(row)+getDigitSum(col) <= threshold && !visited[row*cols+col])
            return true;
        return false;
    }
    //用来得到一个数字的数位之和
    public int getDigitSum(int number){
        int sum =0;
        while(number >0){
            sum+=number%10;
            number /=10;
        }
        return sum;
    }
}

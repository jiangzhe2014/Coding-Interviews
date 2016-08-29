## 问题描述
```
地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格
，但是不能进入行坐标和列坐标的数位之和大于k的格子。 例如，当k为18时，机器人能够进入方格（35,37），因为 
3+5+3+7 = 18。但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？ 
```

## Solution
这个题同样用回溯法解决。这个方格可以看出是一个m*n的矩阵，同样在这个矩阵中，除边界上的格子外其余格子都有
四个相邻的格子。机器人从坐标（0,0）开始移动，当它准备进入坐标为(i,j)的格子时，通过检查坐标的数位和来判断
机器人是否能够进入。如果机器人能够进入坐标为(i,j)的格子，我们接着再判断它能否进入四个相邻的格子(i, j-1)、
(i-1,j)、(i,j+1)、(i+1,j)。

## Code
```
public class Solution {
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
    
    public boolean check(int threshold, int rows, int cols, int row, int col, boolean[] visited){
        if(row>=0 && row<rows && col>=0 && col<cols && getDigitSum(row)+getDigitSum(col) <= threshold && !visited[row*cols+col])
            return true;
        return false;
    }
    
    public int getDigitSum(int number){
        int sum =0;
        while(number >0){
            sum+=number%10;
            number /=10;
        }
        return sum;
    }
}
```

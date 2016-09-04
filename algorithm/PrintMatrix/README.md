## Description
```
输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，例如，如果输入如下矩阵：
1  2  3  4
5  6  7  8
9  10 11 12
13 14 15 16
则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
```
## Solution
可以用一个循环来打印矩阵，每次打印矩阵中的一个圈。每次选取左上角的（start，start）作为一圈的起始点，让循环继续的条件是columns>startX×2
并且rows>startY×2。我们把打印一圈分为四步：第一步从左到右打印一行，第二步从上到下打印一列，第三步从右到左打印一行，第四步从下到上打印
一列。每一步根据起始坐标和终止坐标用一个循环就能打印出一行或一列。**注意**最后一圈有可能退化成只有一行、只有一列甚至只有一个数字，因此
打印一圈就不再需要四步。<br>
打印每一步的前提条件：第一步总是需要的，因为打印一圈至少有一步。如果只有一行，那么就不用第二步了，也就是说需要第二步的前提条件是终止
行号大于起始行号。需要第三步的前提条件是圈内至少有两列两行，即除了要求终止行号大于起始行号之外，还要求终止列号大于起始列号。同理，需要
打印第四步的前提条件是至少有三行两列，因此要求终止行号比起始行号至少大于2，同时终止列号大于起始列号。
## Code 
```
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
```

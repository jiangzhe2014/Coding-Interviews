## Description
```
请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一个格子开始，
每一步可以在矩阵中向左，向右，向上，向下移动一个格子。如果一条路径经过了矩阵中的某一个格子，则该路径不能再进入
该格子。 例如 a b c e s f c s a d e e 矩阵中包含一条字符串"bcced"的路径，但是矩阵中不包含"abcb"路径，因为
字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子。 
```

## Solution
这是个可以用回溯法解决的典型问题。首先，在矩阵中任选一个格子作为路径的起点。假设矩阵中某个格子的字符
为ch并且这个格子对应于路径上的第i个字符。如果路径上的第i个字符不是ch，那么这个格子不能可能处于路径上
的第i个位置。如果路径上的第i个字符正好时ch，那么往相邻的格子寻找路径上的第i+1个字符。除了在矩阵边界
上的格子之外，其他格子都有4个相邻的格子。重复这个过程直到路径上的所有字符都在矩阵中找到相应的位置。
由于路径不能重复进入矩阵的格子，还需要定义和字符矩阵大小一样的布尔值矩阵，用来标识路径是否已经进入了
每个格子。

## Code
```
public class StringPathInMatrix {
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str)
    {
        if(matrix.length<=0 || rows<1 || cols<1 || str.length<=0)
            return false;
        boolean[] visited = new boolean[rows*cols];
        int pathLength = 0;
        for(int row=0; row<rows; row++){
            for(int col=0; col<cols; col++){
                if(hasPathCore(matrix, rows, cols, row, col, str, pathLength, visited)){
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean hasPathCore(char[] matrix, int rows, int cols, int row, int col, char[] str, int pathLength, boolean[] visited){
        if(pathLength==str.length)
            return true;
        boolean hasPath = false;
        if(row>=0 && row<rows && col>=0 && col<cols && matrix[row*cols+col]==str[pathLength] && !visited[row*cols+col]){
            pathLength++;
            visited[row*cols+col]=true;
            hasPath = hasPathCore(matrix, rows, cols, row, col-1, str, pathLength, visited)
                || hasPathCore(matrix, rows, cols, row, col+1, str, pathLength, visited)
                || hasPathCore(matrix, rows, cols, row-1, col, str, pathLength, visited)
                || hasPathCore(matrix, rows, cols, row+1, col, str, pathLength, visited);
            if(!hasPath){
                pathLength--;
                visited[row*cols+col]=false;
            }
        }
        return hasPath;
    }
}
```

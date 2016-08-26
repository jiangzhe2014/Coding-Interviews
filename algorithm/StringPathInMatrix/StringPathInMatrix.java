/**
 * 
 * @author jiang
 * 
 * 这是可以用回溯法解决的典型问题。
 *
 */
public class StringPathInMatrix {
	public boolean hasPath(char[] matrix, int rows, int cols, char[] str)
    {
		if(matrix.length<=0 || rows <1 || cols<1 || str.length<=0)
			return false;
		boolean[] visited = new boolean[rows*cols];
		int pathLength=0;
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
		if(pathLength == str.length)
			return true;
		boolean hasPath = false;
		if(row >= 0 && row<rows && col>=0 && col<cols && matrix[row*cols +col]==str[pathLength] && !visited[row*cols +col]){
			pathLength++;
			visited[row*cols +col] = true;
			hasPath = hasPathCore(matrix, rows, cols, row, col-1, str, pathLength, visited)
					|| hasPathCore(matrix, rows, cols, row-1, col, str, pathLength, visited)
					|| hasPathCore(matrix, rows, cols, row+1, col, str, pathLength, visited)
					|| hasPathCore(matrix, rows, cols, row, col+1, str, pathLength, visited);
			if(!hasPath){
				pathLength--;
				visited[row*cols+col]=false;
			}
		}
		return hasPath;
	}

}

public class Solution {
    public boolean Find(int [][] array,int target) {
		if(array.length==0||array[0].length==0)
			return false;
		int colume = array[0].length-1;
		int row = 0;
		while(colume>=0 && row<array.length){
			if(target == array[row][colume])
				return true;
			if(target>array[row][colume]){
				row++;
			}
			else if(target < array[row][colume]){
				colume--;
			}
		}
		return false;
    }
}

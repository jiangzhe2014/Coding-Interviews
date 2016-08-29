## Description
```
在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个
二维数组和一个整数，判断数组中是否含有该整数。
```

## solution
从二维数组的右上角或左下角开始比较，这样每次就可以去掉一行或一列，快速的缩小范围。


## code
```
public class FindInPartiallySortedMatrix {
    public boolean Find(int [][] array,int target) {
		if(array.length<=0)
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
```

## Description
```
把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。 
```
## Solution
旋转之后的数组实际上划分成两个排序的子数组，前面的子数组的元素都大于或等于后面子数组的元素。最小的元素刚好是这两个子数组
的分界线。在排序数组中我们可以用二分查找法实现O(logn)的查找。  
我们用两个指针分别指向数组的第一个元素和最后一个元素。按照题目中旋转的规则，第一个元素应该是大于或者等于最后一个元素的（
这是对于递增排序的数组而言，对于非递减数组而言要注意特例）。我们可以找到数组中间的元素，如果该中间元素位于前面的递增子数组，
那么它应该大于或者等于第一个指针指向的元素，此时数组中最小的元素应该位于该中间元素的后面。我们可以把第一个指针指向该中间
元素，这样可以缩小寻找范围。移动之后的第一个指针仍然位于前面的递增子数组中。同样对于第二个指针可做相似的操作。  
按照上述思路，第一个指针总是指向前面递增数组的元素，而第二个指针总是指向后面递增数组的元素。最终第一个指针将指向前面子数组的最后一个元素，而第二个指针会指向后面子数组的第一个元素。这两个指针最终会指向相邻的两个元素，而第二个指针指向的刚好是最小的元素，这就是循环结束的条件。<br>
对于例子：数组{1,0,1,1,1}和数组{1,1,1,0,1}都可以看成是递增排序数组{0,1,1,1,1}的旋转，在这两种情况下，当两个指针指向的数字及
它们中间的数字三者相等的时候，我们无法判断中间数字是位于前面的子数组中还是后面的子数组中，也就无法移动两个指针来缩小查找范围。
此时，不得不采用顺序查找的方法。


## Code
```
public class MinNumberInRotatedArray {
    public int minNumberInRotateArray(int [] array) {
    	if(array.length == 0)
            return 0;
        int index1 = 0;
        int index2 = array.length-1;
        //如果把数组的前0个元素搬到最后面，即排序数组本身，数组中的第一个数字就是最小的元素
        int mid = index1;
        while(array[index1]>=array[index2]){
            if(index2-index1==1){
                mid = index2;
                break;
            }
            mid = (index1+index2)/2;
            //如果下标index1,index2和mid指向的三个数字相等，则只能顺序查找
            if(array[index1]==array[index2] && array[index1]==array[mid]){
                return MinInOrder(array, index1, index2);
            }
            if(array[mid] >= array[index1]){
                index1 = mid;
            }
            else if(array[mid] <= array[index2]){
                index2 = mid;
            }
        }
        return array[mid];
    }
    public int MinInOrder(int[] array, int index1, int index2){
        int result = array[index1];
        for(int i=index1+1; i<= index2; i++){
            if(result < array[i])
                result = array[i];
        }
        return result;
    }
}
```

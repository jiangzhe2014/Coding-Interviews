## Description
```
输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有的偶数位于位于数组的后半部分，
并保证奇数和奇数，偶数和偶数之间的相对位置不变。 
```
## Solution
如果不要保证奇偶数各自之间的相对位置不变，我们可以用两个指针，一个指向数组的第一个数字，另一个指向数组的最后一个数字。分别
向后向前移动，如果第一个指针指向的数字是偶数，且第二个数字指向的数字是奇数，那么就交换这两个数字，直到两指针相遇为止。  
题目要求保证数据之间的相对位置不变，我们可以使用两个队列分别来保存奇数和偶数。当遍历完数组后，将奇数队列和偶数队列的数据
先后放入数组中即可。
## Code
```
public class ReorderArray {
    public void reOrderArray(int [] array) {
        if(array.length==0)
            return;
        Queue<Integer> queue1 = new LinkedList<Integer>();
        Queue<Integer> queue2 = new LinkedList<Integer>();
        for(int i=0; i<array.length; i++){
            if(array[i]%2==0)
                queue2.add(array[i]);
            else
                queue1.add(array[i]);
        }
        int i=0;
            while(!queue1.isEmpty()){
                array[i++] = queue1.remove();
            }
            while(!queue2.isEmpty()){
                array[i++] = queue2.remove();
            }
    }
}
```

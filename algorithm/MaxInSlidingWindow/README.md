## Description
```
给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，
那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}； 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个： 
{[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}， {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}，
{2,3,4,2,6,[2,5,1]}。 
```
## Solution
一个滑动窗口可以看作一个队列，符合队列先进先出的特性。我们可以用一个双端队列实现，并不是把滑动窗口的每个数值
都存入队列，而是只把有可能成为滑动窗口的数值存入到一个双端队列中。为了确定滑动窗口中是否包含这个数字，应该在
队列中存放数字在数组中的下标，而不是数值。当一个数字的下标与当前处理的数字的下标之差大于或者等于滑动窗口的大
小时，这个数字已经从窗口中滑出，可以从队列中删除了。滑动窗口的最大值总是在队列的头部。

## Code
```
public class MaxInSlidingWindow {
    public ArrayList<Integer> maxInWindows(int [] num, int size)
    {
        ArrayList<Integer> maxInWindows = new ArrayList<>();
        if(num.length >= size && size >=1){
        //dequeue是个双端队列，用来保存有可能是滑动窗口最大值的数字的下标。
            Deque<Integer> dequeue = new LinkedList<>();
            //存入一个数字之前，首先要判断队列里已有数字是否小于待存入的数字。
            //如果已有的数字小于待存入的数字，这些数字已经不可能是滑动窗口的最大值，因此将它们依次从队列的尾部删除。
           
            for(int i=0; i<size; i++){
                while(!dequeue.isEmpty() && num[i]>= num[dequeue.getLast()])
                    dequeue.removeLast();
                dequeue.addLast(i);
            }
            for(int i = size; i<num.length; i++){
                maxInWindows.add(num[dequeue.getFirst()]);
                while(!dequeue.isEmpty() && num[i]>= num[dequeue.getLast()])
                    dequeue.removeLast();
               //如果队列头部的数字已经从窗口中滑出，滑出的数字也需要从队列的头部删除。
                if(!dequeue.isEmpty() && dequeue.getFirst() <= i-size)
                    dequeue.removeFirst();
                dequeue.addLast(i);
            }
            maxInWindows.add(num[dequeue.getFirst()]);
        }
        return maxInWindows;
    }
}
```

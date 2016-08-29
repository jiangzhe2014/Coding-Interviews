import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class MaxInSlidingWindow {
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
	public static void main(String[] args) {
		int[] num = {2,3,4,2,6,2,5,1};
		int size = 3;
		System.out.println(new MaxInSlidingWindow().maxInWindows(num, size));
	}
}

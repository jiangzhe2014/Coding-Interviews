import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class MaxInSlidingWindow {
	public ArrayList<Integer> maxInWindows(int [] num, int size)
    {
		ArrayList<Integer> maxInWindows = new ArrayList<>();
		if(num.length >= size && size >= 1){
			Deque<Integer> queue = new LinkedList<>();
			for(int i=0; i<size; i++){
				while(!queue.isEmpty() && num[i] >= num[queue.getLast()])
					queue.removeLast();
				queue.addLast(i);
			}
			for(int i=size; i<num.length; i++){
				maxInWindows.add(num[queue.getFirst()]);
				while(!queue.isEmpty() && num[i] >= num[queue.getLast()])
					queue.removeLast();
				if(!queue.isEmpty() && queue.getFirst() <= i-size)
					queue.removeFirst();
				queue.addLast(i);
			}
			maxInWindows.add(num[queue.getFirst()]);
		}
		return maxInWindows;
    }
	public static void main(String[] args) {
		int[] num = {2,3,4,2,6,2,5,1};
		int size = 3;
		System.out.println(new MaxInSlidingWindow().maxInWindows(num, size));
	}
}

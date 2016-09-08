import java.util.*;

public class StackPushPopOrder {
    public boolean isPopOrder(int [] pushA,int [] popA) {
        if(pushA.length<=0||popA.length<=0)
            return false;
        Queue<Integer> queue = new LinkedList<Integer>();
        for(int i=0; i<pushA.length; i++){
            queue.add(pushA[i]);
        }
        Stack<Integer> stack = new Stack<Integer>();
        for(int i=0; i<popA.length; i++){
            if(queue.contains(popA[i])){
                while(queue.peek()!=popA[i])
                	stack.push(queue.remove());
                queue.remove();
                continue;
            }
            if(stack.isEmpty())
                return false;
            if(stack.peek()!=popA[i])
                return false;
            if(stack.peek()==popA[i])
                stack.pop();
        }
        return true;
    }
}

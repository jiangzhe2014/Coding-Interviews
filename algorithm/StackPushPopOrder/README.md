## Description
```
输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。假设压入栈的所有数字均不相等。
例如序列1,2,3,4,5是某栈的压入顺序，序列4，5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列
的弹出序列。（注意：这两个序列的长度是相等的）
```
## Solution
建立一个辅助栈，把输入的第一个序列中的数字依次压入该辅助栈，并按照第二个序列的顺序依次从辅助栈中弹出数字。<br>
如果下一个弹出的数字刚好是栈顶数字，那么直接弹出。如果下一个弹出的数字不在栈顶，我们把压栈序列中还没有入栈的数字压入辅助栈，
直到把下一个需要弹出的数字压入栈顶为止。如果所有的数字都压入栈了仍然没有找到下一个弹出的数字，那么该序列不可能是一个弹出序列。
## Code
```
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
```

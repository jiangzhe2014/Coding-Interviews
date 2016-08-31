## Description
```
用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
```

## Solution
这题的意图就是要求我们操作这两个“先进后出”的栈实现一个“先进先出”的队列。插入和删除元素我们要考虑几种情况怎么实现：

1. 往空的队列里添加、删除元素。

2. 往非空的队列里添加、删除元素。

3. 连续删除元素直至队列为空。

我们将stack1始终进行入栈操作相当于队列的入队操作，当队列出队操作时，就要考虑两种情况，当stack2为空时，我们将stack1中的元素
出栈放入stack2中并将stack2栈顶元素抛出就相当于出队操作。当stack2不为空时，我们直接从stack2中抛出栈顶元素即可。
## Code
```
public class QueueWithTwoStacks{
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
     
    public void push(int node) {
        stack1.push(node);
    }
     
    public int pop() {
        if(!stack2.isEmpty()){
            return stack2.pop();
        }
        if(!stack1.isEmpty()&&stack2.isEmpty()){
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());   
            }
            return stack2.pop();
        }
        return -1;
    }
}
```

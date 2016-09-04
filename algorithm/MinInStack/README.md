## Description
```
定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的min函数。在该栈中，调用min、push及pop的时间复杂度都是O(1).
```
## Solution
把每次最小元素（之前的最小元素和新压入栈的元素两者较小值）都保存起来放到另外一个辅助栈中。那么就能保证辅助栈的栈顶一直都是最小元素。
当最小元素从数据栈内被弹出之后，同时弹出辅助栈的栈顶元素，此时辅助栈的新栈顶元素就是下一个最小值。
## Code
```
public class MinInStack {
 
    Stack<Integer> mdata = new Stack<>();
    Stack<Integer> min = new Stack<>();
    public void push(int node) {
        mdata.push(node);
        if(min.isEmpty()||node<min.peek()){
            min.push(node);
        }
        else{
            min.push(min.peek());
        }
    }
     
    public void pop() {
        if(!mdata.isEmpty()){
            min.pop();
            mdata.pop();
        }
    }
     
    public int top() {
        return mdata.peek();
    }
     
    public int min() {
        return min.peek();
    }
}
```

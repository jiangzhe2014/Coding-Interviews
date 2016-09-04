import java.util.Stack;
 
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

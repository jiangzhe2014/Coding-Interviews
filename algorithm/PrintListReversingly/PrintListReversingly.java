import java.util.ArrayList;
import java.util.Stack;
class ListNode{
    int val;
    ListNode next = null;
    ListNode(int val){
        this.val = val;
    }
}

public class PrintListReversingly{
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        if(listNode == null)
            return list;
        Stack<Integer> stack = new Stack<>();
        while(list.node!=null){
            stack.push(listNode.val);
            listNode = listNode.next;
        }
        while(!stack.isEmpty()){
            list.add(stack.pop());
        }
        return list;
    }
}

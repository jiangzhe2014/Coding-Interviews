## Description
```
输入一个链表，从尾到头打印链表每个节点的值。 
```

## Solution
遍历的顺序是从头到尾，输出的顺序是从尾到头，这是典型的“后进先出”，可以用栈来实现。每经过一个结点时，把该结点放入栈中。
当遍历完整个链表后，再从栈顶开始逐个输出结点的值，此时顺序已经反转。

递归在本质上就是一个栈结构，也可以用递归来实现。每访问一个结点的时候，先递归输出它后面的结点，再输出该结点自身，这样
链表的顺寻也反转过来。

## Code
第一种方法用栈：
```
public class PrintListReversingly {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if(listNode==null)
            return list;
        Stack<Integer> stack = new Stack<Integer>();
        while(listNode!=null){
            stack.push(listNode.val);
            listNode = listNode.next;
        }
        
        while(!stack.isEmpty()){
            list.add(stack.pop());
        }
        return list;
    }
}
```
用递归：
```
public class PrintListReversingly{
    public void printList(ListNode listNode){
        if(ListNode != null){
            if(listNode.next!=null){
                printList(listNode.next);
            }
            System.out.println(listNode.val);
        }
    }
}
```

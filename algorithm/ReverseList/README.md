## Description
```
定义一个函数，输入一个链表的头结点，反转该链表后，输出链表的所有元素。链表的定义为：
class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
```
## Solution
为了防止链表在反转的过程中断开，我们需要定义3个指针，分别指向当前遍历到的节点、它的前一个结点及后一个结点。反转后链表的头结点
是原始链表的尾结点。
## Code
```
public class ReverseList {
    public ListNode reverseList(ListNode head) {
		ListNode reverseNode = null;
        ListNode node  = head;
        ListNode prev = null;
        while(node != null){
            ListNode pnext = node.next;
            if(pnext == null)
                reverseNode = node;
            node.next = prev;
            prev = node ;
            node = pnext;
        }
        return reverseNode;
    }
}
```

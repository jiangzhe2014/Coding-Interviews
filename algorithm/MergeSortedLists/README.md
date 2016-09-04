## Description
```
输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。链表结点定义如下：
class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
```
## Solution
从合并两个链表的头结点开始，比较两个链表的头结点的值大小，较小的那个就是合并后链表的头结点。继续合并剩余的节点，在两个链表中剩下
的结点依然是有序的，因此合并这两个链表的步骤和前面的步骤是一样的。可以用递归的方法去解决。
## Code
```
public class MergeSortedLists {
    public ListNode Merge(ListNode list1,ListNode list2) {
        if(list1 == null)
            return list2;
        else if(list2 == null)
            return list1;
        ListNode mergeHead = null;
        if(list1.val < list2.val){
            mergeHead = list1;
            mergeHead.next = Merge(list1.next, list2);
        }
        else{
            mergeHead = list2;
            mergeHead.next = Merge(list1, list2.next);
        }
        return mergeHead;
    }
}
```

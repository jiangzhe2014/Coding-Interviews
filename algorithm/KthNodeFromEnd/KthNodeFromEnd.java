class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

public class KthNodeFromEnd{
    public ListNode FindKthToTail(ListNode head,int k) {
		if(head == null || k<=0)
            return null;
        ListNode node = head;
        //如果链表长度小于k，返回null
        for(int i=0; i<k-1; i++){
            if(head.next!=null)
                head = head.next;
            else
                return null;
        }
        while(head.next != null){
            head = head.next;
            node = node.next;
        }
        return node;
    }
}

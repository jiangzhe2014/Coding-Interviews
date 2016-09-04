class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

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

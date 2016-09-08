import java.util.*;
class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

public class DeleteDuplicatedListNode {
    public ListNode deleteDuplication(ListNode pHead)
    {
        if(pHead == null)
            return null;
        ListNode preNode = null;
        ListNode node = pHead;
        while(node != null){
            ListNode pNext = node.next;
            if(pNext != null && node.val == pNext.val){
            	int value = node.val;
                ListNode toBeDel = node;
                while(toBeDel != null && toBeDel.val == value){
                    pNext = toBeDel.next;
                    if(preNode == null){
                        toBeDel = pNext;
                        pHead = toBeDel;
                        
                    }else{
                        preNode.next = toBeDel.next;
                        toBeDel = pNext;
                    }
                    node = pNext;
                }
            }
            else{
                preNode = node;
                node = pNext;
            }
        }
        return pHead;
    }
}

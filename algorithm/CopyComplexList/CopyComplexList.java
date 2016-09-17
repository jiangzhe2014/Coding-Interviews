class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}

public class CopyComplexList {
    public RandomListNode clone(RandomListNode pHead)
    {
        cloneNode(pHead);
        connectRandomNode(pHead);
        return ReconnectNodes(pHead);
    }
    //复制原始链表的任意结点N并创建新结点N',再把N'链接到N的后面
    public void cloneNode(RandomListNode pHead){
        RandomListNode node = pHead;
        while(node!=null){
            RandomListNode pcloneNode = new RandomListNode(0);
            pcloneNode.label = node.label;
            pcloneNode.next = node.next;
            pcloneNode.random = null;
            node.next = pcloneNode;
            node = pcloneNode.next;
        }
    }
    //如果原始链表上的节点N的random指向S，则它对应的复制节点N'的random指向S的下一个结点S'
    public void connectRandomNode(RandomListNode pHead){
        RandomListNode pNode = pHead;
        while(pNode!=null){
            RandomListNode cloneNode = pNode.next;
            if(pNode.random!=null){
                cloneNode.random = pNode.random.next;
            }
            pNode = cloneNode.next;
        }
    }
    //把第二步得到的链表拆分成两个链表，奇数位置上的结点组成原始链表，偶数位置上的结点组成复制出来的链表
    public RandomListNode reconnectNodes(RandomListNode pHead){
        RandomListNode pNode = pHead;
        RandomListNode cloneHead = null;
        RandomListNode cloneNode = null;
        if(pNode!=null){
            cloneNode = pNode.next;
            cloneHead = pNode.next;
            pNode.next = cloneNode.next;
            pNode = pNode.next;
        }
        while(pNode!=null){
            cloneNode.next = pNode.next;
            cloneNode = cloneNode.next;
            pNode.next = cloneNode.next;
            pNode = pNode.next;
        }
        return cloneHead;
    }
}

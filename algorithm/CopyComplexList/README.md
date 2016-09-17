## Description
```
输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），
返回结果为复制后复杂链表的head。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）\
public class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}
```
## Solution
第一步根据原始链表的每个结点N创建对应的N'，我们把N'链接在N的后面。<br>
第二步设置复制出来的结点的random，假设原始链表上的N的random指向结点S，那么其对应复制出来的N'是N的next指向的结点，
同样S'也是s的next指向的结点。<br>
第三步把这个长链表拆分成两个链表：把奇数位置的结点用next链接起来就是原始链表，把偶数位置的结点用next链接起来就是复制出来的链表。

## Code
```
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
```

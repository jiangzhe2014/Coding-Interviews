## 问题描述
```
给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。 
```
## Solution
如果一个结点有右子树，那么它的下一个结点就是它的右子树中的最左子结点。即从右子结点出发，一直沿着指向左子结点的指针，就能找到它的下一个结点。
如果一个结点没有右子树，如果该结点是它父结点的左子结点，那么它的下一节点就是它的父结点。
如果一个结点即没有右子树，并且它还是它父结点的右子结点。我们可以沿着指向父结点的指针一直向上遍历，直到找到一个是它父结点的左子结点的节点，
如果这个结点存在，那么这个结点的父结点就是要找的下一结点。

## Code
```
public class NextNodeInBinaryTrees {
    public static TreeLinkNode GetNext(TreeLinkNode pNode)
    {
    	if(pNode==null)
    		return null;
    	TreeLinkNode pNext = null;
    	if(pNode.right != null){
    		TreeLinkNode pRight = pNode.right;
    		while(pRight.left!=null){
    			pRight = pRight.left;
    		}
    		pNext = pRight;
    	}
    	else if(pNode.next != null){
    		TreeLinkNode pCurrent = pNode;
    		TreeLinkNode pParent = pNode.next;
    		while(pParent != null && pCurrent == pParent.right){
    			pCurrent = pParent;
    			pParent = pParent.next;
    		}
    		pNext = pParent;
    	}
		return pNext;
    }
}
```

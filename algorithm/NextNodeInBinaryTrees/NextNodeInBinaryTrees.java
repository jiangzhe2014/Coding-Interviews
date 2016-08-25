
class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}

/**
 * 
 * @author jiang
 * 
 * 如果一个结点有右子树，那么它的下一个结点就是它的右子树中的最左子结点。即从右子结点出发，一直沿着指向左子结点的指针，就能找到它的下一个结点。
 * 如果一个结点没有右子树，如果该结点是它父结点的左子结点，那么它的下一节点就是它的父结点。
 * 如果一个结点即没有右子树，并且它还是它父结点的右子结点。我们可以沿着指向父结点的指针一直向上遍历，直到找到一个是它父结点的左子结点的节点，
 * 如果这个结点存在，那么这个结点的父结点就是要找的下一结点。
 * 
 *
 */
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
    public static void main(String[] args) {
		TreeLinkNode root = new TreeLinkNode(8);
		TreeLinkNode r1 = new TreeLinkNode(6);
		TreeLinkNode r2 = new TreeLinkNode(10);
		TreeLinkNode r3 = new TreeLinkNode(5);
		TreeLinkNode r4 = new TreeLinkNode(7);
		TreeLinkNode r5 = new TreeLinkNode(9);
		TreeLinkNode r6 = new TreeLinkNode(11);
		root.left = r1;
		root.right = r2;
		r1.left = r3;
		r1.right = r4;
		r2.left = r5;
		r2.right = r6;
		root.next = null;
		r1.next = root;
		r2.next = root;
		r3.next = r1;
		r4.next = r1;
		r5.next = r2;
		r6.next = r2;
		r3.left = r3.right = r4.left = r4.right = r5.left = r5.right = r6.left = r6.right = null;
		
		TreeLinkNode node = GetNext(root);
		System.out.println(node.val);
	}
}

import java.util.ArrayList;

public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }
}


/**
 * 
 * @author jiang
 *
 *按照中序遍历的顺序遍历一棵二叉搜索树，遍历序列的数值是递增排序的，很容易找出它的第k大结点。
 */

public class KthNodeInBST {

	public ArrayList<TreeNode> list = new ArrayList<>();
	TreeNode KthNode(TreeNode pRoot, int k)
    {
        if(pRoot==null || k<=0){
            return null;
        }
        InorderSearch(pRoot);
        if(k>list.size()){
            return null;
        }
        else{
            return list.get(k-1);
        }
    }
    
    public void InorderSearch(TreeNode pRoot){
    	if(pRoot == null)
    		return;
    	InorderSearch(pRoot.left);
    	list.add(pRoot);
    	InorderSearch(pRoot.right);
    }
	    
	    
	public static void main(String[] args) {
		TreeNode root = new TreeNode(8);
		TreeNode n1 = new TreeNode(6);
		TreeNode n2 = new TreeNode(10);
		TreeNode n3 = new TreeNode(5);
		TreeNode n4 = new TreeNode(7);
		TreeNode n5 = new TreeNode(9);
		TreeNode n6 = new TreeNode(11);
		root.left = n1;
		root.right = n2;
		n1.left = n3;
		n1.right = n4;
		n2.left = n5;
		n2.right = n6;
		System.out.println(new KthNodeInBST().KthNode(root,8));
	}
}

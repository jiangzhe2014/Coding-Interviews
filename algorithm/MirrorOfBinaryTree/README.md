## Description
```
请完成一个函数，输入一个二叉树，该函数输出它的镜像，二叉树结点的定义如下：
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}
输入描述：
二叉树的镜像定义：源二叉树 
    	    8
    	   /  \
    	  6   10
    	 / \  / \
    	5  7 9 11
    	镜像二叉树
    	    8
    	   /  \
    	  10   6
    	 / \  / \
    	11 9 7  5
```
## Solution
从二叉树的镜像的定义中，我们可以得到求一棵二叉树镜像的过程为：我们先前序遍历这棵树的每个结点，如果遍历的结点有子结点，就交换
它的两个子结点。当交换完所有非叶子结点的左右子结点之后，就得到了树的镜像。
## Code
```
public class MirrorOfBinaryTree {
    public void Mirror(TreeNode root) {
        if(root==null)
            return;
        if(root.left==null&&root.right==null)
            return;
        TreeNode node = root.left;
        root.left = root.right;
        root.right = node;
        if(root.left!=null)
            Mirror(root.left);
        if(root.right!=null)
            Mirror(root.right);
    }
}
```

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
 
    public TreeNode(int val) {
        this.val = val;
    }
}

public class MirrorOfBinaryTree {
    public void Mirror(TreeNode root) {
        if(root == null)
            return;
        if(root.left == null && root.right == null)
            return;
        TreeNode node = root.left;
        root.left = root.right;
        root.right = node;
        if(root.left!=null)
            Mirror(root.left);
        if(root.rigth != null)
            Mirror(root.right);
    }
}

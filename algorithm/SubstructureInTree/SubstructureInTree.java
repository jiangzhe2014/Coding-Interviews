class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
 
    public TreeNode(int val) {
        this.val = val;
    }
}

//第一步在树A中找到和B的根结点的值一样的节点R，第二步再判断树A中以R为根结点的子树是不是包含和树B一样的结构。
public class SubstructureInTree {
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        boolean result = false;
        if(root1!=null && root2!=null){
            if(root1.val == root2.val)
                result = DoesTree1HaveTree2(root1, root2);
            if(!result)
                result = HasSubtree(root1.left,root2);
            if(!result)
                result = HasSubtree(root1.right, root2);
        }
        return result;
    }
     
    public boolean DoesTree1HaveTree2(TreeNode root1, TreeNode root2){
        if(root2==null)
            return true;
        if(root1==null)
            return false;
        if(root1.val!=root2.val)
            return false;
        return DoesTree1HaveTree2(root1.left,root2.left)&&DoesTree1HaveTree2(root1.right, root2.right);
    }
}

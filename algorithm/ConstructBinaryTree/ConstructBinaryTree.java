/**
 * Definition for binary tree
*/
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        TreeNode root = reConstructBinaryTree(pre, 0, pre.length-1, in, 0, in.length-1);
        return root;
        
    }
    /* 先序遍历第一个位置肯定是根节点node，
 
  中序遍历的根节点位置在中间p，在p左边的肯定是node的左子树的中序数组，p右边的肯定是node的右子树的中序数组
 
  另一方面，先序遍历的第二个位置到p，也是node左子树的先序子数组，剩下p右边的就是node的右子树的先序子数组
 
  分左右递归调用即可
 
*/
    public TreeNode reConstructBinaryTree(int[] pre, int startPre, int endPre, int[] in, int startIn, int endIn){
        if(startPre>endPre||startIn>endIn)
            return null;
        TreeNode root = new TreeNode(pre[startPre]);
        for(int i=startIn; i<=endIn; i++){
            if(pre[startPre]==in[i]){
                root.left = reConstructBinaryTree(pre, startPre+1, startPre+i-startIn, in, startIn, i-1);
                root.right = reConstructBinaryTree(pre, i-startIn+startPre+1, endPre,in,i+1,endIn);
            }
        }
        return root;
    }
}

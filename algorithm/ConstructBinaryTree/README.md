## Description
```
输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
```

## Solution
在二叉树的前序遍历序列中，第一个数字总是树的根结点的值。但在中序遍历序列中，根结点的值在序列的中间，左子树的结点的值位于根结点
的值的左边，而右子树的结点的值位于根结点的值的右边，因此我们需要扫描中序遍历序列，才能找到根结点的值。这样我们就在前序遍历和
中序遍历两个序列中，分别找到了左右子树对应的子序列。我们可以用同样的方法去构建左右子树，那么接下来的事情可以用递归的方法去完成。

## Code
```
public class ConstructBinaryTree {
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
```

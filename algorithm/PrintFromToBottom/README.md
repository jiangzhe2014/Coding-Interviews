## Description
```
从上往下打印出二叉树的每个节点，同层节点从左至右打印。
```
## Solution
这题考察的就是二叉树的层序遍历，可以借助队列来实现。每一次打印一个结点时，如果该结点有子结点，则把该结点的子结点放到一个队列的末尾。
接下来到队列的头部取出最早进入队列的结点，重复前面的操作，直至队列中所有的结点都被打印出来为止。
## Code
```
public class PrintFromTopToBottom {
    public ArrayList<Integer> printFromTopToBottom(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if(root==null)
            return list;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.remove();
            list.add(node.val);
            if(node.left!=null)
                queue.add(node.left);
            if(node.right!=null)
                queue.add(node.right);
        }
        return list;       
    }
}
```

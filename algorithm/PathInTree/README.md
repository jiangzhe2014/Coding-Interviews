## Description
```
输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。二叉树的定义如下：
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
    public TreeNode(int val) {
        this.val = val;
    }
}
```
## Solution
用前序遍历的方式访问某一结点时，我们把该结点添加到路径上，并累加该结点的值。如果该结点为叶结点并且路径中结点值的和刚好等于
输入的整数，则当前的路径符合要求，我们把它保存起来。如果当前结点不是叶结点，则继续访问它的子结点。当前结点访问结束后，递归
函数将自动回到它的父节点，因此我们在函数退出之前要在路径上删除当前结点并减去当前结点的值，以确保返回父结点时路径刚好是从根
结点到父结点的路径。保存路径的数据结构是一个栈。
## Code
```
public class PathInTree {
    public static ArrayList<ArrayList<Integer>> paths = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> findPath(TreeNode root,int target) {
        paths.clear();
        if(root==null)
            return paths;
        Deque<Integer> path = new LinkedList<Integer>();
        findPath1(root, target, path, 0);
        return paths;
    }
    
    public void findPath1(TreeNode root, int target, Deque<Integer> path, int currentNum){
        currentNum += root.val;
        path.addLast(root.val);
        //如果是叶结点，并且路径上结点的和等于输入的值，保存这条路径
        boolean isLeaf = root.left==null && root.right==null;
        if(currentNum == target && isLeaf){
            ArrayList<Integer> list = new ArrayList<Integer>();
            for(Integer pth:path){
                list.add(pth);
            }
            paths.add(list);
        }
        //如果不是叶结点，则遍历它的子结点
        if(root.left!=null)
            findPath1(root.left, target, path, currentNum);
        if(root.right!=null)
            findPath1(root.right, target, path, currentNum);
        //在返回到父结点之前，在路径上删除当前结点，并在currentNum中减去当前结点的值
        currentNum -= root.val;
        path.removeLast();
    }
}
```

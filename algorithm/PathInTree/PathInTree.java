import java.util.*;

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}

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

## 问题描述
```
给定一颗二叉搜索树，请找出其中的第k小的结点。例如， 5 / \ 3 7 /\ /\ 2 4 6 8 中，按结点数值大小顺序第三个结点的值为4。 
```

## Solution
按照中序遍历的顺序遍历一棵二叉搜索树，遍历序列的数值是递增排序的，很容易找出它的第k大结点。

## Code
```
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
}
```

## 问题描述
```
请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，
第三行按照从左到右的顺序打印，其他行以此类推。
例如：给出原始二叉树的层序为[[1],[2,3],[4,5,6,7],[8,9,10,11,12,13]],希望打印的顺序为
[[1],[3,2],[4,5,6,7],[13,12,11,10,9,8]]
```

## Solution
针对上述问题，我们可以看到奇数层的节点都是从左到右打印，偶数层的节点都是从右到左打印。我们可以用
两个栈去保存每层的节点，由于栈的特点是先进后出，所以对于奇数层的节点我们可以先让右孩子进栈再让左
孩子进展，而偶数层我们先让左孩子进栈再让右孩子进栈。一个栈的节点弹出将其孩子节点按照上述方案放入
另一个栈中，直至两个栈都为空结束。

## Code
```
public class PrintTreesInZigZag {
    public static  ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
    	ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
    	if(pRoot == null)
    		return lists;
    	Stack<TreeNode> stack1 = new Stack<>();
    	Stack<TreeNode> stack2 = new Stack<>();
    	stack1.add(pRoot);
    	int level = 1;
    	while(!stack1.isEmpty()|| !stack2.isEmpty()){
    		if(!stack1.isEmpty()&& stack2.isEmpty()){
    			level++;
    			ArrayList<Integer> list = new ArrayList<>();
    			while(!stack1.isEmpty()){
    				TreeNode node = stack1.pop();
    				//偶数层先放左孩子，再放右孩子
    				if(level%2==0){
    					if(node.left!=null){
    						stack2.add(node.left);
    					}
    					if(node.right!=null){
    						stack2.add(node.right);
    					}
    				}
    				//奇数层先放右孩子，再放左孩子
    				else{
    					if(node.right!=null){
    						stack2.add(node.right);
    					}
    					if(node.left!=null){
    						stack2.add(node.left);
    					}
    				}
    				list.add(node.val);
    			}
    			lists.add(list);
    		}
    		if(stack1.isEmpty() && !stack2.isEmpty()){
    			level++;
    			ArrayList<Integer> list = new ArrayList<>();
    			while(!stack2.isEmpty()){
    				TreeNode node = stack2.pop();
    				if(level%2==0){
    					if(node.left!=null){
    						stack1.add(node.left);
    					}
    					if(node.right!=null){
    						stack1.add(node.right);
    					}
    				}
    				else{
    					if(node.right!=null){
    						stack1.add(node.right);
    					}
    					if(node.left!=null){
    						stack1.add(node.left);
    					}
    				}
    				list.add(node.val);
    			}
    			lists.add(list);
    		}
    	}
    	return lists;
    }
    ```

import java.util.ArrayList;
import java.util.Stack;


class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}

public class PrintTreeInZigzag {
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
    				if(level%2==0){
    					if(node.left!=null){
    						stack2.add(node.left);
    					}
    					if(node.right!=null){
    						stack2.add(node.right);
    					}
    				}
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
    
    public static void main(String[] args) {
		TreeNode pRoot = new TreeNode(8);
		TreeNode n1 = new TreeNode(6);
		TreeNode n2 = new TreeNode(10);
		TreeNode n3 = new TreeNode(5);
		TreeNode n4 = new TreeNode(7);
		TreeNode n5 = new TreeNode(9);
		TreeNode n6 = new TreeNode(11);
		pRoot.left = n1;
		pRoot.right = n2;
		n1.left = n3;
		n1.right = n4;
		n2.left = n5;
		n2.right = n6;
		ArrayList<ArrayList<Integer>> lists = Print(pRoot);
		System.out.println(lists);
	}

}

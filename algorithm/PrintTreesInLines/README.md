##题目描述
```
从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
```

##Solution
```
使用两个队列作为辅助空间，每一层的节点放在一个队列中，初始将根节点放入一个队列中。
每次一个队列元素移除将其左右孩子节点放入另一个队列中，交叉访问，直至两个队列均为空
```

##Code
```
public class PrintTreesInLines{
    ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
        	Queue<TreeNode> queue1 = new LinkedList<TreeNode>();
        	Queue<TreeNode> queue2 = new LinkedList<TreeNode>();
        	ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        	//先将根节点放在一个队列中
        	if(pRoot!=null){
        		queue1.add(pRoot);
        	}
        	while(!queue1.isEmpty()||!queue2.isEmpty()){
        		if(!queue1.isEmpty()&&queue2.isEmpty()){
        			ArrayList<Integer> list = new ArrayList<>();
        			while(!queue1.isEmpty()){
        				TreeNode node = queue1.remove();
        				list.add(node.val);
        				if(node.left!=null){
        					queue2.add(node.left);
        				}
        				if(node.right!=null){
        					queue2.add(node.right);
        				}
        			}
        			lists.add(list);
        		}
        		if(queue1.isEmpty()&&!queue2.isEmpty()){
        			ArrayList<Integer> list = new ArrayList<>();
        			while(!queue2.isEmpty()){
        				TreeNode node = queue2.remove();
        				list.add(node.val);
        				if(node.left!=null){
        					queue1.add(node.left);
        				}
        				if(node.right!=null){
        					queue1.add(node.right);
        				}
        			}
        			lists.add(list);
        		}
        	}
        	return lists;
    }
}
```

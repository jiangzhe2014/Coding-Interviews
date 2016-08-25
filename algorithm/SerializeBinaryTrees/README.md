## 问题描述
```
请实现两个函数，分别用来序列化和反序列化二叉树 
```
## Solution
我们可以根据前序遍历的顺序来序列化二叉树，因为前序遍历是从根结点开始的，相应的反序列化也是从根结点开始的。
当在遍历二叉树碰到Null指针时，这些null指针序列化成一个特殊的字符（如‘#’）。此外，结点的数值之间用一个
特殊的字符（如',')隔开。

## Code
```
public class SerializeBinaryTrees {
	public StringBuffer sb = new StringBuffer();
	String Serialize(TreeNode root) {
        if(root == null){
        	sb.append("#,");
        	return sb.toString();
        }
        sb.append(root.val+",");
        sb.append(Serialize(root.left));
        sb.append(Serialize(root.right));
        return sb.toString();
	}
    TreeNode Deserialize(String str) {
		String[] nodes = str.split(",");
		Queue<String> queue = new LinkedList<>();
		for(String node : nodes){
			queue.add(node);
		}
		return preOrder(queue);
	} 
    
    TreeNode preOrder(Queue<String> queue){
    	String s = queue.poll();
    	if(s.equals("#")){
    		return null;
    	}
    	TreeNode root = new TreeNode(Integer.valueOf(s));
    	root.left = preOrder(queue);
    	root.right = preOrder(queue);
    	return root;
    }
}
```

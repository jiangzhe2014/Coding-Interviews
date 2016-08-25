## 问题描述
```
请实现一个函数，用来判断一颗二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
```

## Solution
通常遍历一棵树有三种算法，即前/中/后序遍历，这三种方式都是先遍历左子结点再遍历右子结点。
我们可以定义一种对称的遍历算法，让其先遍历右子结点再遍历左子结点。
有些特殊二叉树它所有的结点的值都一样。它的前序遍历和它前序遍历的对称遍历的序列一样，但是该二叉树不是对称的。
针对这种问题，我们可以在遍历二叉树时把遇到的Null指针也考虑进来就行了。
此处我们以前序遍历为例，发现可以通过比较二叉树的前序遍历序列和对称前序遍历序列来判断二叉树是不是对称的。
如果两个序列是一样的，那么二叉树就是对称的。

## Code
```
public class SymmetricalBinaryTree {
    boolean isSymmetrical(TreeNode pRoot)
    {
		return isSymmetrical(pRoot, pRoot);
    }
    boolean isSymmetrical(TreeNode pRoot1, TreeNode pRoot2){
    	if(pRoot1 == null && pRoot2 == null){
    		return true; 
    	}
    	if(pRoot1 == null || pRoot2 == null){
    		return false;
    	}
    	if(pRoot1.val != pRoot2.val){
    		return false;
    	}
    	return isSymmetrical(pRoot1.left, pRoot2.right) && isSymmetrical(pRoot1.right, pRoot2.left);
    }
}
```

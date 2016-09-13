## Description
```
输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则返回true,否则返回false。
假设输入的数组的任意两个数字都互不相同。
```
## Solution
在后序遍历得到的序列中，最后一个数字是树的根结点值。数组中前面的数字可以分为两部分：第一部分是左子树结点的值，它们都比根结点
的值小；第二部分是右子树结点的值，它们都比根结点的值大。对左右子树进行递归操作。<br/>
* 举一反三<br>
如果面试题要求处理一棵二叉树的遍历序列，我们可以先找到二叉树的根结点，再基于根结点把整棵树的遍历序列拆分成左子树对应的子序列
和右子树对应的子序列，接下来再递归地处理这两个子序列。

## Code
```
public class SquenceOfBST {
    public boolean verifySquenceOfBST(int [] sequence) {
        if(sequence.length<=0)
            return false;
        int length = sequence.length;
        int root = sequence[length-1];
        //在二叉搜索树中左子树的节点小于根节点
        int i=0;
        for(;i<length-1;i++){
            if(sequence[i]>root)
                break;
        }
        
        //在二叉搜索树中右子树的节点大于根节点
        int j=i;
        for(; j<length-1;j++){
            if(sequence[j]<root)
                return false;
        }
        //判断左子树是不是二叉搜索树
        boolean left = true;
        if(i>0){
            left = verifySquenceOfBST(Arrays.copyOfRange(sequence,0,i));
        }
        //判断右子树是不是二叉搜索树
        boolean right = true;
        if(i<length-1){
            right = verifySquenceOfBST(Arrays.copyOfRange(sequence,i, length-1));
        }
        return (left&&right);
    }
}
```

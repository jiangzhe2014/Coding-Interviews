## Description
```
我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？ 
```
## Solution
```
先把2*n的覆盖方法记为f(n),用第一个2*1的小矩形去覆盖大矩形的最左边时有两种选择，竖着放或者横着放。当竖着放时，右边还剩下
2*(n-1)的区域，这种情形下的覆盖方法记为f(n-1).当横着放时，当2*1的小矩形横着放在左上角时，左下角必须横着放一个2*1的小矩形
，而在右边还剩下2*(n-2)的区域，这种情形下的覆盖方法记为f(n-2)。因此f(n)=f(n-1)+f(n-2).这仍然是斐波那契数列。
```
## Code
```
public class RectCover{
    public int rectCover(int target) {
		if(target<=0)
            return 0;
        if(target==1)
            return 1;
        if(target ==2)
            return 2;
        return rectCover(target-1)+rectCover(target-2);
    }
}
```

## Description
```
一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。 
```
## Solution
这题是[上一题](../JumpFloor)的变种。根据题意可以得出f(n)=f(n-1)+f(n-2)+...+f(1). f(n-1)=f(n-2)+f(n-3)+...+f(1); ...可用归纳法得出f(n)=2f(n-1), 最终结果得出f(n)=2^(n-1).
## Code
```
public class JumpFloorII {
    public int jumpFloorII(int target) {
        if(target<=0)
            return 0;
        if(target == 1)
            return 1;
        return (int)Math.pow(2,target-1);
    }
}
```

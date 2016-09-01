## Description
```
一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
```
## Solution
其实该题可以看成是斐波那契数列的应用。<br>
首先考虑最简单的情况，如果只有1级台阶，那显然只有一种跳法。如果有2级台阶，那就有两种跳法：一种分两次跳每次跳一级；另一种就是一次跳两级。<br>
下面讨论一般情况，把n级台阶时的跳法看成是n的函数，记为f(n)。当n>2时，第一次跳的时候就有两种不同的选择：一是第一次只跳一级，
此时跳法数目等于后面剩下的n-1级台阶的跳法数目，即为f(n-1);另一种选择是第一次跳2级，此时的跳法数目等于后面剩下的n-2级台阶的
跳法数目，即为f(n-2)。因此n级台阶的不同跳法的总数f(n)=f(n-1)+f(n-2).不难看出这实际上就是斐波那契数列了。
## Code
```
public class JumpFloor {
    public int jumpFloor(int target) {
		if(target<1)
            return 0;
        if(target == 1)
            return 1;
        if(target == 2)
            return 2;
        return jumpFloor(target-1)+jumpFloor(target-2);
    }
}
```

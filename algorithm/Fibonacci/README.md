## Description
```
写一个函数，现在要求输入一个整数n，请你输出斐波那契数列的第n项。斐波那契数列的定义如下：
f(n) = 0, (n=0);
f(n) = 1, (n=1);
f(n) = f(n-1)+f(n-2), (n>1).
```

## Solution
使用递归方法很简单，但是不提倡使用，递归方法计算量太大，而且容易造成栈溢出。<br>
更简单的方法是从下往上计算，首先根据f(0)和f(1)算出f(2),再根据f(1)和f(2)算出f(3）……依次类推就可以算出第n项了。时间复杂度为O(n).

## Code
```
public class Fibonacci {
    public int fibonacci(int n) {
        /**第一种解法
        if(n<=0)
        	return 0;
        if(n==1)
        	return 1;
        return fibonacci(n-1)+fibonacci(n-2);
        */
        
        int[] result = new int[]{0,1};
        if(n<2)
            return result[n];
        int fibNMinOne = 1;
        int fibNMinTwo = 0;
        int fibN = 0;
        for(int i=2; i<=n; i++){
            fibN = fibNMinOne + fibNMinTwo;
            fibNMinTwo = fibNMinOne;
            fibNMinOne = fibN;
        }
        return fibN;
    }
}
```

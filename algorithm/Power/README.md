## Description
```
给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。不得使用库函数，同时不需要考虑大数问题。
```
## Solution
要注意底数为0且指数为负的情况。可以用以下公式求a的n次方：a^n = a^(n/2).a^(n/2) (n为偶数)，a^n = a^((n-1)/2).a^((n-1)/2) 
(n为奇数)。我们用右移运算法代替了除以2，用位与运算符代替了求余运算符(%)来判断一个数是奇数还是偶数。位运算的效率比乘除法
及求余运算的效率要高很多。
## Code
```
public class Power {
	public double power(double base, int exponent) throws Exception {
        if(exponent==0)
            return 1;
        if(base==0){
            if(exponent>0)
                return 0;
            if(exponent<0)
                throw new Exception("invalid paregrames");
        }
        double result = 1;
        int exp = exponent;
        if(exponent <0){
            exponent = 0-exponent;
        }
        while(exponent != 0){
            if((exponent&1) == 1)
                result *= base;
            base *= base;
            exponent >>= 1; //右移一位
        }
        return exp>0? result: 1/result;
  	}
}
```

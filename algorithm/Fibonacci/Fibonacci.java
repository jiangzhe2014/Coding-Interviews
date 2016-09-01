public class Fibonacci {
    public int Fibonacci(int n) {
        /**第一种解法
        if(n<=0)
        	return 0;
        if(n==1)
        	return 1;
        return Fibonacci(n-1)+Fibonacci(n-2);
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

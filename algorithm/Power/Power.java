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
	
	public static void main(String[] args) throws Exception {
		double base=2; 
		int exponent = 3;
		System.out.println(new Power().power(base, exponent));
	}
}

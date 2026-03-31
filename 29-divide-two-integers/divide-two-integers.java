class Solution {
    public int divide(int dividend, int divisor) {
        if(dividend == divisor) return 1;

        boolean isPositive = true;

        if((divisor < 0 && dividend >= 0) ||(divisor >= 0 && dividend < 0))
        isPositive = false;

        long n = Math.abs((long) dividend);
        long d = Math.abs((long) divisor);

        long quotient = 0;

        while(n >= d){
            int count = 0; 
            while(n >=( d <<(count+1))){
                count++;
            }
            quotient += 1L << count;
            n -= (d << count);
        }
        if(quotient == 1L << 31){
            return isPositive ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }
        return isPositive ? (int) quotient : (int) -quotient;
    }
}
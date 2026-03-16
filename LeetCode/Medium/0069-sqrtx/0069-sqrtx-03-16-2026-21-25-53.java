class Solution {
    public int mySqrt(int x) {

        if(x == 0 || x == 1) return x;
        int low = 0, high = x, ans = 0;

        while(high >= low){
            int mid = low + (high - low)/2;

            long sqrt = (long)mid * mid;

            if(sqrt == x) return mid;
            else if(sqrt < x){
                low = mid+1;
                ans = mid;
            }else{
                high = mid-1;
              //  ans = high;
            }
        }
        return ans;
    }
}
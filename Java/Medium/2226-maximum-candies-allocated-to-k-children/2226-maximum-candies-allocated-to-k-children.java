class Solution {
    public int maximumCandies(int[] candies, long k) {

        int low = 1;
        int high = 0;
          for(int c : candies){
            high = Math.max(high, c);
        }
        int ans = 0;

        while(high >= low){
            int mid = low + (high - low)/2;
            if(canDistribute(candies, k, mid)){
                ans = mid;
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return ans;
    }

   private boolean canDistribute(int[] candies, long k, int candy){
    long count = 0;

    for(int c: candies){
        count+= c/candy;
        if(count >= k) return true;
    }
    return false;
   }
}
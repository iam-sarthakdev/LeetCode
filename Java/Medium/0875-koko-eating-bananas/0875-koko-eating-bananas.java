class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = 0;
        for(int i = 0; i < piles.length; i++){
            if(piles[i] > high){
                high = piles[i];
            }
        }
        int ans = high;
        while(high >= low){
            int mid = low + (high - low)/2;
            int result = 0;
            for(int x : piles){
                result += Math.ceil((double)x / mid);
            }
            if(result <= h){
                ans = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return ans;
    }
}
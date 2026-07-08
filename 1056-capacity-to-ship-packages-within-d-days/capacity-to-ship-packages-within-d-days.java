class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low = 0, high = 0;
        for(int w : weights){
            low = Math.max(low, w);
            high += w;
        }
        int ans = high;
        while(high >= low){
            int mid = low + (high - low)/2;

            if(canContains(weights, days, mid)){
                ans = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return ans;
    }
    private boolean canContains(int[] weights, int days, int mid){
        int capacity = 0;
        int day = 1;

        for(int w : weights){
            if(capacity + w > mid){
                day++;
                capacity = 0;
            }
            capacity += w;
        }
        return day <= days;
    }
}
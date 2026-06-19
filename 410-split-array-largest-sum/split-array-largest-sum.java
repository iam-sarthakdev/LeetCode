class Solution {
    public int splitArray(int[] nums, int k) {
        int low = 0, high = 0;
        for(int num: nums){
            low = Math.max(low, num);
            high += num;
        }
        while(high > low){
            int mid = low + (high - low)/2;

            int pieces = countSubarrays(nums, mid);

            if(pieces > k){
                low = mid+1;
            }else{
                high = mid;
            }
        }
        return low;
    }
    private int countSubarrays(int[] nums, int maxSum){
        int currentSum = 0, count = 1;
        for(int num: nums){
            if(currentSum + num > maxSum){
                count++;
                currentSum = num;
            }else{
                currentSum += num;
            }
            
        }
        return count;
    }
}
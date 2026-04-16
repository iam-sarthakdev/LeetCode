class Solution {
    public int maxSubArray(int[] nums) {
        int currSum = 0, maxSum = Integer.MIN_VALUE;

        for(int i = 0; i < nums.length; i++){
            if(currSum + nums[i] < nums[i]){
                currSum = 0;
            }
                currSum += nums[i];
                maxSum = Math.max(currSum, maxSum);
        }
        return maxSum;
    }
}
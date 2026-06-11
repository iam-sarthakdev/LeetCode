class Solution {

    public int rob(int[] nums) {

        int n = nums.length;

        // if only one house exists
        if(n == 1) return nums[0];

        // case 1: rob houses from 0 → n-2
        int case1 = robRange(nums, 0, n-2);

        // case 2: rob houses from 1 → n-1
        int case2 = robRange(nums, 1, n-1);

        // choose the better option
        return Math.max(case1, case2);
    }

    // helper function: solves normal house robber
    private int robRange(int[] nums, int start, int end){

        int prev1 = 0; // dp[i-1]
        int prev2 = 0; // dp[i-2]

        for(int i = start; i <= end; i++){

            // option 1: rob current house
            int robCurrent = nums[i] + prev2;

            // option 2: skip current house
            int skipCurrent = prev1;

            int curr = Math.max(robCurrent, skipCurrent);

            // shift values for next iteration
            prev2 = prev1;
            prev1 = curr;
        }

        // best profit for this range
        return prev1;
    }
}
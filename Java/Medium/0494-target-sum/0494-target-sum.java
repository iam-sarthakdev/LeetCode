class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int totalSum = 0;
        for(int num : nums) totalSum += num;

        if(Math.abs(target) > totalSum) return 0;

        if((totalSum + target) % 2 != 0) return 0;
        int sum = (totalSum + target)/2;

        int[][] dp = new int[n+1][sum+1];

        // base case
        for(int i = 0; i <= n; i++){
            dp[i][0] = 1;
        }
        for(int j = 1; j <= sum; j++){
            dp[0][j] = 0;
        }
        for(int i = 1; i <= n; i++){
            for(int s = 0; s <= sum; s++){
                // if sum is smaller
                if(s < nums[i-1]){
                    dp[i][s] = dp[i-1][s];
                }else{
                    int notTake = dp[i-1][s];
                    int take = dp[i-1][s - nums[i-1]];
                    dp[i][s] = notTake + take;
                }
            }
        }
        return dp[n][sum];
    }
}
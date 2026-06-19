class Solution {
    public boolean canPartition(int[] nums) {
        int total = 0;
        for(int num : nums) total += num;

        if(total % 2 != 0) return false;

        int sum = total / 2;

        int n = nums.length;

        boolean[][] dp = new boolean[n + 1][sum + 1];

        // base case
        for(int i = 0; i <= n; i++){
            dp[i][0] = true;
        }
        for(int i = 0; i <= sum; i++){
            dp[0][i] = false;
        }

        for(int i = 1; i <= n; i++){
            for(int s = 1; s <= sum; s++){
                if(s < nums[i-1]){
                    dp[i][s] = dp[i-1][s];
                }else{
                    // element <= sum
                boolean notTake = dp[i-1][s];
                boolean take = dp[i-1][s - nums[i-1]];
                dp[i][s] = take || notTake;
                }
            }
        }
        return dp[n][sum];
    }
}
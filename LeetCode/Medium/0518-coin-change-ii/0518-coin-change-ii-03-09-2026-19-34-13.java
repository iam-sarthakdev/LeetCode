class Solution {
    Integer[][] dp;
    public int change(int amount, int[] coins) {
        int n = coins.length;
        dp = new Integer[n+1][amount+1];
        return solve(amount,coins, n);
    }
    private int solve(int amount, int[] coins, int n){
        // dp = new int[n+1][amount+1];
        if(amount == 0) return 1;
        if(n == 0) return 0;

        if(dp[n][amount] != null) return dp[n][amount];

        

        if(amount < coins[n-1]){
            return solve(amount, coins, n-1);
        }else{
            int notTake = solve(amount, coins, n-1);
            int take = solve(amount - coins[n-1], coins, n);
            dp[n][amount] = take + notTake;
        }
        return dp[n][amount];
    }
}
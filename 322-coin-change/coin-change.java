class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount == 0) return 0;
        int n = coins.length;
        int[][] dp = new int[n+1][amount+1];

        for(int i = 0; i <= n; i++){
            for(int a = 0; a <= amount; a++){
                dp[i][a] = 1000000;
            }
        }

        for(int i = 0; i <= n; i++){
            dp[i][0] = 0;
        }

        for(int i = 1; i <= n; i++){
            for(int a = 0; a <= amount; a++){
                if(a < coins[i-1]){
                    dp[i][a] = dp[i-1][a];
                }
                else{
                    int notTake = dp[i-1][a];
                    int take = 1 + dp[i][a-coins[i-1]];
                    dp[i][a] = Math.min(notTake, take);
                }
            }
        }
        if(dp[n][amount] == 1000000) return -1;
        return dp[n][amount];
    }
}
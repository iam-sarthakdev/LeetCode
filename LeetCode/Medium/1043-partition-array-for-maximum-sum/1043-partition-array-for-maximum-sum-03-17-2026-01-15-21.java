class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        
        int n = arr.length;
        int dp[] = new int[n];
        Arrays.fill(dp, -1);
        return solve(0, arr, k, dp);
    }
    private int solve(int i, int[] arr, int k, int[] dp){
        // base case
        int n = arr.length;
        if(i == n) return 0;

        if(dp[i] != -1) return dp[i];

        int len = 0;
        int max = Integer.MIN_VALUE;
        int maxSum = Integer.MIN_VALUE;

        for(int j = i; j < Math.min(i + k, n); j++){
            len++;
            max = Math.max(max, arr[j]);
            int sum  = max * len + solve(j + 1, arr, k, dp);
            maxSum = Math.max(maxSum, sum);
        }
        return dp[i] = maxSum;
    }
}
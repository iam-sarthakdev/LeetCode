class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n+2];
        arr[0] = 1;
        arr[n+1] = 1;
        for(int i = 0; i < n; i++){
            arr[i+1] = nums[i];
        }
        int[][] dp = new int[n+2][n+2];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        return solve(0, n + 1, arr, dp);
    }
    private int solve(int i, int j, int[] nums, int[][] dp){
        int n = nums.length;

        if(j - i <= 1) return 0;

        if(dp[i][j] != -1) return dp[i][j];
        int maxCost = 0;

        for(int k = i + 1; k < j; k++){
            int left = solve(i, k, nums, dp);
            int right = solve(k ,j ,nums, dp);
            int cost = nums[i] * nums[k] * nums[j];
            int total = left + cost + right;

            maxCost = Math.max(maxCost, total);
        }
        return dp[i][j] = maxCost;
    }
}
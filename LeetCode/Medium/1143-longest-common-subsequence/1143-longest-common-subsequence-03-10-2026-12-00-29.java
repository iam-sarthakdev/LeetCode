class Solution {
    int[][] dp;
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        
        dp = new int[n+1][m+1];
        
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }
        return dp(text1, text2, n, m);
    }
    private int dp(String x, String y, int n, int m){
        
        if(n == 0 || m == 0) return 0;

        if(dp[n][m] != -1) return dp[n][m];

        if(x.charAt(n-1) == y.charAt(m-1)){
            dp[n][m] =  1 + dp(x, y, n-1, m-1);
        }else{
            int choice1 = dp(x, y, n-1, m);
            int choice2 = dp(x, y, n, m-1);
            dp[n][m] =  Math.max(choice1, choice2);
            
        }
        return dp[n][m];
    }
}
class Solution {
    int n;
    int[][] dp;
    public int mergeStones(int[] stones, int k) {
        n = stones.length;
        if((n-1) % (k-1) != 0){
            return -1;
        }

        int[] pre = new int[n];
        pre[0] = stones[0];
        for(int i = 1; i<n; i++){
            pre[i] = pre[i-1]+stones[i];
        }

        dp = new int[n][n];
        for(int[] a : dp){
            Arrays.fill(a,-1);
        }
        return helper(stones,k,0,n-1, pre);
    }
    public int helper(int[] stones, int k, int i, int j, int[] pre){
        if(i == j){
            return 0;
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        } 

        int ans = Integer.MAX_VALUE;
        for(int a = i; a<j; a+=(k-1)){
            int left = helper(stones,k,i,a,pre);
            int right = helper(stones,k,a+1,j,pre);
            ans = Math.min(ans,left+right);
        }

        if((j-i) % (k-1) == 0){
            ans += pre[j]-(i == 0 ? 0 : pre[i-1]);
        }
        return dp[i][j] = ans;
    }
}
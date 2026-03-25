class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[][] prev = new int[2][k+1];

        for(int i = n - 1; i >= 0; i--){
            int[][] curr = new int[2][k+1];
            for(int buy = 0; buy <= 1; buy++){
                for(int cap = 1; cap <= k; cap++){

                    if(buy == 1){
                        int buyCurr = -prices[i] + prev[0][cap];
                        int skip = prev[1][cap];
                        curr[buy][cap] = Math.max(buyCurr, skip);
                    }else{
                        int sell = prices[i] + prev[1][cap-1];
                        int skip = prev[0][cap];
                        curr[buy][cap] = Math.max(sell, skip);
                    }
                }
            }
            prev = curr;
        }
        return prev[1][k];
    }
}
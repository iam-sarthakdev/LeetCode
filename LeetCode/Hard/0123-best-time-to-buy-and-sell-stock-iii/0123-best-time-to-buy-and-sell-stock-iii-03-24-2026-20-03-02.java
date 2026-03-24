class Solution {
    public int maxProfit(int[] prices) {
        int[][] ahead = new int[2][3];

        for(int i = prices.length - 1; i >= 0; i--){
            int[][] curr = new int[2][3];

            for(int buy = 0; buy <= 1; buy++){
            for(int cap = 1; cap <= 2; cap++){
                
                if(buy == 1){
                    int buyCurr = -prices[i] + ahead[0][cap];
                    int skip = ahead[1][cap];
                    curr[buy][cap] = Math.max(buyCurr, skip);
                }else{
                    int sell = prices[i] + ahead[1][cap-1];
                    int skip = ahead[0][cap];
                    curr[buy][cap] = Math.max(sell, skip);
                }
            }
        }
        ahead = curr;
        }
        return ahead[1][2];
    }
}
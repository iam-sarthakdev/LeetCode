class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int currentProfit = 0;
        int buyPrice = Integer.MAX_VALUE;

        for(int price : prices){

            if(price < buyPrice) buyPrice = price;

            if(price > buyPrice){
                currentProfit += price - buyPrice;
                buyPrice = price;
                maxProfit = Math.max(maxProfit, currentProfit);
            }
        }
        return maxProfit;
    }
}
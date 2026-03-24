class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int buyPrice = Integer.MAX_VALUE;

        for(int price : prices){

            if(price < buyPrice) buyPrice = price;

            if(price > buyPrice){
                profit += price - buyPrice;
                
            }
            buyPrice = price;
        }
        return profit;
    }
}
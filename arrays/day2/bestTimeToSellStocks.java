//Best time to buy and sell stock

/*
Need to choose minimum price of buying before selling
this can be done by maintaing minBuy
T.C-> (N)
 */
 {
    public int maxProfit(int[] prices) {
        int minBuy = prices[0], profit = 0; 
        for(int i = 1; i < prices.length; i++){
            int cost = prices[i] - minBuy;
            profit = Math.max(profit, cost);
            minBuy = Math.min(minBuy, prices[i]);
        }

        return profit;
    }
}
class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int n = prices.length;
        for(int l = 0; l < n; l++){
            for(int i = l; i < n; i++){
                profit = Math.max(profit, prices[i] - prices[l]);
            }
        }

        return profit;
    }
}

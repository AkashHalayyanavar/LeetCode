class Solution {
    public int maxProfit(int[] prices) {
        
        int profit=0;
        int prev = prices[0];

        for (int i=1; i<prices.length; i++) {
            if (prices[i] - prev > 0) {
                profit += prices[i] - prev;
            }
            prev = prices[i];
        }

        return profit;
    }
}
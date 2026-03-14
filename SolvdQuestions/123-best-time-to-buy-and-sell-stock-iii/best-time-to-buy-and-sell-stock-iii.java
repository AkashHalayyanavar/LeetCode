class Solution {

    int getMaxProfit(int[] prices, int index, int buy, int transactions, Integer[][][] dp) {

        if (index == prices.length || transactions == 0)
            return 0;

        if (dp[index][buy][transactions] != null)
            return dp[index][buy][transactions];

        // buy=1 means buy, buy=0 means sell
        if (buy == 1) {

            // either buy at index or go to next index without buying
            dp[index][buy][transactions] = Math.max(
                -prices[index] + getMaxProfit(prices, index+1, 0, transactions, dp),
                getMaxProfit(prices, index+1, 1, transactions, dp)
            );
        } else if (buy == 0) {

            // either sell at index or go to next index without selling
            dp[index][buy][transactions] = Math.max(
                prices[index] + getMaxProfit(prices, index+1, 1, transactions-1, dp),
                getMaxProfit(prices, index+1, 0, transactions, dp)
            );
        }

        return dp[index][buy][transactions];
    }

    public int maxProfit(int[] prices) {
        Integer[][][] dp = new Integer[prices.length][2][3];
        return getMaxProfit(prices, 0, 1, 2, dp);
    }
}
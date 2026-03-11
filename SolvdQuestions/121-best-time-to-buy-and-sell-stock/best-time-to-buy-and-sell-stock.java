class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int min=prices[0], max=prices[0];
        int n = prices.length;

        for (int i=1; i<n; i++) {
            if (prices[i] > max) {
                max = prices[i];
                maxProfit = Math.max(max-min, maxProfit);
            } else if (prices[i] < min) {
                min = prices[i];
                max = prices[i];
            }
        }

        return maxProfit;
    }
}
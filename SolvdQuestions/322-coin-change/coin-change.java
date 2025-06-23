class Solution {
    public int coinChange(int[] coins, int amount) {
        
        int n = coins.length;

        int [][] dp = new int[n+1][amount+1];

        // initialize first column
        for (int i=0; i<n+1; i++)
            dp[i][0] = 0;

        // initialize firt row
        for (int i=1; i<amount+1; i++)
            dp[0][i] = Integer.MAX_VALUE;

        for (int i=1; i<n+1; i++) {
            for (int j=1; j<amount+1; j++) {
                if (j-coins[i-1] >=0 && dp[i][j-coins[i-1]] != Integer.MAX_VALUE) {
                    dp[i][j] = Math.min( dp[i-1][j], 1 + dp[i][j-coins[i-1]] );
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return (dp[n][amount] == Integer.MAX_VALUE) ? -1 : dp[n][amount]; 

    }
}
class Solution {

    final int MOD = (int) Math.pow(10,9) + 7;

    int dfs(int n, int k, int target, int[][] dp) {
        // base case
        if (n==0 && target>0)
            return 0;

        if (target < 0)
            return 0;

        if (n==0 && target==0)
            return 1;

        if (dp[n][target] != -1)
            return dp[n][target];

        int count = 0;

        for (int i=1; i<=k; i++) {
            count = (count + dfs(n-1, k, target-i, dp)) % MOD;
        }

        dp[n][target] = count;
        return count; 
    }

    public int numRollsToTarget(int n, int k, int target) {
        
        int[][] dp = new int[n+1][target+1];

        for (int i=0; i<n+1; i++)
            Arrays.fill(dp[i], -1);

        return dfs(n, k, target, dp);
    }
}
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];

        // initialize dp[0] (Only one house)
        dp[0] = nums[0];

        // initialize dp[1] in n>1 (Two houses, so it will be max of first or second)
        if (n>1)
            dp[1] = Math.max(nums[1], nums[0]);

        // Compute other dp values
        for (int i=2; i<n; i++) {
            // max of (rob i + value of(i-2) or without robbing i: value(i-1))
            dp[i] = Math.max( nums[i]+dp[i-2], dp[i-1] );
        }

        // dp[n-1] will contain the maxAmout
        return dp[n-1];
    }
}
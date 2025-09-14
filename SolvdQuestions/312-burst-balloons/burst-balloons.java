class Solution {

    int getMaxCoins(int i, int j, int[] arr, int[][] dp) {

        // since these both are dummy values we can't burst them
        if (i+1 == j) {
            dp[i][j] = 0;
            return 0;
        }

        if (dp[i][j] != -1)
            return dp[i][j];

        int maximum = 0;

        // Try bursting the kth balloon from i+1 till j, and then send the remaining to sub problems
        for (int k=i+1; k<j; k++) {
            maximum = Math.max(maximum, getMaxCoins(i, k, arr, dp) + getMaxCoins(k, j, arr, dp) + arr[i] * arr[k] * arr[j] );
        }

        dp[i][j] = maximum;
        return dp[i][j];
    }

    public int maxCoins(int[] nums) {
        
        int n = nums.length;
        int[] arr = new int[n+2];

        // Add dummy values at the first and last of the array
        arr[0] = 1;
        arr[arr.length-1] = 1;

        for (int i=0; i<n; i++)
            arr[i+1] = nums[i];

        int[][] dp = new int[arr.length][arr.length];

        for (int[] a: dp) {
            Arrays.fill(a, -1);
        }

        return getMaxCoins(0, arr.length-1, arr, dp);
    }
}
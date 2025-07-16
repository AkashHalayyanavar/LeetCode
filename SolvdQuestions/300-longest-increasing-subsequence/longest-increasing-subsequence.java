class Solution {
    public int lengthOfLIS(int[] nums) {

        // DP Tabulation Approach

        // dp[i] denotest the LIS ending at index i

        int n = nums.length;
        int[] dp = new int[n];

        // maxLength can lie at any index of dp, so keep track of maxLen
        int maxLen = 1;

        // initialize dp array with 1, as minimum LIS at any index will be 1
        // as we can anytime consider the current element itself in LIS
        Arrays.fill(dp, 1);

        for (int i=1; i<n; i++) {
            for (int j=i-1; j>=0; j--) {
                if (nums[i] > nums[j])
                    dp[i] = Math.max(dp[i], 1+dp[j]);
            }
            maxLen = Math.max(maxLen, dp[i]);
        }
        
        
        return maxLen;
    }
}
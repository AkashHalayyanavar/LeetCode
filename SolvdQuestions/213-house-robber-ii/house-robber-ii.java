class Solution {

    // getMax is what exactly we solved for house robber 1
    int getMax(int start, int end, int size, int[] nums) {

        int[] dp = new int[size];
        int result = 0;

        if (size==1)
            return nums[start];

        dp[0] = nums[start];
        dp[1] = Math.max(nums[start], nums[start+1]);

        for(int i=2; i<size; i++)
            dp[i] = Math.max(nums[start+i]+dp[i-2], dp[i-1]);

        return dp[size-1];
    }

    public int rob(int[] nums) {
        int n = nums.length;

        if (n==1)
            return nums[0];

        // Let's break the circle, by considering 2 cases:
        // 1) Rob house 0, in this case last house cannot be robbed,
        //    So it will be converted to  house robber1 problem with 0 to n-2
        // 2) Do not rob house 0, 
        //    this will be converted to house robber1 problem with 2 to n

        int first = getMax(0, n-2, n-1, nums);
        int second = getMax(1, n-1, n-1, nums);

        return Math.max(first, second);
    }
}
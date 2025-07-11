class Solution {
    public int trap(int[] height) {

        int n = height.length;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        int result = 0;

        // populate left max
        // starting from me who is the maximum on left side
        leftMax[0] = height[0];
        for (int i=1; i<n; i++)
            leftMax[i] = Math.max(height[i], leftMax[i-1]);

        // populate right max
        // starting from me who is the maximum on right side
        rightMax[n-1] = height[n-1];
        for (int i=n-2; i>=0; i--)
            rightMax[i] = Math.max(height[i], rightMax[i+1]);

        // Calculate the amount of water trapped above each bar
        // There can be no water trapped above first and last bar
        for (int i=1; i<n-1; i++)
            result += Math.min(leftMax[i], rightMax[i]) - height[i];
        
        return result;
    }
}
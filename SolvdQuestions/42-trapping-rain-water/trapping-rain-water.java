class Solution {
    public int trap(int[] height) {
        
        int n = height.length;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        int area = 0;

        leftMax[0] = height[0];
        rightMax[n-1] = height[n-1];

        for (int i=1; i<n; i++) {
            leftMax[i] = Math.max(height[i], leftMax[i-1]);
        }

        for (int i=n-2; i>=0; i--)
            rightMax[i] = Math.max(height[i], rightMax[i+1]);

        for (int i=1; i<=n-2; i++) {

            area += Math.max(height[i], Math.min(leftMax[i-1], rightMax[i+1])) - height[i];

        }

        return area;
    }
}
class Solution {
    public int trap(int[] height) {
        
        int n = height.length;
        int leftMax = height[0];
        int rightMax = height[n-1];
        int left = 0, right = n-1;
        int area = 0;


        while (left < right) {
            
            if (leftMax > rightMax) {
                area += rightMax - height[right];
                right--;
                rightMax = Math.max(rightMax, height[right]);
            } else {
                area += leftMax - height[left];
                left++;
                leftMax = Math.max(leftMax, height[left]);
            }
        }

        return area;
    }
}
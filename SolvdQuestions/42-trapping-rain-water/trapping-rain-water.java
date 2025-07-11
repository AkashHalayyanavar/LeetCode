class Solution {
    public int trap(int[] height) {

        int n = height.length;
        
        int leftMax=0, rightMax=0, result=0;
        int left=0, right=n-1;

        while (left < right) {

            // compute leftMax for left pointer
            leftMax = Math.max(height[left], leftMax);

            // compute rightMax for right pointer
            rightMax = Math.max(height[right], rightMax);

            // leftMax is the deciding factor for left pointer index
            if (leftMax < rightMax) {
                result += (leftMax - height[left]);
                left++;
            }
            // rightMax is the deciding factor for right pointer index
            else {
                result += (rightMax - height[right]);
                right--;
            }
        }
        
        return result;
    }
}
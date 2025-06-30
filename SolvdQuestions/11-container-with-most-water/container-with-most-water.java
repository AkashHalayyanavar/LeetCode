class Solution {
    public int maxArea(int[] height) {

        int left = 0, right = height.length-1;
        int maxArea = 0;

        while(left<right) {

            if (height[left] > height[right]) {
                maxArea = Math.max(maxArea, (right-left) * height[right]);
                right--;
            } else {
                maxArea = Math.max(maxArea, (right-left) * height[left]);
                left++;
            }
        }
        
        return maxArea;
    }
}
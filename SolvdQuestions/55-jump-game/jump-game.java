class Solution {
    public boolean canJump(int[] nums) {
        
        int maxReachable = nums[0];

        for (int i=1; i<nums.length; i++) {

            if (i > maxReachable)
                return false;

            maxReachable = Math.max(i+nums[i], maxReachable);
        }

        return true;
    }
}
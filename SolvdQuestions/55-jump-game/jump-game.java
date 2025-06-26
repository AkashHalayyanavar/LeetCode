class Solution {
    public boolean canJump(int[] nums) {
        
        int maxJumpIndex = 0;
        int n = nums.length;

        for (int i=0; i<n; i++) {
            if (i <= maxJumpIndex)
                maxJumpIndex = Math.max(maxJumpIndex, i + nums[i]);
        }

        if (maxJumpIndex >= n-1)
            return true;

        return false;
    }
}
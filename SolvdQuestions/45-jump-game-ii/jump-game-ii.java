class Solution {
    public int jump(int[] nums) {
        int currPos = 0;
        int maxReach = 0;
        int jumps = 0;

        for (int i=0; i<nums.length-1; i++) {
            maxReach = Math.max(maxReach, i+nums[i]);
            if (i == currPos) {
                currPos = maxReach;
                jumps++;
            }
        }

        return jumps;
    }
}
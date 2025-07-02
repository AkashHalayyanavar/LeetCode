class Solution {
    public int majorityElement(int[] nums) {
        int count = 1;
        int prev = nums[0];

        for (int i=1; i<nums.length; i++) {
            if (count == 0) {
                prev = nums[i];
                count = 1;
            } else {
                if (prev == nums[i])
                    count++;
                else 
                    count--;
            }
        }

        return prev;
    }
}
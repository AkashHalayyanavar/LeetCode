class Solution {

    void swap(int index1, int index2, int[] nums) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
        return;
    }

    public int findDuplicate(int[] nums) {

        // we will try to arrange the nums in memory with their corresponding indexes
        int n = nums.length;
        int i=0;
        while (i<n) {
            // the num is already at correct position
            if (i == nums[i]-1) {
                i++;
            } else {
                int correctIndex = nums[i]-1;

                // if correct position num and current num are same then it is duplicate
                if (nums[correctIndex] == nums[i])
                    return nums[i];
                else
                    swap(i, nums[i]-1, nums);
            }
        }

        return -1;
    }
}
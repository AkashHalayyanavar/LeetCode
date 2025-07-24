class Solution {

    void swap(int index1, int index2, int[] nums) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    public int firstMissingPositive(int[] nums) {

        // Second Approach: Cycle sort
        // For values in the range [1,n] swap with the values with their corresponding index
        // so the values should be present at their index
        // for eg: 1 at 0, 2 at 1, 3 at 2, ...., n at n-1

        int n = nums.length;

        int i=0;

        while (i<n) {
            // correct index for nums[i]
            int correctIndex = nums[i] - 1;
            if (nums[i] >= 1 && nums[i] <= n && nums[i] != nums[correctIndex])
                swap(i, correctIndex, nums);
            else
                i++;
        }

        // check the first non matching index and value number
        for (i=0; i<n; i++) {
            if (nums[i] != i+1)
                return i+1;
        }

        return n+1;
    }

}
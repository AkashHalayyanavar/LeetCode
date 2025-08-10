class Solution {

    void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void nextPermutation(int[] nums) {
        
        int n = nums.length;
    
        for (int i=n-2; i>=0; i--) {

            // check with prev to find the number to swap
            if (nums[i] < nums[i+1]) {
                // find the number greater than nums[i] in the right part
                for (int j=n-1; j>i; j--) {
                    if (nums[j] > nums[i]) {
                        // swap the numbers
                        swap(nums, i, j);
                        break;
                    }
                }
                
                // And sort the nums part from i+1 till end
                Arrays.sort(nums, i+1, n);
                return;
            }
        }

        Arrays.sort(nums);
    }
}
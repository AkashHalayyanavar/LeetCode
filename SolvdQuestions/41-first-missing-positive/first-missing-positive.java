class Solution {
    public int firstMissingPositive(int[] nums) {

        // Logic to be used: we will convert the array such a way that it contains only the values between 1 and n+1
        // i.e., first by replacing non positive integers with value n+1

        // Then we will traverse the array, and for any number val in range [1,n] we will update the index val-1 with negative value
        // the -ve value indicating that the number is already present
        // then in the final iteration, wherever we get the first index with pos value will give the required number

        int n = nums.length;

        // Step1: set all non positive integers to n+1
        for (int i=0; i<n; i++) {
            if(nums[i] <= 0)
                nums[i] = n+1;
        }

        // Step2: start marking -ve for values in range [1,n]
        for (int i=0; i<n; i++) {
            int val = Math.abs(nums[i]);
            if (val <= n)
                nums[val-1] = -Math.abs(nums[val-1]);
        }

        // Step3: find the first missing positive, by checking the index of first +ve value
        for (int i=0; i<n; i++) {
            if (nums[i] > 0)
                return i+1;
        }

        return n+1;
    }

}
class Solution {
    public int pivotIndex(int[] nums) {
        
        int sum = Arrays.stream(nums).sum();
        int n = nums.length;

        int leftSum = 0;
        int rightSum = sum;

        for (int i=0; i<n; i++) {
            rightSum -= nums[i];

            if (leftSum == rightSum)
                return i;

            leftSum += nums[i];
        }

        return -1;

    }
}
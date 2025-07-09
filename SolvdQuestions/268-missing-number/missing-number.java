class Solution {
    public int missingNumber(int[] nums) {
        
        int sum = Arrays.stream(nums).sum();

        int n = nums.length ;

        int expectedSum = n * (n+1)/2;

        return expectedSum - sum;

    }
}
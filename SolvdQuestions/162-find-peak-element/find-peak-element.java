class Solution {
    public int findPeakElement(int[] nums) {
        
        int n = nums.length;

        int low=0, high=n-1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            long leftVal = (mid-1) < 0 ? Long.MIN_VALUE : nums[mid-1];
            long rightVal = (mid+1) >= n ? Long.MIN_VALUE : nums[mid+1];

            if ( nums[mid] > leftVal && nums[mid] > rightVal )
                return mid;

            // peak on the right side
            else if ( rightVal > nums[mid] )
                low = mid+1;

            else
                high = mid-1;
        }

        return -1;
    }
}
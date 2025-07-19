class Solution {
    public int search(int[] nums, int target) {

        int low = 0, high = nums.length-1;

        while(low<=high) {
            int mid = low + (high - low) / 2;

            System.out.println("Low: " + low + ", High: " + high);

            if (nums[mid] == target)
                return mid;

            if (target < nums[mid]) {
                if (target < nums[low] && nums[mid] >= nums[low])
                    low = mid+1;
                else
                    high = mid-1;
            } else {
                if (target > nums[high] && nums[mid] <= nums[high])
                    high = mid-1;
                else
                    low = mid+1;
            }
        }
        return -1;
    }
}
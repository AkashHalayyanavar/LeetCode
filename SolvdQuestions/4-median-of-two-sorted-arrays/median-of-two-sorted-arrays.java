class Solution {
    double getMedian(int aLeft, int aRight, int bLeft, int bRight, int len) {
        // even case
        if (len % 2 == 0)
            return ( Math.max(aLeft, bLeft) + Math.min(aRight, bRight) ) / 2.0;

        //odd case
        return Math.max(aLeft, bLeft); 
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        // Always make the first array as smaller one, as we will apply binary search on it
        if (nums1.length > nums2.length) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }

        int m = nums1.length;
        int n = nums2.length;

        // Let's always make the left partition equal (in equal case) or greater by one (in odd case) compared to right partition
        int leftLen =  (m+n+1) / 2;

        int low=0, high=m;

        while (low <= high) {
            int aRightIndex = (low + high) / 2;

            int bRightIndex = leftLen - aRightIndex;

            int aLeft = (aRightIndex == 0) ? Integer.MIN_VALUE : nums1[aRightIndex-1];
            int aRight = (aRightIndex == m) ? Integer.MAX_VALUE : nums1[aRightIndex];
            int bLeft = (bRightIndex == 0) ? Integer.MIN_VALUE : nums2[bRightIndex-1];
            int bRight = (bRightIndex == n) ? Integer.MAX_VALUE : nums2[bRightIndex];


            // check if the current partition is fine
            if (aLeft <= bRight && bLeft <= aRight)
                return getMedian(aLeft, aRight, bLeft, bRight, m+n);

            // check if partition should be moved left side
            if (aLeft > bRight)
                high = aRightIndex-1;

            // move partition right side
            else 
                low = aRightIndex+1;
        }

        return -1.0;

    }
}
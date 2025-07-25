class Solution {

    int getNextGreater(int start, int end, int val, int[] arr) {

        for (int i=start; i<end; i++) {
            if (arr[i] > val)
                return arr[i];
        }

        return -1;
    }

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        int[] result = new int[m];

        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (nums1[i] == nums2[j]) 
                    result[i] = getNextGreater(j+1, n, nums2[j], nums2);
            }
        }

        return result;
    }
}
class Solution {
    public int findLengthOfShortestSubarray(int[] arr) {

        int n = arr.length;

        // step1: find the longest non-decreasing prefix array
        int left = 0;
        while(left+1<n && arr[left]<=arr[left+1])
            left++;

        // check if the array is already sorted
        if (left == n-1)
            return 0;

        // step2: similarly find the longes non-decreasing suffix array
        int right = n-1;
        while (right-1>=0 && arr[right-1]<=arr[right])
            right--;

        // no need to check for right=0, since already sorted array condition is checked

        // step3: find the minimum length to remove by comparing prefix and suffix
        // i.e., the case where delete all after left or delete all till right 
        int result = Math.min(n-1-left, right);

        // step4: now we will minimize the deletion part
        int i=0, j=right;

        while(i<=left && j<n) {
            if (arr[i] <= arr[j]) {
                result = Math.min(result, j-i-1);
                i++;
            } else {
                j++;
            }
        }
        
        return result;
    }
}
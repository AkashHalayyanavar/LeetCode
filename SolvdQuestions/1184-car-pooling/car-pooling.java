class Solution {
    public boolean carPooling(int[][] trips, int capacity) {

        int[] prefixArray = new int[1001];

        for (int[] trip: trips) {
            int start = trip[1];
            int end = trip[2];

            prefixArray[start] += trip[0];
            prefixArray[end] -= trip[0];
        }

        // form the prefix array and see if any where the capacity is violated
        int sum = prefixArray[0];
        for (int i=1; i<1001; i++) {
            if (sum > capacity)
                return false;
            sum += prefixArray[i];
        }
        
        return true;
    }
}
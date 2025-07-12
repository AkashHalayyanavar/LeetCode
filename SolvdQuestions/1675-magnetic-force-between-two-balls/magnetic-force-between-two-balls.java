class Solution {

    boolean canPlaceBalls(int dist, int[] position, int m) {

        // assign first ball in the first position
        int prev = position[0];
        m--;

        for (int i=1; i<position.length && m > 0; i++) {
            if (position[i] - prev >= dist) {
                prev = position[i];
                m--;
            }
        }

        return m == 0;
    }


    public int maxDistance(int[] position, int m) {

        Arrays.sort(position);
        int n = position.length;

        // minimum gap will be one, as all integers are distincxt
        int low=1;

        // maximum gap that can be acheived with m balls, if all positions from 1 to position[n-1] are available
        int high = (int) Math.ceil( position[n-1] / (m-1.0) );
        int result = 0;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (canPlaceBalls(mid, position, m)) {
                result = mid;
                low = mid +1;
            } else {
                high = mid - 1;
            }
        }

        return result;
    }
}
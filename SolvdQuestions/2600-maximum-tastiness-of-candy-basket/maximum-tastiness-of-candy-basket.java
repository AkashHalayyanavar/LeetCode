class Solution {

    boolean isPossible(int[] price, int k, int x) {

        int prev = price[0];
        int count = 1;

        // Greedy approach to check if x tastiness is possible
        for (int i=1; i<price.length; i++) {
            if ( (price[i] - prev) >= x) {
                count++;
                prev = price[i];
            }
        }

        return count >= k;
    }

    public int maximumTastiness(int[] price, int k) {

        Arrays.sort(price);

        int n = price.length;

        int low = 0;
        int high = price[n - 1]-price[0];

        int res = 0;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (isPossible(price, k, mid)) {
                res = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }

        }

        return res;
        
    }
}
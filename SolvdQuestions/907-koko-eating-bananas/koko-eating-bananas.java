class Solution {

    boolean isPossible(int[] piles, int h, int k) {
        
        int count = 0;
        for (int pile: piles) {
            count += Math.ceil(pile/(double)k);
        }

        return count <= h;
    }

    public int minEatingSpeed(int[] piles, int h) {

        int low = 1;
        int high = Arrays.stream(piles).max().getAsInt();

        while (low < high) {
            System.out.println("low: " + low + ", high: " + high);

            int mid = low + (high - low) / 2;

            if (isPossible(piles, h, mid)) {
                high = mid;
            } else {
                low = mid+1;
            }
        }
        
        return high;
    }
}
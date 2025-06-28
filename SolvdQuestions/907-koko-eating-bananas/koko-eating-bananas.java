class Solution {
    Boolean isPossible(int[] piles, int k, int h) {
        int count = 0;

        for (int pile: piles) {
            count += Math.ceil(pile/(double)k);
        }

        if (count <= h)
            return true;
        
        return false;
    }

    public int minEatingSpeed(int[] piles, int h) {

        int maxPile = Arrays.stream(piles).max().getAsInt();

        int low = 1, high =maxPile;
        int result=0;

        while (low <= high) {
            int mid = (low+high)/2;

            if(isPossible(piles, mid, h)) {
                result = mid;
                high = mid-1;
            } else {
                low = mid+1;
            }
        }

        return result;    
    }
}
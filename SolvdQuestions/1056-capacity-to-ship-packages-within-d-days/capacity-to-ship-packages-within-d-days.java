class Solution {
    boolean isPossibleToShip(int capacity, int days, int[] weights) {
        int count = 1;
        int currCapacity = 0;

        for (int weight: weights) {
            if (currCapacity + weight > capacity){
                count++;
                currCapacity = 0;
            }
            currCapacity += weight;
        }

        return count <= days;
    }

    public int shipWithinDays(int[] weights, int days) {
        
        int maxWeight = Arrays.stream(weights).max().getAsInt();
        int sumWeight = Arrays.stream(weights).sum();

        // Since weight length > days, min value will be maxWeight
        int low = maxWeight;

        // since min one day, max will be sum of all, to send all packages in one day
        int high = sumWeight;

        int result=-1;

        // Apply binary search to get the least possible capacity to ship in d days
        while (low<=high) {
            int mid = low + (high - low)/2;

            if (isPossibleToShip(mid, days, weights)) {
                result = mid;
                high = mid-1;
            } else {
                low = mid+1;
            }
        } 

        return result;
    }
}
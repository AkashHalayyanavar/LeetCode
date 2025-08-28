class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        
        TreeMap<Integer, Integer> mp = new TreeMap<>();

        for (int[] trip: trips) {
            int num = trip[0];
            int start = trip[1];
            int end = trip[2];

            mp.put(start, mp.getOrDefault(start, 0) + num);
            mp.put(end, mp.getOrDefault(end, 0) - num);
        }

        // iterate over the map and compute the prefix sum
        // see if at any point of time the num of passengers exceeds the capacity
        int sum = 0;
        for (int value: mp.values()) {
            sum += value;

            if (sum > capacity)
                return false;
        }

        return true;
    }
}
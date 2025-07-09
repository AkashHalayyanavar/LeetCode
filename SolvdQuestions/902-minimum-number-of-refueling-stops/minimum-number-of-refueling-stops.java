class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {

        PriorityQueue<Integer> maxPQ = new PriorityQueue<>(Collections.reverseOrder());

        // since 1 <= positioni < positioni+1 < target no need to sort the stations array

        // initally maxReachable is equal to startFuel
        int maxReachable = startFuel;
        int stops = 0;
        
        int i=0;
        while (i<stations.length) {
            // station position is less than or equal to maxReachable then add to queu
            if (stations[i][0] <= maxReachable) {
                maxPQ.offer(stations[i][1]);
                i++;
            }

            else {
                // if we are already able to reach target, no need to refuel, just return the no. of stops
                if (maxReachable >= target)
                    return stops;

                // no fuel stations were found, then we cannot reach target
                if (maxPQ.isEmpty())
                    return -1;

                // get the max fuel from the heap
                maxReachable += maxPQ.poll();
                stops++;
            }
        } 
        
        while (!maxPQ.isEmpty()) {
            if (maxReachable >= target)
                return stops;

            maxReachable += maxPQ.poll();
            stops++;
        }

        return maxReachable >= target ? stops : -1;
    }
}
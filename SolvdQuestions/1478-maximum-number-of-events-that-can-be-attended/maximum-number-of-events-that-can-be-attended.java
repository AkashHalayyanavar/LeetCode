class Solution {
    public int maxEvents(int[][] events) {

        // sort the events in the ascending order based on the start time
        // if the start times are same then based on their end times
        Arrays.sort(events, (a,b) -> {
            if (a[0] != b[0])
                return a[0] - b[0];

            return a[1] - b[1];
        });

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int currDay=1;
        int i = 0;
        int attended = 0;

        // dummy entry
        pq.offer(-1);

        while (i<events.length || !pq.isEmpty()) {

            // Add all the events end dates to pq, whoes start date is less than or equal to currDate
            while (i<events.length && events[i][0] <= currDay) {
                pq.offer(events[i][1]);
                i++;
            }

            // Remove all the endDates less than i as they can no longer be attended
            while (!pq.isEmpty() && pq.peek() < currDay)
                pq.poll();

            // Attend one event with the least end date (top of pq)
            if (!pq.isEmpty()) {
                attended++;
                pq.poll();
            }

            // move to next day
            currDay++;
        }

        return attended;
        
    }
}
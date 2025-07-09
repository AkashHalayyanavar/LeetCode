class Solution {
    public int maxEvents(int[][] events) {

        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        int maxDay = Arrays.stream(events).mapToInt(event -> event[1]).max().getAsInt();

        System.out.println(maxDay);

        int result = 0;
        int n = events.length;

        // Default sort 
        Arrays.sort(events, Comparator.comparingInt(a -> a[0]));

        // Start from day 1 and go till maxDay
        for (int i=1, j=0; i<=maxDay; i++) {
            // All the events whose starting day is less than equal to day i add to min heap
            // since those are the events which might be possible to be assigned on day i
            while (j<n && events[j][0] <= i) {
                pq.offer(events[j][1]);
                j++;
            }

            // Remove from heap all the meetings whose end day is less than i
            // As they can no longer be attended
            while(!pq.isEmpty() && pq.peek() < i) {
                pq.poll();
            }

            // If the heap is not empty, we attend the meeting with the earliest end time
            // (which is at the top of the heap), increment the count of attended meetings by 1, 
            // and remove it from the heap
            if (!pq.isEmpty()) {
                pq.poll();
                result++;
            }
        }

        return result;
    }
}
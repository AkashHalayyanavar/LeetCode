class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        int n = nums.length;

        // we will store index in the queue
        Deque<Integer> dq = new ArrayDeque<>();

        int[] result = new int[n-k+1];

        // first window of size k
        for (int i=0; i<k; i++) {
                
            while(!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]) {
                dq.pollLast();
            }

            dq.offerLast(i);
        }

        // NOTE: Max will always be at the front of the queue

        // Add the first window result
        result[0] = nums[dq.peekFirst()];

        // keep moving the index till we reach the end
        for (int i=k; i<n; i++) {

            // remove the first index if it is not part of the current window
            if (dq.peekFirst() == (i-k) ) 
                dq.pollFirst();

            while(!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]) {
                dq.pollLast();
            }

            dq.offerLast(i);
            // Add result for the current window
            result[i-k+1] = nums[dq.peekFirst()];
        }
        
        return result;
    }
}
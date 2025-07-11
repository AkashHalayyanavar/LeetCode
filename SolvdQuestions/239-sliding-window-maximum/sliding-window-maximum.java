class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        Deque<Integer> dq = new ArrayDeque<>();

        List<Integer> result = new ArrayList<>();

        // first window
        for (int i=0; i<k; i++) {

            while (!dq.isEmpty() && nums[dq.peekLast()] <= nums[i])
                dq.pollLast();


            dq.addLast(i);
        }

        // subsequent windows
        for (int i=k; i<nums.length; i++) {
            result.add(nums[dq.peekFirst()]);

            if(dq.peekFirst() <= (i-k))
                dq.pollFirst();

            while (!dq.isEmpty() && nums[dq.peekLast()] <= nums[i])
                dq.pollLast();

            dq.addLast(i);
        }

        result.add(nums[dq.peekFirst()]);

        // convert list to int[] and return
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
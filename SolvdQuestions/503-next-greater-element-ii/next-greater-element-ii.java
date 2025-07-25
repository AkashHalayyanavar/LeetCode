class Solution {
    public int[] nextGreaterElements(int[] nums) {
        
        Deque<Integer> st = new ArrayDeque<>();

        int n = nums.length;
        int[] result = new int[n];

        Arrays.fill(result, Integer.MIN_VALUE);

        // same way put into the stack like next greater element I
        // only change in this loop, is do not put in map the value -1 if not found
        for (int i=n-1; i>=0; i--) {
            while (!st.isEmpty() && nums[i] >= st.peek())
                st.poll();

            if (!st.isEmpty())
                result[i] = st.peek();

            st.push(nums[i]);
        }

        // now traverse the for loop again, this time do the same checks
        for (int i=n-1; i>=0; i--) {
            while (!st.isEmpty() && nums[i] >= st.peek())
                st.poll();

            if (result[i] == Integer.MIN_VALUE) {
                if (!st.isEmpty())
                    result[i] = st.peek();
                else
                    result[i] = -1;
            }
        }

        return result;
    }
}
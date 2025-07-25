class Solution {
    public int[] nextGreaterElements(int[] nums) {
        
        Deque<Integer> st = new ArrayDeque<>();

        int n = nums.length;
        int[] result = new int[n];

        Arrays.fill(result, -1);

        // same way put into the stack like next greater element I
        // only change is we run this loop twice, i.e., starting from 2n-1
        for (int i=2*n-1; i>=0; i--) {
            while (!st.isEmpty() && nums[i%n] >= st.peek())
                st.poll();

            if (!st.isEmpty())
                result[i%n] = st.peek();

            st.push(nums[i%n]);
        }


        return result;
    }
}
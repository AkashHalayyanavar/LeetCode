class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        int m = nums1.length;
        int n = nums2.length;

        int[] result = new int[m];

        Deque<Integer> st = new ArrayDeque<>();
        Map<Integer, Integer> mp = new HashMap<>();

        // find out all the next greater elements for elements in nums2 and store in map
        for (int i=n-1; i>=0; i--) {
            while (!st.isEmpty() && nums2[i] > st.peek()) {
                st.poll();
            }

            // if stack is empty => no next greater element for this nums2[i]
            if (st.isEmpty())
                mp.put(nums2[i], -1);
            else
                mp.put(nums2[i], st.peek());

            // push nums2[i] in the stack
            st.push(nums2[i]);
        }

        // Now get the next greater elements for nums1 from the map and store in result
        for (int i=0; i<m; i++) {
            result[i] = mp.get(nums1[i]);
        }

        return result;
    }
}
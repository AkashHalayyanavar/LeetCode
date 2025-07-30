class Solution {

    public int longestValidParentheses(String s) {

        int maxLen = 0;
        // Push and pop indices
        Deque<Integer> st = new ArrayDeque<>();
        int n = s.length();

        // insert -1 to the stack, 
        // this is like a reset point, which will help to reset the start of curr valid parentheses
        st.push(-1);

        for (int i=0; i<n; i++) {
            // if we see '(' just push it and update curr
            if (s.charAt(i) == '(')
                st.push(i);

            // else case ')'
            else {
                st.poll();
                // is stack is empty, which means at this point the valid paranthesis ended, so reset it by pushing
                if (st.isEmpty())
                    st.push(i);
                // else, compare the current valid parentheses with max
                else {
                    maxLen = Math.max(maxLen, i - st.peek());
                }
            }
        }
        
        return maxLen;
    }
}
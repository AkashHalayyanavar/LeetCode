class Solution {
    public String decodeString(String s) {
        
        Deque<Integer> numStack = new ArrayDeque<>();
        Deque<StringBuilder> st = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        int num = 0;

        for (char ch: s.toCharArray()) {

            if (Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');
            } else if (ch == '[') {
                numStack.push(num);
                num = 0;

                // push whatever is captured in the sb till now, and assign sb a new stringbuilder
                st.push(sb);
                sb = new StringBuilder();
            } else if (ch == ']') {
                int k = numStack.poll();

                // current sb will hold the required inner string [...] for the current closing bracket ]
                StringBuilder temp = sb;

                // to the sb inside stack which is sb for the outer one, assign the complete inner string
                sb = st.poll();
                for (int i=0; i<k; i++)
                    sb.append(temp);

            } else {
                sb.append(ch);
            }

        }

        return sb.toString();
    }
}
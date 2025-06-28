class Solution {
    public boolean isValid(String s) {
        Deque<Character> st = new ArrayDeque<>();

        for (int i=0; i<s.length(); i++) {
            Character ch = s.charAt(i);
            Character top;
            
            switch (ch) {
                case '(':
                case '{':
                case '[':
                    st.push(ch);
                    break;
                case ')':
                    top = st.poll();
                    if (top ==null || top != '(')
                        return false;
                    break;
                case '}':
                    top = st.poll();
                    if (top ==null || top != '{')
                        return false;
                    break;
                case ']':
                    top = st.poll();
                    if (top ==null || top != '[')
                        return false;
                    break;
            }
        }

        if (st.size() > 0)
            return false;

        return true;
    }
}
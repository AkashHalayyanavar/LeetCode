class Solution {
    public String simplifyPath(String path) {

        String[] arr = path.split("/");
        int n = arr.length;
        StringBuilder sb = new StringBuilder();

        Deque<String> st = new ArrayDeque<>();

        for (String str: arr) {

            if ( str.equals(".") || str.equals("") )
                continue;

            else if (str.equals("..")) {
                if (!st.isEmpty())
                    st.poll();
            }

            else {
                st.push(str);
            }
        }

        while (!st.isEmpty()) {
            sb.insert(0, "/" + st.poll());
        }

        return sb.length() == 0 ? "/" : sb.toString();
    }
}
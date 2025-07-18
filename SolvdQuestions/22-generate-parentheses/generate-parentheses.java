class Solution {

    void func(String s, int o, int c, int n, List<String> result) {

        if (o==n && c==n) {
            result.add(s);
            return;
        }

        if (o>n || c>n || c>o)
            return;

        func(s+"(", o+1, c, n, result);
        func(s+")", o, c+1, n, result);
    }

    public List<String> generateParenthesis(int n) {

        List<String> result = new ArrayList<>();

        func("", 0, 0, n, result);

        return result;
    }
}
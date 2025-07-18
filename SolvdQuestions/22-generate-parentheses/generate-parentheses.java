class Solution {

    void buildWellFormedParenthesis(StringBuilder sb, int openCount, int closedCount, int n, List<String> result) {

        if (openCount==n && closedCount==n) {
            result.add(sb.toString());
            return;
        }

        if (openCount < n) {
            sb.append("(");
            buildWellFormedParenthesis(sb, openCount+1, closedCount, n, result);
            sb.deleteCharAt(sb.length()-1);
        }

        if (closedCount < openCount) {
            sb.append(")");
            buildWellFormedParenthesis(sb, openCount, closedCount+1, n, result);
            sb.deleteCharAt(sb.length()-1);
        }
    }

    public List<String> generateParenthesis(int n) {

        List<String> result = new ArrayList<>();

        buildWellFormedParenthesis(new StringBuilder(), 0, 0, n, result);

        return result;
    }
}
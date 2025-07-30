class Solution {

    boolean match(int i, int j, String s, String p) {
        if (i<s.length() && ( s.charAt(i) == p.charAt(j) || p.charAt(j) == '.' )) {
           return true;
        }
        return false;
    }

    boolean dfs(int i, int j, String s, String p) {
        
        // Base case for match
        if (i >= s.length() && j >= p.length())
            return true;

        // If only j >= pattern length, it implies the string cannot be matched, as pattern is over
        if (j >= p.length())
            return false;

        // If only i >= string length, that dosn't mean no match, as pattern can have * which means 0 or more characters
        // so for * we might keep 0 and the pattern might still match
        // so we do not consider i >= string length case here

        // Two choices if the next char in pattern is *
        if ( (j+1) < p.length() && p.charAt(j+1) == '*' ) {
            // firstCase: do not include any character i.e., 0 for *
            boolean firstCase = dfs(i, j+2, s, p);
            // secondCase: include one character, if the character match then proceed with i+1
            boolean secondCase = match(i, j, s, p) ? dfs(i+1, j, s, p) : false;

            return firstCase || secondCase;
        }

        // If the next character is not *, then we have to match and check
        if (match(i, j, s, p))
            return dfs(i+1, j+1, s, p);
        
        return false;
    }

    public boolean isMatch(String s, String p) {
        return dfs(0, 0, s, p);
    }
}
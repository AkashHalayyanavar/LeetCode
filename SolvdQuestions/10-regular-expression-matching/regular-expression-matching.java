class Solution {

    boolean match(int i, int j, String s, String p) {
        if (i<s.length() && ( s.charAt(i) == p.charAt(j) || p.charAt(j) == '.' )) {
           return true;
        }
        return false;
    }

    boolean dfs(int i, int j, String s, String p, Boolean[][] dp) {
        
        // Base case for match
        if (i >= s.length() && j >= p.length())
            return true;

        // If only j >= pattern length, it implies the string cannot be matched, as pattern is over
        if (j >= p.length())
            return false;

        // check if the result is already cached
        if (dp[i][j] != null)
            return dp[i][j];

        // If only i >= string length, that dosn't mean no match, as pattern can have * which means 0 or more characters
        // so for * we might keep 0 and the pattern might still match
        // so we do not consider i >= string length case here

        // Two choices if the next char in pattern is *
        if ( (j+1) < p.length() && p.charAt(j+1) == '*' ) {
            // firstCase: do not include any character i.e., 0 for *
            boolean firstCase = dfs(i, j+2, s, p, dp);
            // secondCase: include one character, if the character match then proceed with i+1
            boolean secondCase = match(i, j, s, p) ? dfs(i+1, j, s, p, dp) : false;

            dp[i][j] = firstCase || secondCase;

            return dp[i][j];
        }

        // If the next character is not *, then we have to match and check
        if (match(i, j, s, p)) {
            dp[i][j] = dfs(i+1, j+1, s, p, dp);
            return dp[i][j];
        }
        
        return false;
    }

    public boolean isMatch(String s, String p) {
        // going for Boolean boxed type, as default for this will be null
        Boolean[][] dp = new Boolean[s.length()+1][p.length()+1];
        return dfs(0, 0, s, p, dp);
    }
}
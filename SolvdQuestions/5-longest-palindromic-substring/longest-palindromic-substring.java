class Solution {
    public String longestPalindrome(String s) {

        int n = s.length();

        boolean [][]dp = new boolean[n][n];

        int res_start = 0;
        int res_end = -1;

        // initialize the first diagonal
        for (int i=0; i<n; i++) {
            dp[i][i] = true;
            res_start = i;
            res_end = i;
        }

        // initialize the second diagonal
        for (int i=0; i<n-1; i++) {
            if (s.charAt(i) == s.charAt(i+1)) {
                dp[i][i+1] = true;
                res_start = i;
                res_end = i+1;
            } else {
                dp[i][i+1] = false;
            }
        }

        // Fill the dp table diagonally
        for (int k=2; k<n; k++) {
            for (int i=0; i<n-k; i++) {
                int j = i+k;
                if (s.charAt(i) == s.charAt(j) && dp[i+1][j-1] == true) {
                    dp[i][j] = true;
                    res_start = i;
                    res_end = j;
                } else {
                    dp[i][j] = false;
                }
            }
        }

        return s.substring(res_start, res_end+1);
        
    }
}
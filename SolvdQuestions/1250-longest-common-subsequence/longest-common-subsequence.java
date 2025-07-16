class Solution {

    int getLCS(int i, int j, String text1, String text2, int[][] dp) {

        if (i<0 || j<0)
            return 0;

        // if the subproblem is already solved and stored then return the value from dp
        if (dp[i][j] != -1)
            return dp[i][j];

        // case1: text1 character at index i is equal to text2 character at index j
        if (text1.charAt(i) == text2.charAt(j)) 
            dp[i][j] = 1 + getLCS(i-1, j-1, text1, text2, dp);

        else
            dp[i][j] = Math.max( getLCS(i, j-1, text1, text2, dp), 
                             getLCS(i-1, j, text1, text2, dp) );

        return dp[i][j];
    }

    public int longestCommonSubsequence(String text1, String text2) {

        int m = text1.length();
        int n = text2.length();

        int[][] dp = new int[m][n];

        // initialize dp values with -1
        for (int[] arr: dp)
            Arrays.fill(arr, -1);

        // we will start comparing from the end of the strings, i.e., from right to left
        return getLCS(m-1, n-1, text1, text2, dp);
    }
}
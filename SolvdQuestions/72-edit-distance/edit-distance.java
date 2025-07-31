class Solution {
    int getMinDistance(int i, int j, int m, int n, String s1, String s2, int[][] dp) {
        // base case
        if (j == n && i == m)
            return 0;

        if (i == m)
            return n-j;

        if (j == n)
            return m-i;

        if (dp[i][j] != -1)
            return dp[i][j];

        if (s1.charAt(i) == s2.charAt(j))
            return getMinDistance(i+1, j+1, m, n, s1, s2, dp);

        // Now we have 3 options insert, delete, or replace
        int insertCount = getMinDistance(i, j+1, m, n, s1, s2, dp);
        int deleteCount = getMinDistance(i+1, j, m, n, s1, s2, dp);
        int replaceCount = getMinDistance(i+1, j+1, m, n, s1, s2, dp);

        return dp[i][j] = Math.min(insertCount, Math.min(deleteCount, replaceCount)) + 1;
    }

    public int minDistance(String word1, String word2) {
        
        int m = word1.length();
        int n = word2.length();

        int[][] dp = new int[m][n];

        for (int[] arr: dp) {
            Arrays.fill(arr, -1);
        }

        return getMinDistance(0, 0, m, n, word1, word2, dp);

    }
}
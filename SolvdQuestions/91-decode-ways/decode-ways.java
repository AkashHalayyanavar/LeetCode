class Solution {
    public int numDecodings(String s) {

        int n = s.length();
        int[] dp = new int[n];
        int count = 0;

        // base case
        dp[0] = (s.charAt(0) == '0') ? 0 : 1;

        for (int i=1; i<n; i++) {
            int currDig = s.charAt(i) - '0';
            int lastTwoDig = (s.charAt(i-1) - '0') * 10 + currDig;

            if (currDig >= 1 && currDig <= 9)
                dp[i] = dp[i-1];

            if (lastTwoDig >= 10 && lastTwoDig <= 26)
                dp[i] += (i==1) ? 1 : dp[i-2];
         }

        return dp[n-1];
        
    }
}
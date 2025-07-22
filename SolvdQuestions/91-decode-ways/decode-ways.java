class Solution {
    public int numDecodings(String s) {

        int n = s.length();
        int[] dp = new int[n];

        // base case
        if ( s.charAt(0) >= '1' && s.charAt(0) <= '9')
            dp[0] = 1;
        else
            return 0;

        // fill other values using dp
        for (int i=1; i<n; i++) {
            if ( s.charAt(i) >= '1' && s.charAt(i) <= '9')
                dp[i] = dp[i-1];

            int lastTwoDig = (s.charAt(i-1) - '0') * 10 + (s.charAt(i) - '0');
            if (lastTwoDig >= 10 && lastTwoDig <= 26)
                dp[i] = dp[i] + ( i>=2 ? dp[i-2] : 1 );
            
        }

        return dp[n-1];
    }
}
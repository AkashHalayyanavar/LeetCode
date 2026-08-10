class Solution {

    int getCount(String s, int start, int end, int[] dp) {

        if (start == end)
            return 1;

        if (start == end-1) {
            if (s.charAt(start) != '0')
                return 1;
            return 0;
        }

        if (dp[start] != -1)
            return dp[start];

        int firstNum = s.charAt(start) - '0';
        int secondNum = 10 * (s.charAt(start) - '0') + (s.charAt(start+1) - '0');

        int count = 0;
        
        if (firstNum > 0)
            count = getCount(s, start+1, end, dp);

        if (secondNum >= 10 && secondNum <= 26)
            count += getCount(s, start+2, end, dp); 

        dp[start] = count;
        return count;
    }

    public int numDecodings(String s) {

        int n = s.length();
        int[] dp = new int[n];

        Arrays.fill(dp, -1);

        return getCount(s, 0, s.length(), dp);
        
    }
}
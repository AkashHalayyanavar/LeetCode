class Solution {
    Boolean[] dp;
    boolean helper(String s, int pos, Set<String> set) {
        int n = s.length();
        // base case
        if(pos == n)
            return true;

        if (dp[pos]!=null)
            return dp[pos];

        for (int i=pos; i<n; i++) {
            if(set.contains(s.substring(pos, i+1)) && helper(s, i+1, set) ) {
                dp[pos] = true;
                return true;
            }
        }

        dp[pos] = false;
        return false;
    }

    
    public boolean wordBreak(String s, List<String> wordDict) {

        // Store the wordDict words in the set
        Set<String> set = new HashSet<>(wordDict);

        int n = s.length();
        dp = new Boolean[n];

        return helper(s, 0, set);
        
    }
}
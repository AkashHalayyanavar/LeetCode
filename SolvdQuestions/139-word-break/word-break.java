class Solution {

    boolean isPossible(String s, int index, int n, HashSet<String> set, Boolean[] dp) {

        if (index == n)
            return true;

        if (dp[index] != null)
            return dp[index];

        for (int i=index+1; i<=n; i++) {
            String sub = s.substring(index, i);
            if (set.contains(sub) && isPossible(s, i, n, set, dp)) {
                dp[index] = true;
                return true;
            }
        }

        dp[index] = false;
        return false;
    }

    public boolean wordBreak(String s, List<String> wordDict) {

        int n = s.length();
        HashSet<String> set = new HashSet<>();
        Boolean[] dp = new Boolean[n];

        // Store words ito the hash set
        for (String word: wordDict)
            set.add(word);


        return isPossible(s, 0, n, set, dp);
    }
}
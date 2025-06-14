class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        Set<Character> charSet = new HashSet<>();

        int left = 0;
        int right = 0;

        int n = s.length();

        if (n == 0) 
            return 0;

        int maxLen = 0;

        while (right < n) {
            Character ch = s.charAt(right);

            if (charSet.contains(ch)) {
                maxLen = Math.max(maxLen, right-left);
                
                while (charSet.contains(ch)) {
                    charSet.remove(s.charAt(left++));
                }
            }
                
            charSet.add(ch);
            right++;
        }

        return Math.max(maxLen, right-left);
    }
}
class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        Set<Character> set = new HashSet<>();

        int maxCount = 0;

        int i=0, j=0;
        int n = s.length();

        while (j < n) {
            char ch = s.charAt(j);

            while (set.contains(ch)) {
                set.remove(s.charAt(i));
                i++;
            }

            set.add(ch);

            j++;
            maxCount = Math.max(maxCount, j-i);
        }

        return maxCount;
    }
}
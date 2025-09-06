class Solution {
    public String minWindow(String s, String t) {
        
        Map<Character, Integer> mp = new HashMap<>();
        int count = t.length();
        int startIndex = 0;
        int minLen = Integer.MAX_VALUE;

        // Add all the characters of t to the map
        for (char ch: t.toCharArray()) {
            mp.put(ch, mp.getOrDefault(ch, 0) + 1);
        }

        // For the string s go from left to right
        int i=0, j=0;
        while (j < s.length()) {
            char ch = s.charAt(j);
            if (mp.containsKey(ch)) {

                if (mp.get(ch) > 0) {
                    count--;
                }
                mp.put(ch, mp.get(ch)-1);
            }

            while (count == 0) {
                if ( minLen > j-i+1) {
                    minLen = j-i+1;
                    startIndex = i;
                }

                if (mp.containsKey(s.charAt(i))) {
                    int val = mp.get(s.charAt(i));
                    mp.put(s.charAt(i), val + 1);
                    if (val >= 0)
                        count++;
                }
                i++;
            }

            j++;
        }

        return minLen == Integer.MAX_VALUE ? new String() : s.substring(startIndex, startIndex+minLen);
    }
}
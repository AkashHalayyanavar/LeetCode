class Solution {
    public String minWindow(String s, String t) {
        
        int m = s.length();
        int n = t.length();

        int remLen = n;

        // put all the chars of string t to map
        Map<Character, Integer> mp = new HashMap<>();

        for (char ch: t.toCharArray()) {
            mp.put(ch, mp.getOrDefault(ch, 0) + 1);
        }
        
        int startIndex = 0;
        int minLen = Integer.MAX_VALUE;
        int currLen = 0;

        int i=0, j=0;
        while (i < m) {
            char ch = s.charAt(i);
            if ( mp.containsKey(ch) ) {
                int val = mp.get(ch);
                if (val >= 1) {
                    remLen--;
                }
                mp.put(ch, val-1);
            }
            currLen++;
            while (remLen == 0) {
                char ch2 = s.charAt(j);
                if (mp.containsKey(ch2)) {
                    int val = mp.get(ch2);
                    if (val == 0) {
                        remLen++;
                    }
                    mp.put(ch2, mp.get(ch2) + 1);
                }
                if (minLen > i-j+1) {
                    minLen = i-j+1;
                    startIndex = j;
                }
                j++;
            }
            i++;
        }

        if (minLen == Integer.MAX_VALUE)
            return "";
        
        return s.substring(startIndex, startIndex+minLen);
    }
}
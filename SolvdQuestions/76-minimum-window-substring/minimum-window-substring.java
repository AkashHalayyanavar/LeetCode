class Solution {
    public String minWindow(String s, String t) {
        
        Map<Character, Integer> mp = new HashMap<>();

        // store the t characters into the map
        for (Character ch: t.toCharArray()) {
            mp.put(ch, mp.getOrDefault(ch, 0)+1);
        }

        int left=0, right=0;
        int minLen=Integer.MAX_VALUE;
        int resultStartIndex = 0;

        int count = t.length();

        while (right < s.length()) {
            if (mp.containsKey(s.charAt(right))) {
                int val = mp.get(s.charAt(right));
                if (val > 0) {
                    count--;
                }
                mp.put(s.charAt(right), val-1);
            }

            // if count is 0, then keep moving left till we see the count is increased
            while (count==0) {
                // check if minLen is lesser now
                if (right-left+1 < minLen) {
                    resultStartIndex = left;
                    minLen = right-left+1;
                }


                // see if the left element is part of target
                if (mp.containsKey(s.charAt(left))) {
                    // increment the counter in map, as we are moving left
                    int val = mp.get(s.charAt(left));
                    mp.put(s.charAt(left),  val+ 1);
                    if (val >= 0)
                        count++;
                }
                left++;
            }

            right++;
        }

        System.out.println(resultStartIndex);

        return minLen == Integer.MAX_VALUE ? new String() 
                        : s.substring(resultStartIndex, resultStartIndex+minLen);
    }
}
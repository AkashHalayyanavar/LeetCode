class Solution {

    boolean valid(String s, int start, int length) {

        if (length == 1)
            return true;

        if (s.charAt(start) == '0' || length>3)
            return false;

        int num = Integer.parseInt( s.substring(start, start+length) );
        if (num > 0 && num <= 255)
            return true;

        return false;
    }

    void helper(String s, int start, int n, List<Integer> parts, List<String> result) {


        int remainingLength = n - start;
        int remainingParts = 4 - parts.size();

        // check remaining length and parts
        if (remainingLength > remainingParts * 3 || remainingLength < remainingParts)
            return;

        // NOTE: parts list contains the length of each part
        // case: it is the last part
        if (parts.size() == 3) {
            if ( valid(s, start, remainingLength) ) {
                StringBuilder sb = new StringBuilder();
                int currIndex = 0;
                for (Integer part: parts) {
                    sb.append( s.substring(currIndex, currIndex+part) );
                    currIndex += part;
                    sb.append(".");
                }
                sb.append( s.substring(currIndex, n) );
                result.add( sb.toString() );
            }
            return;
        }

        for(int len=1; len<=Math.min(3, remainingLength); len++) {
            parts.add(len);

            if ( valid(s, start, len) ) {
                helper(s, start+len, n, parts, result);
            }
            // Backtrack
            parts.remove(parts.size()-1);
        }

    }

    public List<String> restoreIpAddresses(String s) {
        
        List<String> result = new ArrayList<>();
        helper(s, 0, s.length(), new ArrayList<>(), result);
        return result;
    }
}
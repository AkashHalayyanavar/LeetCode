class Solution {

    boolean isPalindrome (String s) {
        int n = s.length();

        for (int i=0; i<n/2; i++) {
            if (s.charAt(i) != s.charAt(n-i-1))
                return false;
        }
        return true;
    }

    void getPartitions(String s, List<String> curr, List<List<String>> res) {

        if (s.length() == 0) {
            res.add(new ArrayList<>(curr));
            return;
        }

        for (int i=0; i<s.length(); i++) {

            String firstPart = s.substring(0, i+1);
            String secondPart = s.substring(i+1, s.length());

            if ( isPalindrome(firstPart) ) {
                curr.add(firstPart);
                getPartitions(secondPart, curr, res);
                curr.remove(curr.size() - 1);
            }
        }

    }

    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();

        getPartitions(s, new ArrayList<>(), res);
        return res;
    }
}
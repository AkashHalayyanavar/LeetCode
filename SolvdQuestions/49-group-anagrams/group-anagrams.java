class Solution {
    boolean anagram(String str1, String str2) {
        if (str1.length() != str2.length())
            return false;

        HashMap<Character, Integer>  mp = new HashMap<>();

        for (Character ch: str1.toCharArray()) {
            mp.put(ch, mp.getOrDefault(ch, 0) + 1);
        }

        for (Character ch: str2.toCharArray()) {
            if (mp.get(ch) == null) 
                return false;
            mp.put(ch, mp.get(ch) - 1);
            if(mp.get(ch) == 0) {
                mp.remove(ch);
            }
        }
        return true;
    }

    void checkAndAdd(String str, List<List<String>> result) {
        for(int i=0; i<result.size(); i++) {
            String resStr = result.get(i).get(0);
            if (anagram(str, resStr)) {
                result.get(i).add(str);
                return;
            }
        }
        List<String> res = new ArrayList<>();
        res.add(str);
        result.add(res);
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        
        List<List<String>> result = new ArrayList<>();

        for (String str: strs) {
            checkAndAdd(str, result);
        }

        return result;
    }
}
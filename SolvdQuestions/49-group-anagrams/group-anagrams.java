class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
    
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] chArr = new char[26];
            for (char ch : s.toCharArray()) 
                chArr[ch - 'a']++;

            String keyStr = String.valueOf(chArr);

            if (!map.containsKey(keyStr)) 
                map.put(keyStr, new ArrayList<>());
            
            map.get(keyStr).add(s);
        }
        
        return new ArrayList<>(map.values());
    }
}
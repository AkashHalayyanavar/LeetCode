class Solution {

    public List<List<String>> groupAnagrams(String[] strs) {
        
        List<List<String>> result;
        Map<Map<Character, Integer>, List<String>> mp = new HashMap<>();

        for (String str: strs) {
            // create a map of characters
            Map<Character, Integer> charMap = new HashMap<>();
            for (Character ch: str.toCharArray()) {
                charMap.put(ch, charMap.getOrDefault(ch, 0) + 1);
            }
            
            // put the orignal string in the hashmap list with charMap as key
            List<String> strList = mp.get(charMap);
            // new group case
            if (strList == null) {
                strList = new ArrayList<>();
                strList.add(str);
                mp.put(charMap, strList);
            } else {
                strList.add(str);
            }
        }

        result = new ArrayList<>(mp.values());

        return result;
    }
}
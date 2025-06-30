class Solution {

    public List<List<String>> groupAnagrams(String[] strs) {
        
        List<List<String>> result;
        Map<String, List<String>> mp = new HashMap<>();

        for (String str: strs) {
            // sort the string
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String sortedStr = new String(charArray);
            
            // put the orignal string in the hashmap list with sortedStr as key
            List<String> strList = mp.get(sortedStr);
            // new group case
            if (strList == null) {
                strList = new ArrayList<>();
                strList.add(str);
                mp.put(sortedStr, strList);
            } else {
                strList.add(str);
            }
        }

        result = new ArrayList<>(mp.values());

        return result;
    }
}
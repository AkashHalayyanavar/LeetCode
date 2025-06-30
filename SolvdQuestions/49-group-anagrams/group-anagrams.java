class Solution {

    public List<List<String>> groupAnagrams(String[] strs) {
        
        List<List<String>> result;
        Map<String, List<String>> mp = new HashMap<>();

        for (String str: strs) {
            
            int[] counts = new int[26];

            // fill the counts array for the string str
            for (char ch: str.toCharArray()) {
                counts[ch-'a']++;
            } 

            // Create a unique string signature based on counts
            StringBuilder sb = new StringBuilder();
            for (int count: counts) {
                // Use '#' to separate counts for each letter
                sb.append(count).append("#"); 
            }

            String sortedStr = sb.toString();

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
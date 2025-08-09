class Solution {

    boolean matches(HashMap<Character, Integer> mp1, HashMap<Character, Integer> mp2) {
        for (char key: mp1.keySet()) {
            if (mp1.get(key) - mp2.getOrDefault(key, -1) != 0)
                return false;
        }
        return true;
    }

    public boolean checkInclusion(String s1, String s2) {

        int m = s1.length();
        int n = s2.length();

        if (m > n)
            return false;
        
        HashMap<Character, Integer> mp1 = new HashMap<>();

        for (char ch: s1.toCharArray())
            mp1.put(ch, mp1.getOrDefault(ch, 0) + 1);

        HashMap<Character, Integer> mp2 = new HashMap<>();

        // Add the first window of size m to the map mp2
        for (int i=0; i<m; i++) {
            char ch = s2.charAt(i);
            mp2.put(ch, mp2.getOrDefault(ch, 0) + 1);
        }

        if ( matches(mp1, mp2) )
            return true;

        System.out.println("m: " + m);
        System.out.println("n: " + n);
        System.out.println("n-m: " + (n-m));

        // keep moving the window of size m till the end
        for (int i=m; i<n; i++) {
            System.out.println("hello");

            char ch = s2.charAt(i-m);
            mp2.put(ch, mp2.get(ch) - 1);

            ch = s2.charAt(i);
            mp2.put(ch, mp2.getOrDefault(ch, 0) + 1);

            if ( matches(mp1, mp2) )
                return true;
        }

        return false;
    }
}
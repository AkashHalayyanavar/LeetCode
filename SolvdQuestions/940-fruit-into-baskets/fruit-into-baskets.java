class Solution {
    public int totalFruit(int[] fruits) {

        int maxFruits = 0;

        int left =0;
        int right = 0;
        int n = fruits.length;

        int maxLen = 0;

        HashMap<Integer, Integer> mp = new HashMap<>();

        while (right < n) {

            int fruit = fruits[right];
            mp.put(fruit, mp.getOrDefault(fruit, 0) + 1);

            while(mp.size() > 2) {
                int fruitToBeRemoved = fruits[left];
                mp.put(fruitToBeRemoved, mp.get(fruitToBeRemoved) - 1);

                if (mp.get(fruitToBeRemoved) == 0)
                    mp.remove(fruitToBeRemoved);

                left++;
            }

            right++;

            maxLen = Math.max(maxLen, right-left);

        }

        return maxLen;
    }
}
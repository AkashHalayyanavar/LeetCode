class Solution {
    public int specialTriplets(int[] nums) {
        
        Map<Integer, Integer> leftMap = new HashMap<>();
        Map<Integer, Integer> rightMap = new HashMap<>();

        final long MOD = 1000000007;

        long count = 0;

        // populate the right Map initially
        for (int num: nums) {
            rightMap.put(num, rightMap.getOrDefault(num, 0) + 1);
        }

        // Now start traversing from left
        for (int num: nums) {

            // remove the current element from right map
            rightMap.put(num, rightMap.get(num) - 1);

            // check left count
            long leftCount = leftMap.getOrDefault(num*2, 0);

            // check right count
            long rightCount = rightMap.getOrDefault(num*2, 0);

            count = (count + leftCount * rightCount) % MOD;

            // add the current element to the left map
            leftMap.put(num, leftMap.getOrDefault(num, 0) + 1);
        }

        return (int) count;
    }
}
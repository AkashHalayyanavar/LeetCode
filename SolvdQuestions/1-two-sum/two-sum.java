class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        Map<Integer, Integer> mp = new HashMap<>();

        for (int i=0; i<nums.length; i++) {
            int reqNum = target - nums[i];

            if (mp.get(reqNum) != null) {
                return new int[] {i, mp.get(reqNum)};
            }

            mp.put(nums[i], i);
        }

        return new int[] {-1, -1};
    }
}
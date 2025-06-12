class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map <Integer, Integer> mp = new HashMap<>();
        int n = nums.length;

        for (int i=0; i<n; i++) {
            int req = target - nums[i];

            if (mp.containsKey(req)) {
                return new int[]{i, mp.get(req)};
            }

            mp.put(nums[i], i);
        }
    
        return new int[] {0,0};
    }
}
class Solution {
    public int subarraySum(int[] nums, int k) {
        
        int n = nums.length;
        int[] prefixSum = new int[n];

        // Form prefix array
        prefixSum[0] = nums[0];
        for (int i=1; i<n; i++) {
            prefixSum[i] = prefixSum[i-1] + nums[i];
        }

        // System.out.println(Arrays.toString(prefixSum));

        HashMap<Integer, Integer> mp = new HashMap<>();

        // store 0 with count as 1 in hashmap
        mp.put(0, 1);

        int count = 0;

        // traverse prefix sum to findout subarray sum equals K
        for (int i=0; i<n; i++) {
            int reqNum = prefixSum[i] - k;
            count += mp.getOrDefault(reqNum, 0);
            // Add prefixSum value to map
            mp.put(prefixSum[i], mp.getOrDefault(prefixSum[i], 0) + 1);
        }

        return count;
    }
}
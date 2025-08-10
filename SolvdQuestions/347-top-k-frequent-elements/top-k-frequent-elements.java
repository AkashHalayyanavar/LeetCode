class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        Map<Integer, Integer> mp = new HashMap<>();

        for (int num: nums) {
            mp.put(num, mp.getOrDefault(num, 0) + 1);
        }

        // Integer.compare(b.getValue(), a.getValue()) we can also use this, both are same
        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>( (a,b) -> (b.getValue() - a.getValue()) );

        // put entries to the heap
        for (Map.Entry<Integer, Integer> e: mp.entrySet())
            maxHeap.add(e);

        int[] result = new int[k];

        for (int i=0; i<k; i++) 
            result[i] = maxHeap.poll().getKey();

        return result;
    }
}
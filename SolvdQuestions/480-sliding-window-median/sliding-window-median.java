class Solution {
    
    TreeSet<Integer> minHeap, maxHeap;

    // we will always keep minHeap greater than maxHeap by one or equal
    void balanceHeaps() {
        if (maxHeap.size() > minHeap.size())
            minHeap.add(maxHeap.pollFirst());
    }

    double getMedian(int[] nums, int k) {
        if (k%2 == 0)
            return ((double) nums[minHeap.first()] + nums[maxHeap.first()]) / 2;

        return (double) nums[minHeap.first()];
    }
    
    public double[] medianSlidingWindow(int[] nums, int k) {
    

        Comparator<Integer> comparator = (a,b) -> nums[a] != nums[b] ? 
            Integer.compare(nums[a], nums[b]) : a-b;

        minHeap = new TreeSet<>(comparator);
        maxHeap = new TreeSet<>(comparator.reversed());

        int n = nums.length;

        double[] result = new double[n - k + 1];

        int ans = 0;

        for (int i=0; i<n; i++) {

            // remove from heap the outside window value
            if (i >= k) {
                minHeap.remove(i-k);
                maxHeap.remove(i-k);
            }

            // add to minHeap
            minHeap.add(i);

            // remove top from minHeap and add to maxHeap
            maxHeap.add(minHeap.pollFirst());

            // balance heaps
            balanceHeaps();

            if (i >= k-1)
                result[ans++] = getMedian(nums, k);

        }

        return result;
    }
}
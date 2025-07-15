class NumArray {

    int[] segTree;
    int n;

    int buildSegTree(int start, int end, int index, int[] nums) {

        if (start == end) {
            segTree[index] = nums[start];
            return segTree[index];
        }

        int mid = start + (end - start) / 2;

        int leftSum = buildSegTree(start, mid, 2*index, nums);
        int rightSum = buildSegTree(mid+1, end, 2*index+1, nums);

        segTree[index] = leftSum + rightSum;
        return segTree[index];
    }

    public NumArray(int[] nums) {
        n = nums.length;

         // 4*n is the max size required
         // since for incomple tree, for eg: let's say 5 nodes, we need to form a complete tree
         // to utilise the 2*i and 2*i+1 indexing, so we padd those with values 0
         // note padding 0 for seg tree for sum will work, but the default padding value might be
         // different based on the use case of the seg tree
        segTree = new int[4*n];

        buildSegTree(0, n-1, 1, nums);
    }

    void updateInSegTree(int start, int end, int index, int updateIndex, int val) {

        if (start == end) {   
            if (updateIndex == start) {
                segTree[index] = val;
                return;
            }
        }

        // case1: update index is not part of this node segment
        if (updateIndex < start || updateIndex > end)
            return;

        // case: update index is part of this node segment
        int mid = start + (end - start) / 2;
        updateInSegTree(start, mid, 2*index, updateIndex, val);
        updateInSegTree(mid+1, end, 2*index+1, updateIndex, val);

        segTree[index] = segTree[2*index] + segTree[2*index+1];
    }
    
    public void update(int index, int val) {
        updateInSegTree(0, n-1, 1, index, val);
    }

    int getSumFromSegTree(int start, int end, int index, int left, int right) {

        // case1: the segment node range is non-overlapping with required range 
        if (right < start || left > end)
            return 0;

        // case2: the segment node range is completely overlapping with required range
        if (start >= left && end <= right)
            return segTree[index];

        // case3: else case, the segment node range partially overlaps with required range
        // call both the child nodes and return their sum
        int mid = start + (end - start) / 2;

        int leftSum = getSumFromSegTree(start, mid, 2*index, left, right);
        int rightSum = getSumFromSegTree(mid+1, end, 2*index+1, left, right);

        return leftSum + rightSum;
    }
    
    public int sumRange(int left, int right) {
        return getSumFromSegTree(0, n-1, 1, left, right);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */
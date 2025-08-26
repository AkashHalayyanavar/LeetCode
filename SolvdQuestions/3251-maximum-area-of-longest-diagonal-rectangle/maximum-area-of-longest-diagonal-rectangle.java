class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {

        int maxArea = Integer.MIN_VALUE;
        double LongestDiag = Integer.MIN_VALUE;

        for (int[] dim: dimensions) {
            double diagLen = Math.sqrt(dim[0]*dim[0] + dim[1]*dim[1]);
            int area = dim[0] * dim[1];

            if (diagLen > LongestDiag) {
                LongestDiag = diagLen;
                maxArea = area;
            }

            else if (diagLen == LongestDiag && area > maxArea)
                maxArea = area;
        }
        
        return maxArea;
    }
}
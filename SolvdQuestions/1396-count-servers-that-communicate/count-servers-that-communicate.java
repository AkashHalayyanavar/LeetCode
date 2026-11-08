class Solution {
    public int countServers(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        int[] rowSum = new int[m];
        int[] colSum = new int[n];

        // Calculate row sum
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                rowSum[i] += grid[i][j];
            }
        }

        // Calculate col sum
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                colSum[i] += grid[j][i];
            }
        }

        int count = 0;

        // Traverse grid
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (grid[i][j] == 1 && (rowSum[i] > 1 || colSum[j] > 1) ) {
                    count++;
                }
            }
        }

        return count;
    }
}
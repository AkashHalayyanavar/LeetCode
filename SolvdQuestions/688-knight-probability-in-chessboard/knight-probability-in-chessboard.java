class Solution {

    int[][] directions = new int[][] {
        {1,2},
        {2,1},
        {2,-1},
        {1,-2},
        {-1,-2},
        {-2,-1},
        {-2,1},
        {-1,2}
    };

    double dfs(int n, int k, int row, int col, double[][][] dp) {

        // Out of bounds → invalid path
        if (row<0 || row>=n || col<0 || col>=n) 
            return 0;

        // No moves left → knight is still on board
        if (k==0)
            return 1;

        // Already computed
        if (dp[k][row][col] != -1)
            return dp[k][row][col];

        double totalProb = 0;

        // Try all 8 possible knight moves
        // each possible moves result is divided by 8 and summed up to get the total probability
        // meaning, each move is equally weighted
        for (int[] dir: directions) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];

            totalProb += ( dfs(n, k-1, newRow, newCol, dp) / 8.0 ); 
        }

        dp[k][row][col] = totalProb;
        return totalProb;
    }

    public double knightProbability(int n, int k, int row, int column) {

        // memoization of prob, with no. of moves, row and column
        // Memoization: dp[movesLeft][row][col]
        double[][][] dp = new double[k+1][n][n];


        // initialze the dp array with -1
        for (double[][] mat: dp) {
            for (double[] rowArr: mat)
                Arrays.fill(rowArr, -1);
        }

        return dfs(n, k, row, column, dp);
    }
}
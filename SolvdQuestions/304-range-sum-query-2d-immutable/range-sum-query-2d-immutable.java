class NumMatrix {

    // The prefix[i][j] indicates the area of rectangle from (0,0) ton (i,j)
    int[][] prefix;

    public NumMatrix(int[][] matrix) {

        prefix = new int[matrix.length][matrix[0].length];

        prefix[0][0] = matrix[0][0];
        
        // initialize first row
        for (int i=1; i<matrix[0].length; i++)
            prefix[0][i] = prefix[0][i-1] + matrix[0][i];

        // initialize first column
        for (int i=1; i<matrix.length; i++)
            prefix[i][0] = prefix[i-1][0] + matrix[i][0];

        for (int i=1; i<matrix.length; i++) {
            for (int j=1; j<matrix[0].length; j++) {
                // subtract to subtract double counting
                prefix[i][j] = matrix[i][j] + prefix[i-1][j] + prefix[i][j-1] 
                    - prefix[i-1][j-1];
            }
        }

    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        
        int result = prefix[row2][col2];
        
        // addition only in this case, as it will subtract two times, so add back once
        if (row1 != 0 && col1 != 0)
            result = result - prefix[row2][col1-1] - prefix[row1-1][col2] 
                + prefix[row1-1][col1-1];

        else if (row1 != 0)
            result = result - prefix[row1-1][col2];

        else if (col1 != 0)
            result = result - prefix[row2][col1-1];

        return result;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
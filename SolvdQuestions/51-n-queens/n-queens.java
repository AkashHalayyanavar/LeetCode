class Solution {

    boolean isValid(int row, int col, int n, char[][] mat) {

        // check in the same col (previous to row, col)
        for (int i=0; i<row; i++) {
            if (mat[i][col] == 'Q')
                return false;
        }

        // check left diagonal (previous to row, col)
        for (int i=row, j=col; i>=0 && j>=0; i--, j--) {
            if (mat[i][j] == 'Q')
                return false;
        }

        // check right diagonal (previous to row, col)
        for (int i=row, j=col; i>=0 && j<n; i--, j++) {
            if (mat[i][j] == 'Q')
                return false;
        }

        return true;
    }

    void helper(int row, int n, char[][] mat, List<List<String>> result) {

        if (row == n) {
            List<String> resultMatrix = new ArrayList<>(); 
            for (char[] arr: mat) {
                resultMatrix.add(new String(arr));
            }
            result.add(resultMatrix);
            return;
        }

        for (int i=0; i<n; i++) {
            
            if ( isValid(row, i, n, mat) ) {
                mat[row][i] = 'Q';
                helper(row+1, n, mat, result);
                mat[row][i] = '.';
            }
        }

    }


    public List<List<String>> solveNQueens(int n) {

        List<List<String>> result = new ArrayList<>();

        char[][] mat = new char[n][n];
        for(char[] arr: mat)
            Arrays.fill(arr, '.');


        helper(0, n, mat, result);
        return result;
    }
}
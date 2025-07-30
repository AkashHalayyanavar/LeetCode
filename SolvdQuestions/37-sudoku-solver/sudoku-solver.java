class Solution {

    boolean solve(char[][] board, int row, int col) {
        // Base case
        if (row == board.length) {
            return true;
        }

        // Move to next row if current row is full
        if (col == board[0].length)
            return solve(board, row+1, 0);

        // skip cells that are already filled
        if (board[row][col] != '.')
            return solve(board, row, col+1);

        // Start assigning the values
        for (char num = '1'; num <= '9'; num++) {
            
            if (isValidPlacement(board, row, col, num)) {
                board[row][col] = num;

                if (solve(board, row, col+1))
                    return true;
            }
        }

        // back track to previous state if solution not found
        board[row][col] = '.';

        // No valid solution found
        return false;
    }

    boolean isValidPlacement(char[][] board, int row, int col, char num) {

        // Check if num is already in the same row, column or 3x3 subgrid
        for (int i=0; i<board.length; i++) {
            // check col
            if (board[i][col] == num)
                return false;

            // check row
            if (board[row][i] == num)
                return false;

            // check 3*3 subgrid
            int subgridRow = (row/3) * 3 + i/3; // calculate row index of subgrid
            int subgridCol = (col/3) * 3 + i%3; // calculate col index of subgrid

            if (board[subgridRow][subgridCol] == num)
                return false;
        }

        // valid placement
        return true;
    }

    public void solveSudoku(char[][] board) {
        solve(board, 0, 0);
    }
}
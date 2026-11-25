class Solution {

    void markIsland(int row, int col, int m, int n, char[][] grid, boolean[][] visited) {

        if (row >= m || row < 0 || col < 0 || col >= n || visited[row][col] || grid[row][col] == '0') {
            return;
        }

        visited[row][col] = true;

        markIsland(row+1, col, m, n, grid, visited);
        markIsland(row, col+1, m, n, grid, visited);
        markIsland(row-1, col, m, n, grid, visited);
        markIsland(row, col-1, m, n, grid, visited);

    }

    public int numIslands(char[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;

        boolean[][] visited = new boolean[m][n];
        int count = 0;

        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    markIsland(i, j, m, n, grid, visited);
                    count++;
                }
            }
        }

        return count;
    }
}
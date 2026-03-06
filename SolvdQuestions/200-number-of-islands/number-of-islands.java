class Solution {

    void markIsland(int row, int col, int m, int n, char[][] grid, boolean[][] visited) {
        if (row<0 || row>=m || col<0 || col>=n || grid[row][col] == '0' || visited[row][col])
            return;

        visited[row][col] = true;
        int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        for (int[] direction: directions) {
            markIsland(row + direction[0], col + direction[1], m, n, grid, visited);
        }
    } 

    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        boolean[][] visited = new boolean[m][n];
        int count =0;

        for (int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    markIsland(i, j, m, n, grid, visited);
                    count++;
                }
            }
        }

        return count;
    }
}
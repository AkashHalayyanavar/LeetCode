class Solution {
    public int[][] updateMatrix(int[][] mat) {
        
        // Similar to Rotten Oranges Problem
        // push all 0's and perform BFS

        // NOTE: for such min distance questions, always use BFS

        Queue<int[]> q = new ArrayDeque<>();
        int m = mat.length;
        int n = mat[0].length;

        int[][] result = new int[m][n];

        // push all 0's to the queue
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (mat[i][j] == 0)
                    q.add(new int[]{i, j});
            }
        }

        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        while (!q.isEmpty()) {

            int qSize = q.size();

            for (int i=0; i<qSize; i++) {

                int[] e = q.poll();
                int row = e[0];
                int col = e[1];

                for (int[] dir: directions) {
                    int newRow = row + dir[0];
                    int newCol = col + dir[1];

                    if (newRow < 0 || newRow >= m || newCol <0 || newCol >=n 
                            || mat[newRow][newCol] == 0 || result[newRow][newCol]>0)
                        continue;
                    
                    result[newRow][newCol] = result[row][col] + 1;
                    q.add(new int[]{newRow, newCol});
                }

            }

        }

        return result;
    }
}
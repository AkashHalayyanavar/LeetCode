class Solution {

    public int orangesRotting(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;
        int freshOranges=0;
        int time=0;

        Queue<int[]> q = new ArrayDeque<>();

        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (grid[i][j] == 2)
                    q.add(new int[] {i,j});
                else if (grid[i][j] == 1)
                    freshOranges++;
            }
        }

        // handle edge case, where there are no fresh oranges
        if (freshOranges == 0)
            return 0;

        while (!q.isEmpty()) {

            int qSize = q.size();

            for (int i=0; i<qSize; i++) {

                int[] pos = q.poll();
                int row = pos[0];
                int col = pos[1];

                int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}};

                for (int[] dir: directions) {
                    int newRow = row+dir[0];
                    int newCol = col+dir[1];

                    if(newRow>=0 && newRow<m && newCol>=0 && newCol<n && grid[newRow][newCol] == 1) {
                            grid[newRow][newCol] = 2;
                            freshOranges--;
                            q.add(new int[]{newRow, newCol});
                    }
                }

            }
            time++;
        }
        
        return freshOranges==0 ? time-1: -1;
    }
}
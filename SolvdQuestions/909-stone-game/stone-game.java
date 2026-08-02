class Solution {

    int aliceMaxStones=0;
    int bobMaxStones=0;

    int getMaxStones(int[] piles, int start, int end, int size, boolean turn, int[][] dp) {

        if (start == size || end == -1 || start > end) {
            return 0;
        }

        if (dp[start][end] != -1) {
            return dp[start][end];
        }

        // Alice Turn
        if (turn == true) {
            turn = false;
            aliceMaxStones = Math.max(piles[start] + getMaxStones(piles, start+1, end, size, turn, dp), piles[end] + getMaxStones(piles, start, end-1, size, turn, dp));
            dp[start][end] = aliceMaxStones;
            return aliceMaxStones;
        } else {
            turn = true;
            bobMaxStones = Math.max(piles[start] + getMaxStones(piles, start+1, end, size, turn, dp), piles[end] + getMaxStones(piles, start, end-1, size, turn, dp));
            dp[start][end] = bobMaxStones;
            return bobMaxStones;
        }

    }
    

    public boolean stoneGame(int[] piles) {

        // Alice Starts the turn
        // turn true implies Alice's turn
        boolean turn = true;

        int size = piles.length;

        int[][] dp = new int[size][size];

        for (int i=0; i<size; i++) {
            Arrays.fill(dp[i], -1);
        }

        getMaxStones(piles, 0, size-1, size, turn, dp);

        return aliceMaxStones > bobMaxStones;
    }
}
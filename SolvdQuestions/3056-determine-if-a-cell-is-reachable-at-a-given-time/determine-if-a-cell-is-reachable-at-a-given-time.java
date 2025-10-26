class Solution {
    public boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {

        int xdiff = Math.abs(sx - fx);
        int ydiff = Math.abs(sy - fy);

        int maxdiff = Math.max(xdiff, ydiff);

        // edge case
        if (maxdiff == 0 && t==1)
            return false;

        return maxdiff <= t;
    }
}
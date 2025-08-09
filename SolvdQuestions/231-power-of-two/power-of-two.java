class Solution {
    public boolean isPowerOfTwo(int n) {

        for (int i=1; i <= n && i>0; i*=2) {
            if (i == n)
                return true;
        } 

        return false;
    }
}
public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        
        int result = 0;

        // if we shift the bits one by one starting from the end then it will be reversed
        for (int i=0; i<32; i++) {
            result = result << 1;
            result |= (n & 1);
            n = n >> 1;
        }
        return result;
    }
}
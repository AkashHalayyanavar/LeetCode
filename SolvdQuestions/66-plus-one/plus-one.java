class Solution {


    public int[] plusOne(int[] digits) {

        int n = digits.length;
        int[] res = new int[n];
        
        int i = n-1;
        while (i>=0 && digits[i] == 9) {
            res[i] = 0;
            i--;
        }

        // now increment the last digit by 1
        if (i < 0) {
            res = new int[n+1];
            res[0] = 1;
        } else {
            res[i] = digits[i] + 1;
            i--;
            while (i >= 0) {
                res[i] = digits[i];
                i--;
            }
        }
        
        return res;
    }
}
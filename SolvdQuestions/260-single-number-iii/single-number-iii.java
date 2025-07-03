class Solution {
    public int[] singleNumber(int[] nums) {

        int result = 0;

        for (int num: nums) {
            result ^= num;
        }

        // count for bit position 1 in result
        int count = 0;

        System.out.println(result);

        while ( (result & 1) != 1) {
            result = result >> 1; 
            count++;
        }

        long xorNum = (long) Math.pow(2, count);

        int num1=0, num2=0;

        for (int num: nums) {
            if ( (num & xorNum) == xorNum) {
                num1 ^= num;
            } else {
                num2 ^= num;
            }
        }

        return new int[]{num1, num2};
    }
}
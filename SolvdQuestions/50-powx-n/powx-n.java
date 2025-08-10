class Solution {
    public double myPow(double x, int n) {

        // To handle Integer min value, as -ve value will be one num greater than +ve, 
        // it will overflow if we directly assign the value
        long N = n;

        if (N < 0) {
            N = -N;
            x = 1/x;
        }
        
        double result = 1;

        while (N > 0) {
            // when n is odd, we will multiple current x value with result
            // logic: (16)^5 => 16 * result, then remaining (16^4) = (16^2)^2
            if (N%2 == 1) {
                result = result * x;
            }

            // logic 2^10 = (2^2)^5 and so on, so we double x and halve n
            x = x * x;
            N = N/2;
        }

        // since at the end we will receive n as 1 before getting 0, so result will have final value
        return result;
    }
}
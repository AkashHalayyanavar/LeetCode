class Solution {
    public int longestValidParentheses(String s) {

        int left=0;
        int right=0;
        int max=0;
        int n = s.length();

        // The below loop handles right ')' orphans but doesn't handle left '(' orphans 
        for (int i=0; i<n; i++) {
            if (s.charAt(i) == '(')
                left++;
            else
                right++;
            
            // update max if left and right match
            if (left == right)
                max = Math.max(max, 2*left);

            // reset if right > left, as it is no more valid
            if (right > left) {
                left=0;
                right=0;
            }
        }
        
        // Run in reverse direction to handle left '(' orphans
        // eg: (()

        left = 0;
        right = 0;

        for (int i=n-1; i>=0; i--) {
            if (s.charAt(i) == '(')
                left++;
            else
                right++;
            
            // update max if left and right match
            if (left == right)
                max = Math.max(max, 2*left);

            // reset if left > right, as it is no more valid
            if (left > right) {
                left = 0;
                right = 0;
            }
        }

        return max;

    }
}
class Solution {
public:
    int reverse(int x) {
        
        int rev=0;
        while(x)
        {
            int digit = x%10;
            x = x/10;
            
            if(digit>=0)
            {
                if(rev<=(INT_MAX-digit)/10)
                    rev = rev*10+digit;
                else
                    return 0;
            }
            else
            {
                if(rev>=(INT_MIN-digit)/10)
                    rev = rev*10+digit;
                else
                    return 0;
            }
            
        }
        
        
        
        return rev;
            
    }
};
class Solution {
    public int totalMoney(int n) {

        int numWeeks = n/7;
        int remDays = n%7;

        int result = numWeeks * 28;

        // 0 + 1*7 + 2*7 + ... + (numWeeks-1)*7
        result += ( ((numWeeks-1) * (numWeeks)) / 2 ) * 7;

        result += ( (remDays * (remDays+1)) / 2) + (numWeeks * remDays);

        return result;
        
    }
}
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {

        int totalGas = 0;
        int totalCost = 0;

        // Else, there is definitely one index which completes the circle
        int n = gas.length;
        int start = 0;
        int currGas = 0;
        
        for (int i=0; i<n; i++) {
            totalGas += gas[i];
            totalCost += cost[i];
            
            currGas += gas[i];

            // cannot reach next index
            if (currGas - cost[i] < 0) {
                start = i+1;
                currGas = 0;
            } else {
                currGas -= cost[i];
            }

        }

        // if totalcost is greater than totalgas, then it is not possible to complete circle from any index
        if (totalCost > totalGas) 
            return -1;

        // else case, why only one loop works:
        // Lets say the first part is before the start index and second part is after start index
        // Let g1 and c1 be the sum of gas and sum of cost for first part
        // Let g2 and c2 be the sum of gas and sum of cost for second part
        // Now, we already know that g1+g2 >= c1+c2
        // We have to prove why only the computation till end will prove it as start index
        // From the equation we can deduce c1 <= g1 + (g2-c2), so with the left fuel + g1, we can definitely cover c1, hence no need to check, if not we are returning -1, as it will not be possible

        return start;
    }
}
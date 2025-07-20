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

        return start;
    }
}
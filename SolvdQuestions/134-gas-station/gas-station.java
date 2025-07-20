class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {

        int totalGas = Arrays.stream(gas).sum();
        int totalCost = Arrays.stream(cost).sum();

        // if totalcost is greater than totalgas, then it is not possible to complete circle from any index
        if (totalCost > totalGas) 
            return -1;

        // Else, there is definitely one index which completes the circle
        int n = gas.length;
        int start = 0;
        int currGas = 0;
        
        for (int i=0; i<n; i++) {

            currGas += gas[i];

            // cannot reach next index
            if (currGas - cost[i] < 0) {
                start = i+1;
                currGas = 0;
            } else {
                currGas -= cost[i];
            }

        }

        return start;
    }
}
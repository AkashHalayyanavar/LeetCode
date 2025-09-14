func canCompleteCircuit(gas []int, cost []int) int {
    
    totalGas := 0
    totalCost := 0

    currGas := 0 
    startIndex := 0

    for i:=0; i<len(gas); i++ {
        if currGas + gas[i] >= cost[i] {
            currGas = currGas + gas[i] - cost[i]
        } else {
            currGas = 0
            startIndex = i+1
        }
        totalGas += gas[i]
        totalCost += cost[i]
    }

    if totalCost > totalGas {
        return -1
    }

    return startIndex

}
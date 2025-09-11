func getMax(a int, b int) int {
    if a > b {
        return a
    }

    return b
}

func maxSubArray(nums []int) int {

    fmt.Println("Size : ", len(nums))

    globalMax := nums[0]
    currMax := nums[0]
    n := len(nums)

    for i:=1; i<n; i++ {
        currMax += nums[i]
        if nums[i] > currMax {
            currMax = nums[i]
        }

        globalMax = getMax(globalMax, currMax)
    }

    return globalMax
    
}
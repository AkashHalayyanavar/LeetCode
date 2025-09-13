func isPossible(prevJump int, currentVal int, target int, set map[int]struct{}, dp map[[2]int]bool) bool {

    if reachable, exists := dp[[2]int{prevJump,currentVal}]; exists {
        return reachable
    }

    if currentVal == target {
        dp[[2]int{prevJump,currentVal}] = true
        return true
    }

    var jump1, jump2, jump3 bool

    if _, exists := set[currentVal+prevJump-1]; exists && prevJump > 1 {
        jump1 = isPossible(prevJump-1, currentVal+prevJump-1, target, set, dp)
    }

    if _, exists := set[currentVal+prevJump]; exists {
        jump2 = isPossible(prevJump, currentVal+prevJump, target, set, dp)
    }

    if _, exists := set[currentVal+prevJump+1]; exists {
        jump3 = isPossible(prevJump+1, currentVal+prevJump+1, target, set, dp)
    }

    dp[[2]int{prevJump,currentVal}] = jump1 || jump2 || jump3
    return dp[[2]int{prevJump,currentVal}]
}

func canCross(stones []int) bool {
    
    prevJump := 1
    n := len(stones)

    if stones[1] > 1 {
        return false
    }

    set := make(map[int]struct{})
    dp := make(map[[2]int]bool)

    for _, val := range stones {
        set[val] = struct{}{}
    }

    if isPossible(prevJump, 1, stones[n-1], set, dp) {
        return true
    }

    return false
}
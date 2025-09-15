func max(a, b int) int {
    if a>b {
        return a
    }
    return b
}

func lengthOfLongestSubstring(s string) int {

    mp := make(map[byte]struct{})

    maxLen, i, j := 0, 0, 0

    for j < len(s) {
        
        if _, exists := mp[s[j]]; !exists {
            mp[s[j]] = struct{}{}
        } else {

            for _, exists := mp[s[j]]; exists; _, exists = mp[s[j]] {
                delete(mp, s[i])
                i++
            }
        }

        mp[s[j]] = struct{}{}

        maxLen = max(maxLen, j-i+1)
        j++
    }
    
    return maxLen
}
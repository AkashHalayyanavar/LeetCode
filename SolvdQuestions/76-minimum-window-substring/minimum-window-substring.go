// func min(a , b int) int {
//     if a < b {
//         return a
//     }
//     return b
// }


func minWindow(s string, t string) string {
    
    count := len(t)

    mp := make(map[byte]int)

    for i:=0; i<len(t); i++ {
        ch := t[i]
        if _, exists := mp[ch]; exists {
            mp[ch] += 1
        } else {
            mp[ch] = 1
        }
    }

    startIndex := 0
    minLen := math.MaxInt

    i := 0
    j := 0

    for j<len(s) {

        if _, exists := mp[s[j]]; exists {

            if mp[s[j]] > 0 {
                count--;
            }
            mp[s[j]] -= 1

            for (count == 0) {

                if j-i+1 < minLen {
                    minLen = j-i+1
                    startIndex = i
                }

                if _, exists := mp[s[i]]; exists {
                    mp[s[i]] += 1
                    if (mp[s[i]] >= 1) {
                        count++
                    }
                }
                
                i++
            }
        }
        j++
    }

    result := ""
    if minLen != math.MaxInt {
        result = s[startIndex : startIndex+minLen]
    }

    return result
}
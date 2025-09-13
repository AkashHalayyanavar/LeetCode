func decodeAtIndex(s string, k int) string {

    size := 0

    for _, ch := range s {
        if ch >= '0' && ch <= '9' {
            size *= int(ch - '0')
        } else {
            size++;
        }
    }

    for j := len(s)-1; j >= 0; j-- {
        if s[j] >= '0' && s[j] <= '9' {
            size = size / int(s[j] - '0')
        } else {
            // NOTE: the below mod assignment is necessary
            // As we will be always keeping k size <= size
            // else it will lead to unexpected results
            k = k%size
            if k == 0 {
                return string(s[j])
            }
            size--;
        }
    }
    
    return ""
}
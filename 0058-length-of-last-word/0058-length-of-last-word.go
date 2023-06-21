func lengthOfLastWord(s string) int {
    i, n := 0, len(s)
    for ; n-1-i>=0; i++ {
        if s[n-1-i] != ' ' {
            break
        }
    }
    
    for j:=i; n-1-j>=0; j++ {
        if s[n-1-j] == ' ' {
            return j-i
        }
    }
    return n-i
}
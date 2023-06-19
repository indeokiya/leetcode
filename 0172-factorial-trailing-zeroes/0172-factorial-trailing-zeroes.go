func trailingZeroes(n int) int {
    x := 5
    ans := 0
    
    for n >= 5 {
        ans += n/x
        n /= 5
    }
    
    
    return ans
}
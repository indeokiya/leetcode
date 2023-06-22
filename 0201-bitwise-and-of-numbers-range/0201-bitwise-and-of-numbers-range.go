func rangeBitwiseAnd(left int, right int) int {
    
    ans := 0
    m, n := getMsb(left), getMsb(right)
    
    if m < n {
        return ans
    }
    
    for ; m>=1; m>>=1 {
        if left & m != right & m {
            break
        }
        ans |= left & m
    }
    
    return ans
}

func getMsb(n int) int {
    n |= n>>1
    n |= n>>2
    n |= n>>4
    n |= n>>8
    n |= n>>16
    n >>= 1
    return n+1
}
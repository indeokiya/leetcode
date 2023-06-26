func isSubsequence(s string, t string) bool {
    M, N := len(s), len(t)
    if M > N {
        return false
    }
    
    p1, p2 := 0, 0
    
    for p1<M && p2<N {
        if M-p1 > N-p2 {
            return false
        }
        
        if s[p1] == t[p2] {
            p1++
        }
        p2++
    }
    
    return p1==M
}
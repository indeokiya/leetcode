func isIsomorphic(s string, t string) bool {
    From := make([]byte, 128, 128)
    To := make([]byte, 128, 128)
    
    for i:=0; i<len(s); i++ {
        from, to := s[i]+1, t[i]+1
        if From[from] == 0 {
            if To[to] != 0 {
                return false
            }
            From[from] = to
            To[to] = from
            continue
        }
        
        if From[from] != to {
            return false
        }
    }
    
    return true
}
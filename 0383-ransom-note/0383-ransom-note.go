func canConstruct(ransomNote string, magazine string) bool {
    M, N := len(ransomNote), len(magazine)
    if M > N {
        return false
    }
    
    m := make([]int, 26, 26)
    
    for i:=0; i<N; i++ {
        m[magazine[i]-'a']++
    }
    
    for i:=0; i<M; i++ {
        m[ransomNote[i]-'a']--
        if m[ransomNote[i]-'a'] < 0 {
            return false
        }
    }
    
    return true
}
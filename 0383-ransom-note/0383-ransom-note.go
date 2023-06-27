func canConstruct(ransomNote string, magazine string) bool {
    M, N := len(ransomNote), len(magazine)
    if M > N {
        return false
    }
    
    m := map[byte]int{}
    
    for i:=0; i<N; i++ {
        char := magazine[i]
        _, ok := m[char]
        if ok {
            m[char]++
        } else {
            m[char] = 1
        }
    }
    
    for i:=0; i<M; i++ {
        char := ransomNote[i]
        num, ok := m[char]
        if !ok {
            return false
        }
        if num <= 0 {
            return false
        }
        m[char]--
    }   
    
    return true
}
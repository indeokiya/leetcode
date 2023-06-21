func longestCommonPrefix(strs []string) string {
    ans := 0
    
    for i:=0; i<len(strs[0]); i++ {
        for j:=1; j<len(strs); j++ {
            if i == len(strs[j]) || strs[0][i] != strs[j][i] {
                return strs[0][:ans]
            }
        }
        ans++
    }

    return strs[0][:ans]
}
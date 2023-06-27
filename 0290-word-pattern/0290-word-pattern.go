type E struct {}

func wordPattern(pattern string, s string) bool {
    splited := strings.Split(s, " ")
    if len(pattern) != len(splited) {
        return false
    }
    mapping := map[byte]string{}
    exist := map[string]E{}
    
    for i:=0; i<len(pattern); i++ {
        b := pattern[i] - 'a'
        str, ok := mapping[b]
        if !ok {
            _, e := exist[splited[i]]
            if e {
                return false
            }
            
            mapping[b] = splited[i]
            exist[splited[i]] = E{}
            continue
        }
        if str != splited[i] {
            return false
        }
    }
    
    return true
}
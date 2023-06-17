type Pair struct {
    from, to int
}

func findJudge(n int, trust [][]int) int {
    matrix := make([]Pair, n+1, n+1)
    for i:=1; i<=n; i++ {
        matrix[i] = Pair{0, 0}
    }    
    
    for _, t := range trust {
        matrix[t[0]].from++
        matrix[t[1]].to++
    }
    
    for i:=1; i<=n; i++ {
        if matrix[i].from == 0 && matrix[i].to == n-1 {
            return i
        }
    }
    
    return -1
}
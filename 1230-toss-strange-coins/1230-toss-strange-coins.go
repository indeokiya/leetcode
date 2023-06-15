func probabilityOfHeads(prob []float64, target int) float64 {
    N := len(prob)
    memo := make([]float64, target+2, target+2)
    
    memo[0] = 1-prob[0]
    memo[1] = prob[0]
    for i:=1; i<N; i++ {
        for j:=min(target, i); j>=0; j-- {
            memo[j+1] += memo[j] * prob[i]
            memo[j] *= 1-prob[i]
        }
    }
    
    return memo[target]
}

func min(a, b int) int {
    if a < b {
        return a
    }
    return b
}
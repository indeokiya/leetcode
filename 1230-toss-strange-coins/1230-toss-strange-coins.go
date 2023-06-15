func probabilityOfHeads(prob []float64, target int) float64 {
    N := len(prob)
    memo := make([][]float64, N, N)
    slices := make([]float64, N*(N+1), N*(N+1))
    for i:=0; i<N; i++ {
        memo[i], slices = slices[:N+1], slices[N+1:]
    }
    
    memo[0][0] = 1-prob[0]
    memo[0][1] = prob[0]
    for i:=1; i<N; i++ {
        for j:=0; j<=min(target,i); j++ {
            memo[i][j] += memo[i-1][j] * (1-prob[i])
            memo[i][j+1] += memo[i-1][j] * prob[i]
            
        }
    }
    
    return memo[N-1][target]
}

func min(a, b int) int {
    if a < b {
        return a
    }
    return b
}
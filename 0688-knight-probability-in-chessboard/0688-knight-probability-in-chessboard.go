func knightProbability(n int, k int, row int, column int) float64 {
	memo := make([][][]float64, k+1, k+1)
    slices := make([]float64, n*n*(k+1), n*n*(k+1))

	for i := 0; i < k+1; i++ {
		square := make([][]float64, n, n)
		for j := 0; j < n; j++ {
			square[j], slices = slices[:n], slices[n:]
		}
		memo[i] = square
	}

    memo[0][row][column] = 1.0
    
    dr := []int{-2, -1, 1, 2, 2, 1, -1, -2}
	dc := []int{1, 2, 2, 1, -1, -2, -2, -1}
    
    for depth:=1; depth<=k; depth++ {
        for r:=0; r<n; r++ {
            for c:=0; c<n; c++ {
                for i:=0; i<8; i++ {
                    nR, nC := r+dr[i], c+dc[i]
                    if nR<0 || nR>=n || nC<0 || nC>=n {
                        continue
                    }
                    memo[depth][r][c] += memo[depth-1][nR][nC] / 8.0
                }            
            }
        }
    }
    
    answer := 0.0
    
    for i:=0; i<n; i++ {
        for j:=0; j<n; j++ {
            answer += memo[k][i][j]
        }
    }
	return answer
}


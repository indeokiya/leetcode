func knightProbability(n int, k int, row int, column int) float64 {
	memo := make([][][]float64, k+1, k+1)
	visited := make([][][]bool, k+1, k+1)
    slices1 := make([]float64, n*n*(k+1), n*n*(k+1))
    slices2 := make([]bool, n*n*(k+1), n*n*(k+1))

	for i := 0; i < k+1; i++ {
		square1 := make([][]float64, n, n)
		square2 := make([][]bool, n, n)
		for j := 0; j < n; j++ {
			square1[j], slices1 = slices1[:n], slices1[n:]
			square2[j], slices2 = slices2[:n], slices2[n:]
		}
		memo[i] = square1
		visited[i] = square2
	}

	dr := []int{-2, -1, 1, 2, 2, 1, -1, -2}
	dc := []int{1, 2, 2, 1, -1, -2, -2, -1}

    answer := float64(0)
    
    for i:=0; i<n; i++ {
        for j:=0; j<n; j++ {
            answer += dp(i, j, k, n, &memo, &visited, &dr, &dc, row, column) 
        }
    }
	return answer
}

func dp(r, c, depth, n int, memo *[][][]float64, visited *[][][]bool, dr, dc *[]int, R, C int) float64 {
	if (*visited)[depth][r][c] {
		return (*memo)[depth][r][c]
	}

	if depth == 0 {
		if r == R && c == C {
			return 1
		}
		return 0
	}

	for i := 0; i < 8; i++ {
		nR, nC := r+(*dr)[i], c+(*dc)[i]
		if nR < 0 || nR >= n || nC < 0 || nC >= n {
			continue
		}
		(*memo)[depth][r][c] += dp(nR, nC, depth-1, n, memo, visited, dr, dc, R, C) / 8
	}

    (*visited)[depth][r][c] = true
	return (*memo)[depth][r][c]
}
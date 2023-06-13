func cherryPickup(grid [][]int) int {
	M, N := len(grid), len(grid[0])
	memo := make([][][]int, M+1, M+1)
    slices := make([]int, (M+1)*N*N, (M+1)*N*N)
	for i := 0; i <= M; i++ {
		tmp := make([][]int, N, N)
		for j := 0; j < N; j++ {
			tmp[j], slices = slices[:N], slices[N:]
		}
		memo[i] = tmp
	}

	for row := M - 1; row >= 0; row-- {
		for i := 0; i < N-1; i++ {
			for j := i + 1; j < N; j++ {
				curr := 0
				for k := i-1; k <= i+1; k++ {
                    if k<0 {
                        continue
                    }
					for l := j-1; l <= j+1; l++ {
                        if l>=N || l<=k {
                            continue
                        }
						curr = max(curr, memo[row+1][k][l])
					}
				}

				memo[row][i][j] = curr + grid[row][i] + grid[row][j]
			}
		}
	}

	return memo[0][0][N-1]
}

func max(a, b int) int {
	if a < b {
		return b
	}
	return a
}
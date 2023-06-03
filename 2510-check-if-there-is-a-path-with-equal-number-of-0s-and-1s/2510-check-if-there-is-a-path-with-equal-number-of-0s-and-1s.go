var R, C int

func isThereAPath(grid [][]int) bool {
	R, C = len(grid), len(grid[0])

	if (R+C)&1 == 0 {
		return false
	}

	var memo [101][101][200]bool
	return dfs(0, 0, 0, &grid, &memo)
}

func dfs(r, c, diff int, grid *[][]int, memo *[101][101][200]bool) bool {
	if r >= R || c >= C || R+C-1-r-c < diff || R+C-1-r-c < -diff {
		return false
	}

	diff += (*grid)[r][c]<<1 - 1
	if r == R-1 && c == C-1 {
		return diff == 0
	}

	if memo[r][c][diff+100] {
		return false
	}
	memo[r][c][diff+100] = true

	return dfs(r+1, c, diff, grid, memo) || dfs(r, c+1, diff, grid, memo)
}
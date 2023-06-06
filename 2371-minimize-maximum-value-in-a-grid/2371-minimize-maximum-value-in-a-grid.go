type Pair struct {
    val, r, c int
}

func minScore(grid [][]int) [][]int {
    m, n := len(grid), len(grid[0])
    out := make([][]int, m)
    slices := make([]int, m*n)
    for i:=0; i<m; i++ {
        out[i], slices = slices[:n], slices[n:]
    }
    
    queue := make([]Pair, 0, m*n)
    
    for i:=0; i<m; i++ {
        for j:=0; j<n; j++ {
            queue = append(queue, Pair{grid[i][j], i, j})
        }
    }
    
    sort.Slice(queue, func (i, j int) bool {
        return queue[i].val < queue[j].val
    })
    
    rows := make([]int, m, m)
    cols := make([]int, n, n)
    
    for _, pair := range queue {
        r, c := pair.r, pair.c
        val := max(rows[pair.r], cols[pair.c]) + 1
        out[r][c] = val
        rows[r] = val
        cols[c] = val
    }
    
    
    return out
}

func max(a, b int) int {
    if a < b {
        return b
    }
    return a
}
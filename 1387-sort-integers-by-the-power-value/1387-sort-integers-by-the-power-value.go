type pair struct {
    idx, val int
}

var dp map[int]int

func getKth(lo int, hi int, k int) int {
    
    dp = map[int]int{}
    pairs := []*pair{}
    
    for i := lo; i <= hi; i++ {
        pairs = append(pairs, &pair{
            idx: i, 
            val: rec(i),
        })
    }
    
    sort.Slice(pairs, func(i, j int) bool {
        if pairs[i].val != pairs[j].val {
            return pairs[i].val < pairs[j].val
        } 
        return pairs[i].idx < pairs[j].idx
    })
    
    return pairs[k-1].idx
}

func rec(n int) int {
    if n == 1 {
        return 0
    }
    
    if dp[n] > 0 {
        return dp[n]
    }    
    
    if n & 1 == 0 {
        dp[n] = rec(n >> 1) + 1
        return dp[n]
    } else {
        dp[n] = rec(3*n + 1) + 1
        return dp[n]
    }
    
    
}
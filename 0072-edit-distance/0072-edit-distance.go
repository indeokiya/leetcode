func minDistance(word1 string, word2 string) int {
    M, N := len(word1), len(word2)
    
    memo := make([][]int, M+1, M+1)
    slices := make([]int, (M+1)*(N+1), (M+1)*(N+1))
    for i:=0; i<=M; i++ {    
        for j:=0; j<=N; j++ {
            slices[j] = -1
        }
        memo[i], slices = slices[:N+1], slices[N+1:]
    }
    
    return rec(M, N, word1, word2, &memo)
}

func rec(n, m int, s1, s2 string, memo *[][]int) int {
    if n==0 || m==0 {
        return max(n, m)
    }
    if (*memo)[n][m] > -1 {
        return (*memo)[n][m]
    }
    
    if (s1[n-1] != s2[m-1]) {
        (*memo)[n][m] = min(rec(n-1, m, s1, s2, memo), rec(n, m-1, s1, s2, memo), rec(n-1, m-1, s1, s2, memo)) + 1
    } else {
        (*memo)[n][m] = rec(n-1, m-1, s1, s2, memo)
    }
    
    return (*memo)[n][m]
}

func min(a ...int) (MIN int) {
    MIN = 500
	for _, num := range a {
		if MIN > num {
			MIN = num
		}
	}
	return
}

func max(a, b int) int {
    if a < b {
        return b
    }
    return a
}

/*
    ""  e   x   e   c   u   t   i   o   n
""  0   1   2   3   4   5   6   7   8   9
i   1   0   1   
n   2   2
t   3   3
e   4   3
n   5   4
t   6   5

add
    memo[i][j] = memo[i][j-1] + 1
delete
    memo[i][j] = memo[i-1][j] + 1
replace
    memo[i][j] = memo[i-1][j-1] + 1


*/
func minDistance(word1 string, word2 string) int {
    M, N := len(word1), len(word2)
    
    memo := make([][]int, M+1, M+1)
    slices := make([]int, (M+1)*(N+1), (M+1)*(N+1))
    for i:=0; i<=M; i++ {
        for j:=0; j<=N; j++ {
            memo[i] = slices[i*(N+1):(i+1)*(N+1)]
        }
    }
    
    for j:=1; j<=N; j++ {
        memo[0][j] = j;
    }
    for i:=1; i<=M; i++ {
        memo[i][0] = i;
    }

    for i:=1; i<=M; i++ {
        for j:=1; j<=N; j++ {
            if word1[i-1] == word2[j-1] {
                memo[i][j] = memo[i-1][j-1]
                continue
            }
            memo[i][j] = min(memo[i-1][j-1], memo[i-1][j], memo[i][j-1]) + 1
        }
    }
    
    
    return memo[M][N]
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
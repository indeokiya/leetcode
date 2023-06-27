func isInterleave(s1 string, s2 string, s3 string) bool {
    M, N := len(s1), len(s2)
    if M + N != len(s3) {
        return false
    }
    
    memo := make([][]bool, M+1, M+1)
    slices := make([]bool, (M+1)*(N+1))
    for i:=0; i<=M; i++ {
        memo[i], slices = slices[:N+1], slices[N+1:]
    }
                   
    memo[0][0] = true
    for j:=1; j<=N; j++ {
        if s2[j-1] != s3[j-1] {
            break
        }
        memo[0][j] = true
    }
    
    for i:=1; i<=M; i++ {
        if s1[i-1] != s3[i-1] {
            break
        }
        memo[i][0] = true
    }
    
    for i:=1; i<=M; i++ {
        for j:=1; j<=N; j++ {
            memo[i][j] = (memo[i-1][j] && s3[i+j-1] == s1[i-1]) || (memo[i][j-1] && s3[i+j-1] == s2[j-1])
        }
    }
    
    return memo[M][N]
}

/*
f(i, j) = (f(i-1, j) && s1[i]) || (f(i, j-1) && s2[j])

    ""  a   a   b   c   c
""  T   T
d   T   
b
b
c
a


*/ 
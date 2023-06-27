func isInterleave(s1 string, s2 string, s3 string) bool {
    M, N := len(s1), len(s2)
    if M + N != len(s3) {
        return false
    }
    
    if M < N {
        return isInterleave(s2, s1, s3)
    }
    
    memo := make([]bool, N+1, N+1)
                   
    memo[0] = true
    for j:=1; j<=N; j++ {
        if s2[j-1] != s3[j-1] {
            break
        }
        memo[j] = true
    }
    
    for i:=1; i<=M; i++ {
        memo[0] = memo[0] && s3[i-1] == s1[i-1]
        for j:=1; j<=N; j++ {
            memo[j] = (memo[j] && s3[i+j-1] == s1[i-1]) || (memo[j-1] && s3[i+j-1] == s2[j-1])
        }
    }
    
    return memo[N]
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
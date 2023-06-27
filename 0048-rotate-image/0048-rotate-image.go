func rotate(matrix [][]int)  {
    n := len(matrix)
    for i:=0; 2*i<=n; i++ {
        for j:=i; j<n-1-i; j++ {
            tmp := matrix[n-1-j][i]
            matrix[n-1-j][i] = matrix[n-1-i][n-1-j]
            matrix[n-1-i][n-1-j] = matrix[j][n-1-i]
            matrix[j][n-1-i] = matrix[i][j]
            matrix[i][j] = tmp
        }
    }
}

/*

(i, j) -> (j,n-1-i) -> (n-1-i, n-1-j) -> (n-1-j, i) -> (i, j)

*/
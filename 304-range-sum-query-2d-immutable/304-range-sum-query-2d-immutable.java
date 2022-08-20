class NumMatrix {
    private int[][] memo;

    // initialize memo
    public NumMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        memo = new int[m+1][n+1];
        // ans = new int[m][n];
        
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                memo[i+1][j+1] = matrix[i][j] + memo[i+1][j] + memo[i][j+1] - memo[i][j];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        return memo[row2+1][col2+1] - memo[row2+1][col1] - memo[row1][col2+1] + memo[row1][col1]; 
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
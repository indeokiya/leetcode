class Solution {
    public int uniquePaths(int m, int n) {
        //m+n-2 C n-1
        int[][] memo = new int[m+1][n+1];
        memo[1][0] = 1;
        for (int i=1; i<=m; i++) {
            for (int j=1; j<=n; j++) {
                memo[i][j] = memo[i-1][j] + memo[i][j-1];
            }
        }
        
        return memo[m][n];
    }
} 
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[][] memo = new int[m+1][n+1];
        memo[1][0] = 1;
        for (int i=1; i<=m; i++) {
            for (int j=1; j<=n; j++) {
                if (obstacleGrid[i-1][j-1] == 0) {
                    memo[i][j] = memo[i-1][j] + memo[i][j-1];                   
                } else {
                    memo[i][j] = 0;
                }

            }
        }
        
        return memo[m][n];       
    }
}
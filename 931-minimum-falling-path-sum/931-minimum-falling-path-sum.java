class Solution {
    //private int memo[][];
    private int n;
    
    public int minFallingPathSum(int[][] matrix) {
        n = matrix.length;
        if (n==1) return matrix[0][0];
        
        int[][] memo = new int[n][n];
        memo[n-1] = matrix[n-1];
        
        for (int i=n-2; i>=0; i--) {
            memo[i][0] = matrix[i][0] + Math.min(memo[i+1][0], memo[i+1][1]);
            for (int j=1; j<n-1; j++) {
                memo[i][j] = matrix[i][j] + Math.min(Math.min(memo[i+1][j-1], memo[i+1][j]), memo[i+1][j+1]);
            }
            memo[i][n-1] = matrix[i][n-1] + Math.min(memo[i+1][n-2], memo[i+1][n-1]);
        }
        
        int ans = Integer.MAX_VALUE;
        for (int j=0; j<n; j++) {
            ans = Math.min(memo[0][j], ans);
        }
        
        return ans;
    }
}
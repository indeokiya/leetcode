class Solution {
    public int[][] matrixBlockSum(int[][] mat, int k) {
        int m=mat.length, n=mat[0].length;
        int[][] memo = new int[m][n];
        
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (i>0 && j>0) {
                    memo[i][j] = mat[i][j] + memo[i-1][j] + memo[i][j-1] - memo[i-1][j-1];
                } else if (i==0 && j!=0) {
                    memo[0][j] = mat[0][j] + memo[0][j-1]; 
                } else if (i!=0 && j==0) {
                    memo[i][0] = mat[i][0] + memo[i-1][0];
                } else {
                    memo[0][0] = mat[0][0];
                }
            }
        }
        
        int[][] blockSum = new int[m][n];
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                blockSum[i][j] += memo[Math.min(i+k, m-1)][Math.min(j+k, n-1)];
                if (i-k-1>=0) {
                    blockSum[i][j] -= memo[i-k-1][Math.min(j+k, n-1)];
                } 
                if (j-k-1>=0) {
                    blockSum[i][j] -= memo[Math.min(i+k, m-1)][j-k-1];
                } 
                if (i-k-1>=0 && j-k-1>=0) {
                    blockSum[i][j] += memo[i-k-1][j-k-1];
                }
            }
        }
        
        return blockSum;
    }
}
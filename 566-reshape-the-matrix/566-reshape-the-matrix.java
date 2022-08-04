class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        if (mat.length * mat[0].length != r*c) return mat;
        int[][] ans = new int[r][c];
        
        for (int i=0; i<mat.length; i++) {
            for (int j=0; j<mat[0].length; j++) {
                ans[(i*mat[0].length+j)/c][(i*mat[0].length+j)%c] = mat[i][j];        
            }
        }
        return ans;
    }
}
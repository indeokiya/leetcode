class NumMatrix {
    private int[][] bit;
    private int m, n;
    
    public NumMatrix(int[][] matrix) {
        m = matrix.length;
        n = matrix[0].length;
        bit = new int[m+1][n+1];
        
        init(matrix);     
    }
    
    public void init(int[][] matrix) {
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                update(i, j, matrix[i][j]);
            }      
        }   
    }
    
    public void update(int r, int c, int val) {
        int diff = val - sumRegion(r, c, r, c);
        r++;
        c++;
        for (int i=r; i<=m; i += (i&-i)) {
            for (int j=c; j<=n; j += (j&-j)) {
                bit[i][j] += diff;
            }
        }
    }
    
    public int sum(int r, int c) {
        r++;
        c++;
        int sum = 0;
        for (int i=r; i>0; i -= (i&-i)) {
            for (int j=c; j>0; j -= (j&-j)) {
                sum += bit[i][j]; 
            }
        }
        return sum;
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
            return sum(row2, col2) - sum(row1-1, col2) - sum(row2, col1-1) + sum(row1-1, col1-1);    
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * obj.update(row,col,val);
 * int param_2 = obj.sumRegion(row1,col1,row2,col2);
 */
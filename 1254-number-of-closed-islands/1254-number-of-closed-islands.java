class Solution {
    public void changeZerotoOne(int i, int j, int[][] grid, int m, int n) {
        grid[i][j] = 1;
        if (i>0 && grid[i-1][j] == 0) changeZerotoOne(i-1, j, grid, m, n);
        if (i<m-1 && grid[i+1][j] == 0) changeZerotoOne(i+1, j, grid, m, n);
        if (j>0 && grid[i][j-1] == 0) changeZerotoOne(i, j-1, grid, m, n);
        if (j<n-1 && grid[i][j+1] == 0) changeZerotoOne(i, j+1, grid, m, n);
    }
    
    public int closedIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        for (int i=0; i<m; i++) {
            if (grid[i][0] == 0) changeZerotoOne(i, 0, grid, m, n);
            if (grid[i][n-1] == 0) changeZerotoOne(i, n-1, grid, m, n);
        }
        for (int j=0; j<n; j++) {
            if (grid[0][j] == 0) changeZerotoOne(0, j, grid, m, n);
            if (grid[m-1][j] == 0) changeZerotoOne(m-1, j, grid, m, n);
        }
        
        int ans = 0;
        for (int i=1; i<m-1; i++) {
            for (int j=1; j<n-1; j++) {
                if (grid[i][j] == 0) {
                    changeZerotoOne(i, j, grid, m, n);
                    ans++;
                }
            }
        }
        
        return ans;
        
    }
}
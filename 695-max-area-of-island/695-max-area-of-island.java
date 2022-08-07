class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int ans = 0;
        int m = grid.length;
        int n = grid[0].length;
        int[] tmp_count = new int[1];
        
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (grid[i][j] == 1) {
                    tmp_count[0] = 0;
                    myFunc(grid, i, j, tmp_count);
                    ans = ans > tmp_count[0] ? ans : tmp_count[0];
                }
            }
        }
        
        return ans;
    }
    
    public void myFunc(int[][] grid, int r, int c, int[] count) {
        if (grid[r][c] == 1) {
            count[0]++;
            grid[r][c] = 0;
            if (r>0) myFunc(grid, r-1, c, count);
            if (r<grid.length-1) myFunc(grid, r+1, c, count);
            if (c>0) myFunc(grid, r, c-1, count);
            if (c<grid[0].length-1) myFunc(grid, r, c+1, count);
        }

    }
}
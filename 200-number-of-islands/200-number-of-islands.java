class Solution {
    public int numIslands(char[][] grid) {
        int ans = 0;
        for (int i=0; i<grid.length; i++) {
            for (int j=0; j<grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    makeZero(i, j, grid);
                    ans++;
                }
            }
        }
        return ans;
    }
    
    public void makeZero(int i, int j, char[][] grid) {
        grid[i][j] = 0;
        if (i>0 && (grid[i-1][j] == '1')) makeZero(i-1, j, grid);
        if (i<grid.length-1 && (grid[i+1][j] == '1')) makeZero(i+1, j, grid);
        if (j>0 && (grid[i][j-1] == '1')) makeZero(i, j-1, grid);
        if (j<grid[0].length-1 && (grid[i][j+1] == '1')) makeZero(i, j+1, grid);
    }
}
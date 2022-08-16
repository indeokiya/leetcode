class Solution {
    private Queue<int[]> q;
    private int n;
    private int[] dr = {0, 1, 1, 1, 0, -1, -1, -1};
    private int[] dc = {1, 1, 0, -1, -1, -1, 0, 1};
    
    public void bfs(int[][] grid, int i, int j) {
        int new_row, new_col;
        for (int it=0; it<8; it++) {
            new_row = i+dr[it];
            new_col = j+dc[it];
            if (new_row >= 0 && new_row < n && new_col>=0 && new_col < n && grid[new_row][new_col] == 0) {
                // System.out.println(new_row + " " + new_col);
                grid[new_row][new_col] = 1;
                q.add(new int[]{new_row, new_col});
            }
        }
    }
    
    public int shortestPathBinaryMatrix(int[][] grid) {
        n = grid.length;
        if (grid[n-1][n-1] != 0 || grid[0][0] != 0) return -1;
        
        q = new LinkedList<>();
        q.add(new int[]{0, 0});
        grid[0][0] = 1;
        
        int ans = 0;
        int size;
        int x, y;
        boolean ans_exist = false;
        while (!q.isEmpty()) {
            size = q.size();
            for (int i=0; i<size; i++) {
                x = q.peek()[0];
                y = q.poll()[1];
                if (x==n-1 && y==n-1) {
                    ans_exist = true;
                    q.clear();
                    break;
                }
                bfs(grid, x, y);
            }
            ans++;
        }
        
        if (ans_exist) return ans;
        return -1;
    }
}
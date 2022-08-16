class Solution {
    private Queue<int[]> q;
    
    public void bfs(int[][] arr, int i, int j) {
        if (i>0 && arr[i-1][j] == 0) {
            q.add(new int[]{i-1, j});
            arr[i-1][j] = 1;
        }
        if (i<arr.length-1 && arr[i+1][j] == 0) {
            q.add(new int[]{i+1, j});
            arr[i+1][j] = 1;
        }
        if (j>0 && arr[i][j-1] == 0) {
            q.add(new int[]{i, j-1});
            arr[i][j-1] = 1;
        }
        if (j<arr.length-1 && arr[i][j+1] == 0) {
            q.add(new int[]{i, j+1});
            arr[i][j+1] = 1;
        }
    }
    
    public int maxDistance(int[][] grid) {
        q = new LinkedList<>();
        
        for (int i=0; i<grid.length; i++) {
            for (int j=0; j<grid.length; j++) {
                if (grid[i][j] == 1) {
                    q.add(new int[]{i, j});
                }
            }
        }
        
        if (q.isEmpty() || q.size() == grid.length*grid.length) {
            return -1;
        }
        
        int ans = -1;
        int size;
        while(!q.isEmpty()) {
            size = q.size();
            for (int i=0; i<size; i++) {
                bfs(grid, q.peek()[0], q.poll()[1]);               
            }
            ans++;
        }
        
        return ans > 0 ? ans : 0;
    }
}
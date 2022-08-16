class Solution {
    private int[][] distance;
    private int[][] arr;
    private Queue<Integer> q;
    
    public void bfs(int i, int j) {
        if (i>0 && arr[i-1][j] == 0) {
            q.add((i-1)*arr.length+j);
            arr[i-1][j] = 1;
            distance[i-1][j] = distance[i][j] + 1;
        }
        if (i<arr.length-1 && arr[i+1][j] == 0) {
            q.add((i+1)*arr.length+j);
            arr[i+1][j] = 1;
            distance[i+1][j] = distance[i][j] + 1;
        }
        if (j>0 && arr[i][j-1] == 0) {
            q.add(i*arr.length+j-1);
            arr[i][j-1] = 1;
            distance[i][j-1] = distance[i][j] + 1;
        }
        if (j<arr.length-1 && arr[i][j+1] == 0) {
            q.add(i*arr.length+j+1);
            arr[i][j+1] = 1;
            distance[i][j+1] = distance[i][j] + 1;
        }
    }
    
    public int maxDistance(int[][] grid) {
        distance = new int[grid.length][grid.length];
        arr = grid;
        q = new LinkedList<>();
        
        for (int i=0; i<arr.length; i++) {
            for (int j=0; j<arr.length; j++) {
                if (arr[i][j] == 1) {
                    q.add(i*arr.length+j);
                }
            }
        }
        
        if (q.isEmpty() || q.size() == grid.length*grid.length) {
            return -1;
        }
        
        while(!q.isEmpty()) {
            bfs(q.peek()/arr.length, q.poll()%arr.length);
        }
        
        int ans = 0;
        for (int i=0; i<arr.length; i++) {
            for (int j=0; j<arr.length; j++) {
                if (distance[i][j] > ans) ans = distance[i][j];
            }
        }
        
        return ans;
    }
}
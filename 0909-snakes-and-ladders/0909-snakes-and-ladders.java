class Solution {
    private boolean[][] visited;
    
    public int snakesAndLadders(int[][] board) {
        int iter = 0;
        int N = board.length;
        visited = new boolean[N][N];
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-->0) {
                int index = q.poll();
                int r = N-1 - index/N;
                int c = (index/N)%2==0 ? index%N : N-1-index%N;
                if (board[r][c] != -1) {
                    index = board[r][c] -1;
                    r = N-1 - index/N;
                    c = (index/N)%2==0 ? index%N : N-1-index%N;
                }
                if (index == N*N-1) {
                    return iter;
                }
                
                if (visited[r][c]) {
                    continue;
                }
                visited[r][c] = true;
                
                for (int curr=index+1; curr<=Math.min(index+6, N*N-1); curr++) {
                    q.add(curr);
                }
            }
            iter++;
        }
        
        return -1;
    }
}
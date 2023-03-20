struct Pos {
    int r, c, dist, remaining;
    Pos(int _r, int _c, int _dist, int _remaining) {r = _r; c = _c; dist = _dist; remaining = _remaining;}
};

class Solution {
private:
    int cnt;
    int N, M;
    int dr[4] = {0, 1, 0, -1};
    int dc[4] = {1, 0, -1, 0};
    bool visited[40][40][80];
    
    bool isValid(int n, int m) {
        return n>=0 && n<N && m>=0 && m<M;
    }
    
    queue<Pos> q;
    
public: 
    int shortestPath(vector<vector<int>>& grid, int k) {
        N = grid.size();
        M = grid[0].size();
        cnt = N*M;
        if (k >= N+M-2) return N+M-2;
        
        q.push(Pos(0, 0, 0, k));
        
        while (!q.empty()) {
            Pos pos = q.front(); q.pop();
            int r = pos.r;
            int c = pos.c;
            int dist = pos.dist;
            int remaining = pos.remaining;
            if (dist + N-1 + M-1  - r - c >= cnt) continue;
            if (r==N-1 && c==M-1) {
                cnt = min(cnt, dist);
                continue;
            }
            if (visited[r][c][remaining]) continue;
            visited[r][c][remaining] = true;
            
            for (int i=0; i<4; i++) {
                int nR = r + dr[i];
                int nC = c + dc[i];
                if (!isValid(nR, nC)) continue;
                if (grid[nR][nC] && remaining > 0) {
                    q.push(Pos(nR, nC, dist+1, remaining-1));
                } else if (!grid[nR][nC]){
                    q.push(Pos(nR, nC, dist+1, remaining));
                }
            }
        }
        
        
        return cnt == N*M ? -1 : cnt;
    }
};
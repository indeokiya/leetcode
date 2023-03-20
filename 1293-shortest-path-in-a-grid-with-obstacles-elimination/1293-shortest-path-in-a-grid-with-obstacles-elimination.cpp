typedef pair<pair<int, int>, int> pp;

class Solution {
private:
    int cnt;
    int N, M;
    int dr[4] = {0, 1, 0, -1};
    int dc[4] = {1, 0, -1, 0};
    
    bool isValid(int n, int m) {
        return n>=0 && n<N && m>=0 && m<M;
    }
    
    queue<pp> q;
    
public: 
    int shortestPath(vector<vector<int>>& grid, int k) {
        N = grid.size();
        M = grid[0].size();
        cnt = N*M;
        if (k >= N+M-2) return N+M-2;
        
        vector<vector<int> > visited(N, vector<int>(M, INT_MAX));
        visited[0][0] = 0;
        
        q.push({{0, 0}, 0});
        
        while (!q.empty()) {
            int r = q.front().first.first;
            int c = q.front().first.second;
            int cost = q.front().second;
            q.pop();
            
            if (r==N-1 && c==M-1) {
                return cost;
            }
            
            for (int i=0; i<4; i++) {
                int nR = r + dr[i];
                int nC = c + dc[i];
                if (!isValid(nR, nC)) continue;
                if (visited[nR][nC] > visited[r][c] + grid[nR][nC]) {
                    visited[nR][nC] = visited[r][c] + grid[nR][nC];
                    if (visited[nR][nC] <= k) {
                        q.push({{nR, nC}, cost+1});
                    }
                }
            }
        }
        
        
        return -1;
    }
};
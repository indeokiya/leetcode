typedef pair<pair<int, int>, int> pp;

class Solution {
private:
    queue<pp> q;
    int dr[4] = {0, 1, 0, -1};
    int dc[4] = {1, 0, -1, 0};
    
public:
    int minimumObstacles(vector<vector<int>>& grid) {
        int m = grid.size();
        int n = grid[0].size();
        vector<vector<int>> visited(m, vector<int>(n, INT_MAX));
        
        visited[0][0] = 0;
        q.push({{0, 0}, 0});
        
        while (!q.empty()) {
            int r = q.front().first.first;
            int c = q.front().first.second;
            int cost = q.front().second;
            q.pop();
            
            for (int i=0; i<4; i++) {
                int nR = r + dr[i];
                int nC = c + dc[i];
                if (nR<0 || nR >= m || nC < 0 || nC >= n) continue;
                if (visited[nR][nC] > visited[r][c] + grid[nR][nC]) {
                    visited[nR][nC] = visited[r][c] + grid[nR][nC];
                    q.push({{nR, nC}, cost + grid[nR][nC]});
                }
            }
            
        }
        
        
        return visited[m-1][n-1];
    }
};
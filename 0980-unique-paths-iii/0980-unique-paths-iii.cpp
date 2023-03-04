class Solution {
private:
    int m, n, startX, startY, destX, destY, ans, target;
    int dr[4] = {0, 1, 0, -1};
    int dc[4] = {1, 0, -1, 0};
    bool visited[20][20];
    
    bool isValid(int r, int c) {
        return r>=0 && r<m && c>=0 && c<n;
    }
    
    void backtracking(int r, int c, int num, vector<vector<int>>& grid) {
        if (r == destX && c == destY) {
            if (num == target) ans++;
            return;
        }
        
        visited[r][c] = true;
        for (int i=0; i<4; i++) {
            int nR = r + dr[i];
            int nC = c + dc[i];
            if (!isValid(nR, nC) || grid[nR][nC] == -1 || visited[nR][nC]) continue;
            backtracking(nR, nC, num + 1, grid);
        }
        visited[r][c] = false;
    }
    
    void init(vector<vector<int>>& grid) {
        m = grid.size();
        n = grid[0].size();
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (grid[i][j] == -1) {
                    continue;
                } else if (grid[i][j] == 1) {
                    startX = i; startY = j;
                } else if (grid[i][j] == 2) {
                    destX = i; destY = j;
                }
                target++;
            }
        }
    }
    
public:
    int uniquePathsIII(vector<vector<int>>& grid) {
        init(grid);
        backtracking(startX, startY, 1, grid);
        return ans;
    }
};
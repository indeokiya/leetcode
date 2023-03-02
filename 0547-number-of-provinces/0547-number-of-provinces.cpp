class Solution {

private:
    int uf[200];
    
    int find(int n) {
        if (uf[n] < 0) return n;
        return uf[n] = find(uf[n]);
    }
    
    bool merge(int i, int j) {
        int a = find(i);
        int b = find(j);
        if (a == b) return false;
        uf[a] += uf[b];
        uf[b] = a;
        return true;
    }
    
    
public:
    int findCircleNum(vector<vector<int>>& isConnected) {
        memset(uf, -1, sizeof(uf));
        int n = isConnected.size();
        int ans = n;
        for (int i=0; i<n-1; i++) {
            for (int j=i+1; j<n; j++) {
                if (isConnected[i][j] && merge(i, j)) {
                    ans--;
                }
            }
        }
        
        return ans;
    }
};
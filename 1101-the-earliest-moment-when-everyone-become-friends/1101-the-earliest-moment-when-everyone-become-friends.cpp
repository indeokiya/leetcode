class Solution {
private:
    int uf[100];
    int cnt, N;
    
    int find(int n) {
        if (uf[n] < 0) return n;
        return uf[n] = find(uf[n]);
    }
    
    bool merge(int a, int b) {
        int aa = find(a);
        int bb = find(b);
        if (aa != bb) {
            if (++cnt == N-1) return true;
            uf[aa] += uf[bb];
            uf[bb] = aa;
        }
        return false;
    }
    
    
public:
    int earliestAcq(vector<vector<int>>& logs, int n) {
        if (logs.size() < n-1) return -1;
        
        N = n;
        memset(uf, -1, sizeof(int) * N);
        sort(logs.begin(), logs.end());
        
        for (vector<int> log : logs) {
            if (merge(log[1], log[2])) return log[0];
        }
        
        return -1;
    }
};
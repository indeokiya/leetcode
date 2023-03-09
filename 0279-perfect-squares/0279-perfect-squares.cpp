class Solution {
private:
    int memo[10001];
    int ans;
        
public: 
    int getMemo(int n) {
        int &curr = memo[n];
        if (curr > -1) return curr;
    
        curr = INT_MAX;
        for (int i=1; i*i<=n; ++i) {
            curr = min(curr, getMemo(n - i*i) + 1);
        }
        return curr;
    }
    
    int numSquares(int n) {
        memset(memo, -1, sizeof(memo));
        memo[0] = 0;
        
        return getMemo(n);        
    
//         find(n, idx-1, 0);    
        
//         int ans = 10000;
//         for (int i=0; i<=100; i++) {
//             ans = min(visited[0][i], ans);
//         }
//         return ans;
    }
    
//     void find(int remain, int idx, int cnt) {
//         if (visited[remain][idx] > -1 && visited[remain][idx] <= cnt) return;
//         visited[remain][idx] = cnt;
//         if (remain == 0) return;
        
//         while (true) {
//             if (idx>=2) find(remain, idx-1, cnt);
//             remain -= idx*idx;
//             if (remain < 0) return;
//             find(remain, idx, cnt+1);
//         }
//     }
};
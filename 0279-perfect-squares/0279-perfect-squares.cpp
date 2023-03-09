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
            curr = min(curr, getMemo(n - i*i));
        }
        return ++curr;
    }
    
    int numSquares(int n) {
        memset(memo, -1, sizeof(memo));
        
        memo[0] = 0;
        memo[1] = 1;
        
        for (int i=2; i<=n; i++) {
            int curr = 10000;
            for (int j=1; i-j*j>=0; j++) {
                curr = min(curr, memo[i-j*j]);
            }
            memo[i] = ++curr;
        }        
    
        return memo[n];
    }
};
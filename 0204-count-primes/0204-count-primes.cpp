class Solution {
    
public:
    int countPrimes(int n) {
        if (n < 3) return 0;
        bool isPrime[n];
        memset(isPrime, true, sizeof(isPrime));
        int cnt = n >> 1;
        
        for (int i=3; i*i<n; i += 2) {
            if (isPrime[i]) {
                for (int j=i*i; j<n; j += 2*i) {
                    if (!isPrime[j]) continue;
                    isPrime[j] = false;
                    cnt--;
                }
            }
        }
        
        return cnt;
    }
};
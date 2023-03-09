class Solution {
    
public:
    int countPrimes(int n) {
        if (n==0) return 0;
        bool isPrime[n];
        memset(isPrime, false, sizeof(isPrime));
        int ret = 0;
        
        for (int i=2; i<n; i++) {
            if (!isPrime[i]) {
                ret++;
                for (int j=i; j<n; j += i) {
                    isPrime[j] = true;
                }
            }
        }
        
        return ret;
    }
};
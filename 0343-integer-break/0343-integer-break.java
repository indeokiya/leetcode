class Solution {
    public int integerBreak(int n) {
        if (n <= 3) return n-1;
        if (n == 4) return 4;

        int ans = 1;
        while (n > 0) {
            if (n == 4) {
                ans *= 4;
                break;
            }
            if (n >= 3) {
                ans *= 3;
                n -= 3;
            } else {
                ans *= 2;
                n -= 2;
            }

        }

        return ans;
    }
}

/*

dp[i] = solution

dp[2] = 1
dp[3] = 2
dp[4] = 4
dp[5] = 2*3
dp[6] = 3*3
dp[7] = 3*4
dp[8] = 2222 233   16 18 
dp[9] = 333 

dp[n] = max (i for range n-2...3 | dp[i] * n-i)

*/
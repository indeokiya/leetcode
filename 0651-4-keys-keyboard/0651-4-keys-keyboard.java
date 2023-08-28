class Solution {
    public int maxA(int n) {
        if (n <= 6) return n;
        int[] dp = new int[n+1];
        for (int i=1; i<=6; i++) dp[i] = i;

        for (int i=7; i<=n; i++) {
            for (int j=3; j<=6; j++) {
                dp[i] = Math.max(dp[i], dp[i-j] * (j-1));
            }
        }

        return dp[n];
    }
}

/*

n   dp[n]
1   1
2   2
3   3
4   4
5   5
6   6
7   9



dp[n]:
    n
    dp[n-3] * 2
    dp[n-4] * 3
    dp[n-5] * 4
    dp[n-6] * 5

*/
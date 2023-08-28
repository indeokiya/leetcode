class Solution {
    public int integerBreak(int n) {
        int[] dp = new int[n+1];

        for (int i=1; i<n; i++) {
            for (int j=1; j<=i; j++) {
                if (i+j > n) continue;
                dp[i+j] = Math.max(dp[i+j], Math.max(dp[i], i) * Math.max(dp[j], j));
            }
        }

        return dp[n];
    }
}
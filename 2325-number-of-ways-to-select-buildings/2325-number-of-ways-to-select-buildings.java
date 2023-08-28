class Solution {
    public long numberOfWays(String s) {
        int n0 = 0;
        int n1 = 0;
        long n01 = 0;
        long n10 = 0;
        long ans = 0;

        for (char c : s.toCharArray()) {
            if (c == '0') {
                ans += n01;
                n0++;
                n10 += n1;
                continue;
            }

            ans += n10;
            n1++;
            n01 += n0;
        }

        return ans;
    }
}

/*

n01 = 0
n10 = 0

                                n
0   1   0   1   0   1   0   1   0
dp[n] = dp[n-1] + arr[n] * n01
n10 += sum(1s) * arr[n]



*/
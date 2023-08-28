class Solution {
    public long numberOfWays(String s) {
        List<Long> list = new LinkedList<>();
        
        char prev = '-';
        long count = 0;

        for (char c : s.toCharArray()) {
            if (c != prev) {
                prev = c;
                list.add(count);
                count = 1;
                continue;
            }
            count++;
        }

        list.remove(0);
        list.add(count);

        if (list.size() <= 2) return 0;

        Long[] arr = list.toArray(new Long[0]);
        long[] dp = new long[arr.length];

        dp[2] = arr[0] * arr[1] * arr[2];
        long[] n01s = new long[]{arr[0]*arr[1], 0};
        long[] sums = new long[]{arr[0], arr[1]};
        int curr = 0;

        for (int i=2; i<arr.length; i++) {
            dp[i] = dp[i-1] + arr[i] * n01s[curr];
            curr ^= 1;
            n01s[curr] += sums[curr] * arr[i];
            sums[curr ^ 1] += arr[i];
        }

        return dp[arr.length-1];
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
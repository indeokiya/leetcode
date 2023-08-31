class Solution {
    public long minCost(int[] nums, int[] cost) {
        final int N = nums.length;
        int[][] numsAndcost = new int[N][2];
        for (int i=0; i<N; i++) {
            numsAndcost[i][0] = nums[i];
            numsAndcost[i][1] = cost[i];
        }
        Arrays.sort(numsAndcost, (a, b) -> a[0] - b[0]);

        long ans = 0;
        long[] preSum = new long[N];
        long[] sufSum = new long[N];
        preSum[0] = numsAndcost[0][1];
        sufSum[N-1] = numsAndcost[N-1][1];
        for (int i=1; i<N; i++) {
            ans += 1l * numsAndcost[i][1] * (numsAndcost[i][0] - numsAndcost[0][0]);
            preSum[i] = preSum[i-1] + numsAndcost[i][1];
            sufSum[N-1-i] = sufSum[N-i] + numsAndcost[N-1-i][1];
        }

        long curr = ans;
        for (int i=1; i<N; i++) {
            long gap = numsAndcost[i][0] - numsAndcost[i-1][0];
            curr += gap * (preSum[i-1] - sufSum[i]);
            ans = Math.min(ans, curr);
        }

        return ans;
    }
}
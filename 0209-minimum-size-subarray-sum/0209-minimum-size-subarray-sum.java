class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int p1 = 0, p2 = 0;
        int sum = nums[0];
        int N = nums.length;
        int ans = Integer.MAX_VALUE;

        while (p2 < N) {
            if (p1 > p2) {
                p2++;
                continue;
            }

            if (sum >= target) {
                ans = Math.min(ans, p2-p1+1);
                sum -= nums[p1++];
                continue;
            }

            if (sum < target) {
                if (++p2 >= N) {
                    break;
                }
                sum += nums[p2];
            }
        }

        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}